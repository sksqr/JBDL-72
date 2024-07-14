package com.example.L12_minor_project_1.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {
    private String line1;

    private String line2;

    private String city;

    private String pincode;
}
