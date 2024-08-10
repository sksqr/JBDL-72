package com.example.L19_circuit_breaker_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class L19CircuitBreakerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L19CircuitBreakerDemoApplication.class, args);
	}

}
