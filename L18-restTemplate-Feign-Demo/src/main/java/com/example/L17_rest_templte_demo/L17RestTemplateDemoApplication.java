package com.example.L17_rest_templte_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class L17RestTemplateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L17RestTemplateDemoApplication.class, args);
	}

}
