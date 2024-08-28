package com.cloudmaturity.database.controller;

import com.cloudmaturity.database.assessment.Assessment;
import com.cloudmaturity.database.objects.Results;
import com.cloudmaturity.database.objects.TeamName;
import com.cloudmaturity.database.objects.TeamNameResponse;
import com.cloudmaturity.database.service.AssessmentService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssessmentControllerTest {

    @Autowired
    AssessmentController assessmentController;

    @Autowired
    AssessmentService assessmentService;

    Assessment Tester;
    Assessment savedAssessment;

    @BeforeAll
    public void setUp()
    {
        Tester = new Assessment("AgileTeam", 4, 5
                , 3, 2,1, 4, 1, 2, 3);
        savedAssessment = assessmentService.saveAssessment(Tester);
    }

    @AfterAll
    public void tearDown()
    {
        assessmentService.deleteAssessment(Tester.getID().toString());
    }


    @Test
    void testGetAll()
    {
        List<Assessment> assessmentList = assessmentController.getAssessmentList();
        assertNotNull(assessmentList);
    }

    @Test
    void testGetAssessmentID()
    {

        Optional result = assessmentController.getAssessment(savedAssessment.getID().toString());
        assertNotNull(result.get());
    }

    @Test
    void testGetAssessment()
    {

        Optional result = assessmentController.getAssessmentByTeam("AgileTeam");
        assertNotNull(result.get());
    }

    @Test
    void testDeleteAssessment()
    {
        Assessment TesterToDelete = new Assessment("AgileTeamToDelete", 4, 5
                , 3, 2,1, 4, 1, 2, 3);
        Assessment deleteAssessment = assessmentService.saveAssessment(TesterToDelete);
        String id = deleteAssessment.getID().toString();
        assessmentController.deleteAssessment(deleteAssessment.getID().toString());
        assertFalse(assessmentController.getAssessment(id).isPresent());
    }

    @Test
    void testTeamExists()
    {
        TeamName team = new TeamName("AgileTeam");
        TeamNameResponse response = assessmentController.checkIfTeamNameExists(team);
        assertTrue(response.getWasInDatabase());
    }

    @Test
    void testGetResults()
    {
        TeamName team = new TeamName("AgileTeam");
        Results results = assessmentController.getResults(team);
        assertNotNull(results.getArchitecture());
    }






}
