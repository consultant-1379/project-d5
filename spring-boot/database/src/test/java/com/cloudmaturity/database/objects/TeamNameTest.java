package com.cloudmaturity.database.objects;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TeamNameTest {

    TeamName TestTeam;

    @BeforeAll
    public void setUp() {
        TestTeam = new TeamName("Test Team");
    }

    @Test
    void testGetTeamName()
    {
        assertEquals("Test Team", TestTeam.getTeamName());
    }


}
