package com.study.microservices.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class LearnMicroservicesCurrencyExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnMicroservicesCurrencyExchangeApplication.class, args);
	}

}
