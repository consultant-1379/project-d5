package com.cloudmaturity.questionfetching.logicTests;

import com.cloudmaturity.questionfetching.logic.RequestProcessing;
import com.cloudmaturity.questionfetching.objects.Questions;
import com.cloudmaturity.questionfetching.objects.Request;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestProcessingTests {

    RequestProcessing requestProcessing = new RequestProcessing();

    @Test
    void testCultureQuestions()
    {
        Request request = new Request("culture");
        String result = "Do you have a collaborative culture (e.g big but not specific/highly detailed goals with" +
                " no fixed delivery dates)?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testProdServiceDesignQuestions()
    {
        Request request = new Request("prodservicedesign");
        String result = "Is your product and design data driven- that is are they rapidly prototyped, deployed and " +
                "evaluated based on real customer usage before deciding on further development or retirement";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testTeamQuestions()
    {
        Request request = new Request("team");
        String result = "Are teams Devops teams that are self contained teams, responsible for all development" +
                " and deployment to production and production is monitored by SRE teams?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testProcessQuestions()
    {
        Request request = new Request("process");
        String result = "Do you use research and experimentation techniques for large and complex problems" +
                " - using lots of proof of concepts to compare options, using Kanban to clarify" +
                " the project then Agile methods like Scrum once a problem is well understood?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testArchitectureQuestions()
    {
        Request request = new Request("architecture");
        String result = "Do you have a microprocessor architecture built from independently deployable services?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testMaintenanceQuestions()
    {
        Request request = new Request("maintenance");
        String result = "Does your system collect metrics, alerts tracing and logging to provide a view of the" +
                " running system and try to keep itself alive through self healing if things" +
                " begin to deteriorate?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testDeliveryQuestions()
    {
        Request request = new Request("delivery");
        String result = "Do you deliver your releasable software multiple times a day?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testProvisioningQuestions()
    {
        Request request = new Request("provisioning");
        String result = "Do you run on Kubernetes?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

    @Test
    void testInfrastructureQuestions()
    {
        Request request = new Request("infrastructure");
        String result = "Do you deploy your software in containers?";
        Questions question = requestProcessing.processRequest(request);

        assertEquals(result,question.getQuestion0());
    }

}

