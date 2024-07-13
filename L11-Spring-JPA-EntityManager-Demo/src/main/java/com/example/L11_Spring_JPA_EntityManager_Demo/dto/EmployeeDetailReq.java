package com.example.L11_Spring_JPA_EntityManager_Demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailReq {
    private String name;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private Long branchId;
}
