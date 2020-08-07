package com.intake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.intake.repository")
public class IntakeSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntakeSpringBootApplication.class, args);
	}

}
