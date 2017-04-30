package com.coison;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class EbstoresMembersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbstoresMembersServiceApplication.class, args);
	}
}
