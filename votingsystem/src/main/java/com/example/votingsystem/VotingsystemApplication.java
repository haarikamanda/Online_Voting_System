package com.example.votingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class VotingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingsystemApplication.class, args);
	}
	

}
