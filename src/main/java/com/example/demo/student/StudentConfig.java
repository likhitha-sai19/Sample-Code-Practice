package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository)
	{
		return args -> {
			Student mariam = new Student(
			"Mariam",
			LocalDate.of(2000, 1, 5),
			"mariam.jamal@gmail.com"
			);
			
			Student alex = new Student(
					"Alex",
					LocalDate.of(2004, 1, 5),
					"alex@gmail.com"
					);
			repository.saveAll(List.of(mariam, alex));
		}; 
	}
}
