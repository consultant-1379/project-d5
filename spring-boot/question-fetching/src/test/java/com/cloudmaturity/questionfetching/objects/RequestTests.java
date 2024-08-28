package com.cloudmaturity.questionfetching.objects;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RequestTests {

    Request request = new Request("Category");

    @Test
    void testGetCategory()
    {
        assertEquals("Category",request.getCategory());
    }


}
