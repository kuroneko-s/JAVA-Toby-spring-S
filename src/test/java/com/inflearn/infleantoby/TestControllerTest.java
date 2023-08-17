package com.inflearn.infleantoby;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestControllerTest {

    @Test
    void controllerSimpleTest() {
        TestController testController = new TestController(new SimpleTestService(), null);

        assertThrows(IllegalArgumentException.class, () -> testController.hello(null));
    }

    @Test
    void stringTest() {
        System.out.println(String.class.getClassLoader());
    }
}
