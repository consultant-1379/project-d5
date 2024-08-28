package com.cloudmaturity.testapp.controllers;

import com.cloudmaturity.testapp.objects.TeamName;
import com.cloudmaturity.testapp.objects.TeamNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/checkTeamName")
@CrossOrigin
public class TeamNameCheckController
{
    @Autowired
    private RestTemplate restTemplate;

    private final String DATABASE_MICROSERVICE_URL = "http://localhost:9089/checkTeamName";

    @PostMapping(consumes={"application/json", "application/xml"}, produces={"application/json","application/xml"})
    public TeamNameResponse fetchResults(@RequestBody TeamName teamName)
    {
        return restTemplate.postForObject(DATABASE_MICROSERVICE_URL, teamName, TeamNameResponse.class);
    }
}