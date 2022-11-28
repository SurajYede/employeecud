package com.microservices.employeeappcrudop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmployeeappcrudopApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeappcrudopApplication.class, args);
	}

}
