package com.example.L15_SpringSecurity_demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PubicController {

        private static Logger LOGGER = LoggerFactory.getLogger(PubicController.class);

        @GetMapping("/hello")
        public String getHello(){
        LOGGER.info("Processing public hello request");
        return "Hello from Public";
        }
}
