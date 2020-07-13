package com.problemfighter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.*"})
public class SBQuickStart {

	public static void main(String[] args) {
		SpringApplication.run(SBQuickStart.class, args);
	}

}
