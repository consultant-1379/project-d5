package com.cloudmaturity.database.controller;

import com.cloudmaturity.database.objects.Results;
import com.cloudmaturity.database.objects.TeamName;
import com.cloudmaturity.database.objects.TeamNameResponse;
import com.cloudmaturity.database.service.AssessmentService;
import com.cloudmaturity.database.assessment.Assessment;
import com.cloudmaturity.database.objects.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;

    @GetMapping("/assessment")
    public List<Assessment> getAssessmentList() {
        return assessmentService.assessmentList();
    }

    @PostMapping("/create/assessment")
    public Assessment createAssessment(@RequestBody Assessment assessment) {
        return assessmentService.saveAssessment(assessment);
    }


    @GetMapping("assessment/{id}")
    public Optional<Assessment> getAssessment(@PathVariable String id) {
        return assessmentService.assessment(id);
    }

    @GetMapping("assessment/Team/{teamName}")
    public Optional<Assessment> getAssessmentByTeam(@PathVariable String teamName) {
        return assessmentService.assessmentName(teamName);
    }

    @DeleteMapping("assessment/{id}")
    public void deleteAssessment(@PathVariable String id) {
        assessmentService.deleteAssessment(id);
    }

    @PostMapping("/checkTeamName")
    public TeamNameResponse checkIfTeamNameExists(@RequestBody TeamName teamName) {
        if (assessmentService.assessmentName(teamName.getTeamName()).isPresent()) {
            return new TeamNameResponse(true);
        } else {
            assessmentService.saveAssessment(new Assessment(teamName.getTeamName(),
                    0, 0, 0, 0, 0, 0,
                    0, 0, 0));
            return new TeamNameResponse(false);
        }
    }

    @PostMapping("/getResults")
    public Results getResults(@RequestBody TeamName teamName) {
        Optional<Assessment> assessment = assessmentService.assessmentName(teamName.getTeamName());
        if (!assessment.isPresent()) {
            return new Results(0, 0, 0, 0, 0, 0, 0, 0, 0);
        } else {
            return new Results(assessment.get().getCultureScore(),
                    assessment.get().getProdServiceDesignScore(),
                    assessment.get().getTeamScore(),
                    assessment.get().getProcessScore(),
                    assessment.get().getArchitectureScore(),
                    assessment.get().getMaintenanceScore(),
                    assessment.get().getDeliveryScore(),
                    assessment.get().getProvisioningScore(),
                    assessment.get().getInfrastructureScore());
        }
    }

    @PostMapping("/sendResults")
    public ResponseEntity<String> registerResults(@RequestBody Result result)
    {
        Optional<Assessment> assessment = assessmentService.assessmentName(result.getTeamName());
        if(assessment.isPresent())
        {
           Assessment toInsert = result.amendAssessment(assessment.get());
           assessmentService.saveAssessment(toInsert);
            return new ResponseEntity<>("Inserted Result", HttpStatus.OK);
        }
        else { return new ResponseEntity<>("Failed to Insert Result", HttpStatus.OK); }
    }
}


