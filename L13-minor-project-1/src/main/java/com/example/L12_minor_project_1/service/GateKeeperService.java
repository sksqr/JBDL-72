package com.example.L12_minor_project_1.service;

import com.example.L12_minor_project_1.dto.AddressDto;
import com.example.L12_minor_project_1.dto.VisitDto;
import com.example.L12_minor_project_1.dto.VisitorDto;
import com.example.L12_minor_project_1.entity.Address;
import com.example.L12_minor_project_1.entity.Flat;
import com.example.L12_minor_project_1.entity.Visit;
import com.example.L12_minor_project_1.entity.Visitor;
import com.example.L12_minor_project_1.enums.VisitStatus;
import com.example.L12_minor_project_1.exception.BadRequestException;
import com.example.L12_minor_project_1.exception.NotFoundException;
import com.example.L12_minor_project_1.repo.FlatRepo;
import com.example.L12_minor_project_1.repo.VisitRepo;
import com.example.L12_minor_project_1.repo.VisitorRepo;
import com.example.L12_minor_project_1.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class GateKeeperService {

    @Autowired
    private VisitorRepo visitorRepo;

    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private VisitRepo visitRepo;

    public VisitorDto getVisitor(String idNumber){
        Visitor visitor = visitorRepo.findByIdNumber(idNumber);
        VisitorDto visitorDto = null;
        if(visitor != null){
            visitorDto = VisitorDto.builder()
                    .name(visitor.getName())
                    .email(visitor.getEmail())
                    .phone(visitor.getPhone())
                    .idNumber(visitor.getIdNumber())
                    .build();
        }
        return visitorDto;
    }

    public Long createVisitor(VisitorDto visitorDto){
        AddressDto addressDto = visitorDto.getAddress();
        Address address = commonUtil.convertAddressDTOT(addressDto);
        Visitor visitor = Visitor.builder()
                .address(address)
                .name(visitorDto.getName())
                .email(visitorDto.getEmail())
                .phone(visitorDto.getPhone())
                .idNumber(visitorDto.getIdNumber())
                .build();

        visitor = visitorRepo.save(visitor);
        return visitor.getId();
    }

    public Long createVisit(VisitDto visitDto){
        Flat flat = flatRepo.findByNumber(visitDto.getFlatNumber());
        Visitor visitor = visitorRepo.findByIdNumber(visitDto.getIdNumber());
        Visit visit = Visit.builder()
                .flat(flat)
                .imageUrl(visitDto.getUrlOfImage())
                .noOfPeople(visitDto.getNoOfPeople())
                .purpose(visitDto.getPurpose())
                .visitor(visitor)
                .status(VisitStatus.WAITING)
                .build();
        visit = visitRepo.save(visit);
        return visit.getId();
    }

    @Transactional
    public String markEntry(Long id){
        Optional<Visit> visitOptional = visitRepo.findById(id);
        if(visitOptional.isEmpty()){
            throw new NotFoundException("Visit not Found");
        }
        Visit visit = visitOptional.get();
        if(visit.getStatus().equals(VisitStatus.APPROVED)){
            visit.setInTime(new Date());
           // visitRepo.save(visit); // without Transactional
        }
        else{
            throw new BadRequestException("Invalid State Transition");
        }
        return "Done";
    }


    @Transactional
    public String markExit(Long id){
        Visit visit = visitRepo.findById(id).get();
        if(visit == null){
            throw new NotFoundException("Visit not Found");
        }
        if(visit.getStatus().equals(VisitStatus.APPROVED) && visit.getInTime() != null){
            visit.setOutTime(new Date());
            visit.setStatus(VisitStatus.COMPLETED);
        }
        else{
            throw new BadRequestException("Invalid State Transition");
        }
        return "Done";
    }
}
