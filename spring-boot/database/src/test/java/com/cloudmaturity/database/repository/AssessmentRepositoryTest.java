package com.cloudmaturity.database.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AssessmentRepositoryTest {

    @Autowired
    private AssessmentRepository assessRepo;

    /*
    @Test
    void isPersonExitsById() {
        Assessment assessment = new Assessment("Agile", "22/03/2022", "Team 8", 4, 5
                , 3, 2,1, 4, 1, 2, 3);
        assessRepo.save(assessment);
        Boolean actualResult = assessRepo.isPersonExitsById(1001);
        assertThat(actualResult).isTrue();
    }*/
}