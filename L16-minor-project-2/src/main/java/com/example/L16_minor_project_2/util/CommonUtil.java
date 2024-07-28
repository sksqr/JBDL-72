package com.example.L16_minor_project_2.util;

import com.example.L16_minor_project_2.dto.AddressDto;
import com.example.L16_minor_project_2.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

    public Address convertAddressDTOT(AddressDto addressDto){
        Address address = Address.builder()
                .line1(addressDto.getLine1())
                .line2(addressDto.getLine2())
                .city(addressDto.getCity())
                .pincode(addressDto.getPincode())
                .build();
        return address;
    }
}
