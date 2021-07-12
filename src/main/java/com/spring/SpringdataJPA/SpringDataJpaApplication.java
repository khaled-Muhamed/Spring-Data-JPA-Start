package com.spring.SpringdataJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (StudentRepository studentRepo) {
		return args -> {
			Student maria = new Student("Maria","Johns","maria.johns@gmail.com",21);
			studentRepo.save(maria);
		};
	}

}
