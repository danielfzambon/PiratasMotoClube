package com.piratas.piratas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("com.piratas.piratas.repositories")
public class PiratasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiratasApplication.class, args);
		
		System.out.println("Olá Pirata : Toca o sino");
		
	}

}
