package com.inflearn.infleantoby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    public String hello(String name) {
        return testService.hello(Objects.requireNonNull(name));
    }
}
