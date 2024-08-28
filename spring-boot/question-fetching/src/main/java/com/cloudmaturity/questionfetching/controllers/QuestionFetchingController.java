package com.cloudmaturity.questionfetching.controllers;

import com.cloudmaturity.questionfetching.logic.RequestProcessing;
import com.cloudmaturity.questionfetching.objects.Questions;
import com.cloudmaturity.questionfetching.objects.Request;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/getQuestions")
public class QuestionFetchingController
{
    private final RequestProcessing requestProcessing = new RequestProcessing();

    @PostMapping(consumes={"application/json", "application/xml"}, produces={"application/json","application/xml"})
    public Questions fetchQuestions(@RequestBody Request request)
    {
        return requestProcessing.processRequest(request);
    }
}
