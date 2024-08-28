package com.cloudmaturity.database.objects;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TeamNameResponseTest {

    private TeamNameResponse response;

    @BeforeAll
    void setUp()
    {
        response = new TeamNameResponse(true);
    }

    @Test
    void isThere()
    {
        assertTrue(response.getWasInDatabase());
    }




}
