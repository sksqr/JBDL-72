package com.example.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {


    @NotNull
    private String name;


    @NotNull
    private String email;


    @NotNull
    private String phone;


    @NotNull
    private String kycNumber;
}
