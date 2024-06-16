package com.example.L06_spring_boot_demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

    @GetMapping("/hello")
    public String getHelloResponse(){
        return "Hello from server thread:"+Thread.currentThread().getName();
    }


    @GetMapping("/bye")
    public String getByeResponse(){
        return "Bye from server thread:"+Thread.currentThread().getName();
    }

}
