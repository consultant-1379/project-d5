package com.cloudmaturity.questionfetching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin
public class QuestionFetchingApplication
{
	@RequestMapping("/")
	public String home() { return "This is the default URL for the question fetching microservice"; }

	public static void main(String[] args) {
		SpringApplication.run(QuestionFetchingApplication.class, args);
	}
}
