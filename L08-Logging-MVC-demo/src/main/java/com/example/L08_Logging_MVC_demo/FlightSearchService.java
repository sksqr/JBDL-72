package com.example.L08_Logging_MVC_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FlightSearchService {

    @Value("${indigo.url}")
    private String indigoUrl;

    public String callIndoAPI(){
        //indigoUrl
        return indigoUrl;
    }
}
