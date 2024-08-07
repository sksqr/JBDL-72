package com.example.L18_spring_boot_actuator_demo;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if(errorCode != 0){
            return Health.down().withDetail("Error Code",errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        // Redis connectivity
        // dependent service connectivity
        // DB connectivity
        return 0;
    }
}
