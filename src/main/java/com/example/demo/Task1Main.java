package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Task1Main 
{
	public static void main(String[] args)
	{
		SpringApplication.run(Task1Application.class, args);
	}
	//Bean anotacija govori Springu da je u konfiguracijskoj klasi metoda koja je anotirana tom anotacijom treba da bude registrovana kao bean.
 @Bean
 public RestTemplate getRestTemplate() 
 	{
		return new RestTemplate();
	}
}
