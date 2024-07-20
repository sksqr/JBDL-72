package com.example.L12_minor_project_1.service;

import com.example.L12_minor_project_1.dto.AddressDto;
import com.example.L12_minor_project_1.dto.UserDto;
import com.example.L12_minor_project_1.entity.Address;
import com.example.L12_minor_project_1.entity.Flat;
import com.example.L12_minor_project_1.entity.User;
import com.example.L12_minor_project_1.enums.UserStatus;
import com.example.L12_minor_project_1.repo.FlatRepo;
import com.example.L12_minor_project_1.repo.UserRepo;
import com.example.L12_minor_project_1.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private CommonUtil commonUtil;


    public Long createUser(UserDto userDto){

        AddressDto addressDto = userDto.getAddress();
        Address address = commonUtil.convertAddressDTOT(addressDto);
        Flat flat = null;
        if(userDto.getFlatNo() != null){
            flat = flatRepo.findByNumber(userDto.getFlatNo());
        }
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .role(userDto.getRole())
                .idNumber(userDto.getIdNumber())
                .phone(userDto.getPhone())
                .flat(flat)
                .address(address)
                .status(UserStatus.ACTIVE)
                .build();
        user = userRepo.save(user);
        return user.getId();
    }

}
