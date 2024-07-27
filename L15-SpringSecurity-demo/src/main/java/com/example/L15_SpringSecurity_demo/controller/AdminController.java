package com.example.L15_SpringSecurity_demo.controller;


import jakarta.servlet.http.HttpFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @GetMapping("/hello")
    public String getHello(){
        LOGGER.info("Processing hello request");
        return "Hello from Admin";
    }
}
//JSESSIONID=5D5326437487697440DFB2E414
//JSESSIONID=5D5326437487697440DFB2E4145C72BC
//JSESSIONID=5D5326437487697440DFB2E4145C72BC