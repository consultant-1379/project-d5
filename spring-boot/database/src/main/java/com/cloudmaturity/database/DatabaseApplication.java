package com.cloudmaturity.database;

import com.cloudmaturity.database.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@CrossOrigin
@RestController
@EnableMongoRepositories
public class DatabaseApplication {

	@Autowired
    AssessmentRepository assessmentRepo;



	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}


}