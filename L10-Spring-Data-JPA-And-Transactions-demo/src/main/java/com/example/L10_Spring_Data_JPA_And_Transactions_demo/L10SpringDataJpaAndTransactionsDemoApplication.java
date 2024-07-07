package com.example.L10_Spring_Data_JPA_And_Transactions_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class L10SpringDataJpaAndTransactionsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(L10SpringDataJpaAndTransactionsDemoApplication.class, args);
	}

}
