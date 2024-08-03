package com.example.L17_minor_project_2.service;

import com.example.L17_minor_project_2.dto.AddressDto;
import com.example.L17_minor_project_2.dto.VisitDto;
import com.example.L17_minor_project_2.dto.VisitorDto;
import com.example.L17_minor_project_2.entity.Address;
import com.example.L17_minor_project_2.entity.Flat;
import com.example.L17_minor_project_2.entity.Visit;
import com.example.L17_minor_project_2.entity.Visitor;
import com.example.L17_minor_project_2.enums.VisitStatus;
import com.example.L17_minor_project_2.exception.BadRequestException;
import com.example.L17_minor_project_2.exception.NotFoundException;
import com.example.L17_minor_project_2.repo.FlatRepo;
import com.example.L17_minor_project_2.repo.VisitRepo;
import com.example.L17_minor_project_2.repo.VisitorRepo;
import com.example.L17_minor_project_2.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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


    @Autowired
    private RedisTemplate<String, VisitorDto> redisTemplate;

    public VisitorDto getVisitor(String idNumber){
        /*
        Cache logic
        Key: visitor:{idNumber}
        Value: Object VisitorDto
         */
        String key = "visitor:"+idNumber;
        VisitorDto visitorDto = redisTemplate.opsForValue().get(key);
        if(visitorDto == null){
            Visitor visitor = visitorRepo.findByIdNumber(idNumber);
            if(visitor != null){
                visitorDto = VisitorDto.builder()
                        .name(visitor.getName())
                        .email(visitor.getEmail())
                        .phone(visitor.getPhone())
                        .idNumber(visitor.getIdNumber())
                        .build();
            }
            redisTemplate.opsForValue().set(key,visitorDto,24, TimeUnit.HOURS );
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
