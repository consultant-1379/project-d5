package com.cloudmaturity.database.objects;

import com.cloudmaturity.database.assessment.Assessment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResultTest {


    Result result;
    private Assessment assesmentB;

    @BeforeAll
    public void setUp()
    {
        result  = new Result("ResTeam", "Test", 4);
        assesmentB = new Assessment("Agile", 4, 5
                , 3, 2,1, 4, 1, 2, 3);

    }

    @Test
    void testteamName()
    {
        assertEquals("ResTeam",result.getTeamName());
    }

    @Test
    void testCatName()
    {
        assertEquals("Test",result.getCategory());
    }

    @Test
    void testResultName()
    {
        assertEquals(4,result.getResult());
    }

    @Test
    void testAmendment()
    {
        Result resultCulture  = new Result("ResTeam", "Culture", 4);
        Assessment amended = resultCulture.amendAssessment(assesmentB);
        assertNotNull(amended);
    }

    @Test
    void testAmendmentCulture()
    {
        Result resultCulture  = new Result("ResTeam", "culture", 4);
        Assessment amended = resultCulture.amendAssessment(assesmentB);
        assertEquals("culture",resultCulture.getCategory());
    }

    @Test
    void testAmendmentProdservicedesign()
    {
        Result resultprodservicedesign  = new Result("ResTeam", "prodservicedesign", 4);
        Assessment amended = resultprodservicedesign.amendAssessment(assesmentB);
        assertEquals("prodservicedesign",resultprodservicedesign.getCategory());
    }

    @Test
    void testAmendmentTeam()
    {
        Result resultteam  = new Result("ResTeam", "team", 4);
        Assessment amended = resultteam.amendAssessment(assesmentB);
        assertEquals("team",resultteam.getCategory());
    }

    @Test
    void testAmendmentProcess()
    {
        Result resultprocess  = new Result("ResTeam", "process", 4);
        Assessment amended = resultprocess.amendAssessment(assesmentB);
        assertEquals("process",resultprocess.getCategory());
    }

    @Test
    void testAmendmentArchitecture()
    {
        Result resultarchitecture  = new Result("ResTeam", "architecture", 4);
        Assessment amended = resultarchitecture.amendAssessment(assesmentB);
        assertEquals("architecture",resultarchitecture.getCategory());
    }

    @Test
    void testAmendmentMaintenance()
    {
        Result resultmaintenance  = new Result("ResTeam", "maintenance", 4);
        Assessment amended = resultmaintenance.amendAssessment(assesmentB);
        assertEquals("maintenance",resultmaintenance.getCategory());
    }

    @Test
    void testAmendmentDelivery()
    {
        Result resultdelivery  = new Result("ResTeam", "delivery", 4);
        Assessment amended = resultdelivery.amendAssessment(assesmentB);
        assertEquals("delivery",resultdelivery.getCategory());
    }

    @Test
    void testAmendmentProvisioning()
    {
        Result resultprovisioning  = new Result("ResTeam", "provisioning", 4);
        Assessment amended = resultprovisioning.amendAssessment(assesmentB);
        assertEquals("provisioning",resultprovisioning.getCategory());
    }

    @Test
    void testAmendmentInfrastructure()
    {
        Result resultinfrastructure  = new Result("ResTeam", "infrastructure", 4);
        Assessment amended = resultinfrastructure.amendAssessment(assesmentB);
        assertEquals("infrastructure",resultinfrastructure.getCategory());
    }

}
