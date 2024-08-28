package com.cloudmaturity.database.service;


import com.cloudmaturity.database.assessment.Assessment;
import com.cloudmaturity.database.repository.AssessmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssessmentServiceTests{

    @Autowired
    AssessmentService assessmentservice;

    Assessment Tester;
    Assessment savedAssessment;

    @BeforeAll
    public void setUp()
    {
        Tester = new Assessment("Agile", 4, 5
         , 3, 2,1, 4, 1, 2, 3);
        savedAssessment = assessmentservice.saveAssessment(Tester);
    }

    @AfterAll
    public void tearDown()
    {
        assessmentservice.deleteAssessment(Tester.getID().toString());
    }

    @Test
    @DisplayName("Test creation")
    void testAssessmentCreated()
    {

       // Assessment Tester = new Assessment("Agile", 4, 5
      //          , 3, 2,1, 4, 1, 2, 3);

     //   Assessment savedAssessment = assessmentservice.saveAssessment(Tester);
        assertNotNull(savedAssessment.getID());

    }

    @Test
    @DisplayName("Test creation")
    void testAssessmentName() {

       // Assessment Tester = new Assessment("Agile4", 4, 5
        //        , 3, 2,1, 4, 1, 2, 3);

      //  Assessment savedAssessment = assessmentservice.saveAssessment(Tester);
        Optional<Assessment> optionalName = assessmentservice.assessmentName("Agile");
        assertNotNull(optionalName.get());

    }

    @Test
    @DisplayName("Test creation")
    void testAssessmentByID() {

        // Assessment Tester = new Assessment("Agile4", 4, 5
        //        , 3, 2,1, 4, 1, 2, 3);

        //  Assessment savedAssessment = assessmentservice.saveAssessment(Tester);
        Optional<Assessment> optionalName = assessmentservice.assessment(savedAssessment.getID().toString());
        assertNotNull(optionalName.get());

    }

    @Test
    @DisplayName("Test creation")
    void testAssessmentLst() {

        // Assessment Tester = new Assessment("Agile4", 4, 5
        //        , 3, 2,1, 4, 1, 2, 3);

        //  Assessment savedAssessment = assessmentservice.saveAssessment(Tester);
        List<Assessment> assessments = assessmentservice.assessmentList();
        assertFalse(assessments.isEmpty());

    }

    @Test
    @DisplayName("Test creation")
    void testAssessmentDelete() {

        Assessment TesterForDelete = new Assessment("AgileDelete", 4, 5
                , 3, 2,1, 4, 1, 2, 3);

        Assessment AssessmentToDelete = assessmentservice.saveAssessment(TesterForDelete);
        assessmentservice.deleteAssessment(AssessmentToDelete.getID().toString());
        assertFalse(assessmentservice.assessmentName("AgileDelete").isPresent());


    }

    @Test
    @DisplayName("Test creation")
    void testAssessmentUpdate() {

        Assessment addedAssesment = new Assessment("AgileNew", 4, 5
                , 3, 2,1, 4, 1, 2, 3);
        try {
            Assessment newAssessment = assessmentservice.updateAssessment(addedAssesment);
            assertNotNull(newAssessment.getID());

        }catch(Exception E){

        }



    }


    @Test
    @DisplayName("Testing Exception")
    public void ExceptionThrownUpdate() {

        //AssessmentService assessmentserv = mock(AssessmentService.class);
        //doThrow(new Exception()).when(assessmentserv).deleteAssessment("Not in the DB");
        //assessmentserv.deleteAssessment("Not in the DB");
        assertThrows(Exception.class,() -> assessmentservice.updateAssessment(null));
    }

}