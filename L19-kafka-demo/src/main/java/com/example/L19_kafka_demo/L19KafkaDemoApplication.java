package com.example.L19_kafka_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class L19KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L19KafkaDemoApplication.class, args);
	}

}
