package com.inflearn.infleantoby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceTest {
    @Test
    void simpleTestService() {
        SimpleTestService simpleTestService = new SimpleTestService();

        String result = simpleTestService.hello("Dong");

        assertEquals(result, "hello Dong");

    }
}
