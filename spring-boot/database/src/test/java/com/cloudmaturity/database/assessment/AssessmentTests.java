package com.cloudmaturity.database.assessment;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AssessmentTests {
    private Assessment sharedAssessment;

    @BeforeEach
    void setUp()
    {
        Assessment Tester = new Assessment("Agile", 4, 5
            , 3, 2,1, 4, 1, 2, 3);
        sharedAssessment = Tester;
    }

    @Test
    @DisplayName("Check that expected value comes back for the Team name.")
    void checkTeamName() {
        assertEquals("Agile",sharedAssessment.getTeamName());
    }

    @Test
    @DisplayName("Check that expected value comes back for the culture score.")
    void checkCultureScore() {
        assertEquals(4,sharedAssessment.getCultureScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for the product service score.")
    void checkServiceScore() {
        assertEquals(5,sharedAssessment.getProdServiceDesignScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for the Team score.")
    void checkTeamScore() {
        assertEquals(3,sharedAssessment.getTeamScore());
    }
    //////
    /////

    @Test
    @DisplayName("Check that expected value comes back for the Process score.")
    void checkProcessScore() {
        assertEquals(2,sharedAssessment.getProcessScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for the Architecture score.")
    void checkArchitectureScore() {
        assertEquals(1,sharedAssessment.getArchitectureScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for the Maintenance score.")
    void checkMaintenanceScore() {
        assertEquals(4,sharedAssessment.getMaintenanceScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for the Delivery score.")
    void checkDeliveryScore() {
        assertEquals(1,sharedAssessment.getDeliveryScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for the Provisioning score.")
    void checkProvisioningScore() {
        assertEquals(2,sharedAssessment.getProvisioningScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for the Infrastructure score.")
    void checkInfrastructureScore() {
        assertEquals(3,sharedAssessment.getInfrastructureScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetCultureScore() {
        sharedAssessment.setCultureScore(3);
        assertEquals(3,sharedAssessment.getCultureScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetProdServiceDesignScore() {
        sharedAssessment.setProdServiceDesignScore(2);
        assertEquals(2,sharedAssessment.getProdServiceDesignScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetTeamScore() {
        sharedAssessment.setTeamScore(4);
        assertEquals(4,sharedAssessment.getTeamScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetProcessScore() {
        sharedAssessment.setProcessScore(1);
        assertEquals(1,sharedAssessment.getProcessScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetArchitectureScore() {
        sharedAssessment.setArchitectureScore(3);
        assertEquals(3,sharedAssessment.getArchitectureScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetMaintenanceScore() {
        sharedAssessment.setMaintenanceScore(2);
        assertEquals(2,sharedAssessment.getMaintenanceScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetDeliveryScore() {
        sharedAssessment.setDeliveryScore(3);
        assertEquals(3,sharedAssessment.getDeliveryScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetProvisioningScore() {
        sharedAssessment.setProvisioningScore(1);
        assertEquals(1,sharedAssessment.getProvisioningScore());
    }

    @Test
    @DisplayName("Check that expected value comes back for Culture score after setting the value.")
    void checkSetInfrastructureScore() {
        sharedAssessment.setInfrastructureScore(3);
        assertEquals(3,sharedAssessment.getInfrastructureScore());
    }

}
