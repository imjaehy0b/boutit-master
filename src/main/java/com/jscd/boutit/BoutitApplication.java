package com.jscd.boutit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BoutitApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoutitApplication.class, args);

		System.out.println("스프링 시작");
	}

}
