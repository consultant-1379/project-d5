package com.cloudmaturity.database.service;

import com.cloudmaturity.database.assessment.Assessment;
import com.cloudmaturity.database.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepo;

    public List<Assessment> assessmentList() {
        return assessmentRepo.findAll();
    }

    public Optional<Assessment> assessment(String id) {
        return assessmentRepo.findById(id);
    }

    public Optional<Assessment> assessmentName(String teamName) {
        return Optional.ofNullable(assessmentRepo.findByName(teamName));
    }

    public Assessment saveAssessment(Assessment assessment) {
        return assessmentRepo.save(assessment);
    }

    public void deleteAssessment(String id) {
        assessmentRepo.deleteById(id);
    }

    public Assessment updateAssessment(Assessment assessment) throws Exception {
        Optional<Assessment> assessmentInfo = assessmentRepo.findById(assessment.getID());
        if (assessmentInfo.isPresent()) {
            return saveAssessment(assessment);
        } else {
            throw new Exception();
        }
    }
}
