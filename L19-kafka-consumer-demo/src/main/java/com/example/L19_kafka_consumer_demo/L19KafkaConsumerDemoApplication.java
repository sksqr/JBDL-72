package com.example.L19_kafka_consumer_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class L19KafkaConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L19KafkaConsumerDemoApplication.class, args);
	}

}
