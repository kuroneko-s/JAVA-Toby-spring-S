package com.inflearn.infleantoby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceTest {
    @Test
    void simpleTestService() {
        SimpleTestService simpleTestService = new SimpleTestService(new HelloRepository() {
            @Override
            public Hello findHello(String name) {
                return null;
            }

            @Override
            public void increaseCount(String name) {

            }

            @Override
            public void insertHello(Hello hello) {

            }
        });

        String result = simpleTestService.hello("Dong");

        assertEquals(result, "hello Dong");
    }
}
