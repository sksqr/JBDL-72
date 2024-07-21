package com.example.L14_UTandITdemo.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDetailReq {
    private String name;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private Long branchId;
}
