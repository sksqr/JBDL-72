package com.example.L17_minor_project_2.service;

import com.example.L17_minor_project_2.dto.AddressDto;
import com.example.L17_minor_project_2.dto.UserDto;
import com.example.L17_minor_project_2.entity.Address;
import com.example.L17_minor_project_2.entity.Flat;
import com.example.L17_minor_project_2.entity.User;
import com.example.L17_minor_project_2.enums.UserStatus;
import com.example.L17_minor_project_2.repo.FlatRepo;
import com.example.L17_minor_project_2.repo.UserRepo;
import com.example.L17_minor_project_2.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private FlatRepo flatRepo;

    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


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
                .password(passwordEncoder.encode(userDto.getPassword()))
                .flat(flat)
                .address(address)
                .status(UserStatus.ACTIVE)
                .build();
        user = userRepo.save(user);
        return user.getId();
    }

}
