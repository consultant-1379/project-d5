package com.cloudmaturity.answerprocessing.controllers;

import com.cloudmaturity.answerprocessing.logic.ProcessAnswers;
import com.cloudmaturity.answerprocessing.objects.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/processAnswers")
@CrossOrigin
public class AnswersController
{
    @Autowired
    private RestTemplate restTemplate;

    private final String DATABASE_MICROSERVICE_URL = "http://database-microservice:9090/sendResults";
    private final ProcessAnswers pa = new ProcessAnswers();

    @PostMapping(consumes={"application/json", "application/xml"}, produces={"application/json","application/xml"})
    public ResponseEntity<String> answerProcess(@RequestBody Answers answers)
    {
        return restTemplate.postForEntity(DATABASE_MICROSERVICE_URL, pa.process(answers), String.class);
    }
}
