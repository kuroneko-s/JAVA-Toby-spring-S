package com.inflearn.infleantoby;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(name);
        }

        return testService.hello(name);
    }

    @GetMapping("/count")
    public String count(String name) {
        return "name : " + testService.countOf(name);
    }
}
