package com.n11.graduationproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
@EnableJpaRepositories
@PropertySource("classpath:application-${spring.profiles.active:default}.yml")
public class LoanSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanSystemApplication.class, args);
	}

}
