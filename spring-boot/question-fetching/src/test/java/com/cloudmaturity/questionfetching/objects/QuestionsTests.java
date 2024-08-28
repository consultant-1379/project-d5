package com.cloudmaturity.questionfetching.objects;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class QuestionsTests {

    Questions question = new Questions("Question 0", "Question 1", "Question 2", "Question 3", "Question 4");


    @Test
    void testGetQuestion0() {
        assertEquals("Question 0",question.getQuestion0());
    }

    @Test
    void testGetQuestion1() {
        assertEquals("Question 1",question.getQuestion1());
    }

    @Test
    void testGetQuestion2() {
        assertEquals("Question 2",question.getQuestion2());
    }

    @Test
    void testGetQuestion3() {
        assertEquals("Question 3",question.getQuestion3());
    }

    @Test
    void testGetQuestion4() {
        assertEquals("Question 4",question.getQuestion4());
    }
}
