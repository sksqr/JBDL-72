package com.example.L18_eureka_server_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class L18EurekaServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L18EurekaServerDemoApplication.class, args);
	}

}
