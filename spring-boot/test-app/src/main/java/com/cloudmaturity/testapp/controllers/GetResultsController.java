package com.cloudmaturity.testapp.controllers;

import com.cloudmaturity.testapp.objects.Results;
import com.cloudmaturity.testapp.objects.TeamName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/fetchResults")
@CrossOrigin
public class GetResultsController
{
    @Autowired
    private RestTemplate restTemplate;

    private final String DATABASE_MICROSERVICE_URL = "http://localhost:9089/getResults";

    @PostMapping(consumes={"application/json", "application/xml"}, produces={"application/json","application/xml"})
    public Results fetchResults(@RequestBody TeamName teamName)
    {
        return restTemplate.postForObject(DATABASE_MICROSERVICE_URL, teamName, Results.class);
    }
}
