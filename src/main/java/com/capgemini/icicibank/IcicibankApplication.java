package com.capgemini.icicibank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.capgemini.icicibank" })
//@EnableAutoConfiguration
public class IcicibankApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcicibankApplication.class, args);
	}
}
