package com.example.L11_AOP_Demo;


import com.example.L11_AOP_Demo.aspect.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class AOPService {

    @LogExecutionTime
    public String getMsg(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Hello from :"+Thread.currentThread().getName();
    }
}
