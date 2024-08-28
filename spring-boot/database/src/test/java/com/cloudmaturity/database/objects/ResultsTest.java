package com.cloudmaturity.database.objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResultsTest {

    Results results;

    @BeforeAll
    public void setUp() {
        results = new Results(4, 4, 4, 4, 4, 4, 4, 4, 4);
    }

    @Test
    void testGetCulture()
    {
        assertEquals(4,results.getCulture());
    }

    @Test
    void testGetProduct_service_design()
    {
        assertEquals(4,results.getProduct_service_design());
    }

    @Test
    void testGetTeam() {
        assertEquals(4,results.getTeam());
    }

    @Test
    void testGetProcess() {
        assertEquals(4,results.getProcess());
    }

    @Test
    void testGetArchitecture() {
        assertEquals(4,results.getArchitecture());
    }

    @Test
    void testGetMaintenance() {
        assertEquals(4,results.getMaintenance());
    }

    @Test
    void testGetDelivery() {
        assertEquals(4,results.getDelivery());
    }

    @Test
    void testGetProvisioning() {
        assertEquals(4,results.getProvisioning());
    }

    @Test
    void testGetInfrastructure() {
        assertEquals(4,results.getInfrastructure());
    }
}
