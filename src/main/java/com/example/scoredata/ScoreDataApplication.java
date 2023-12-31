package com.example.scoredata;

import io.camunda.zeebe.spring.client.EnableZeebeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableZeebeClient
@SpringBootApplication
public class ScoreDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreDataApplication.class, args);
	}

}
