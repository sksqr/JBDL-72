package com.example.L08_restfull_services_demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AppResponse<T> {
    private T response;
    private Integer errorCode;
    private String errorMessage;
}
