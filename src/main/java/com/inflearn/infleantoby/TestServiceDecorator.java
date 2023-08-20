package com.inflearn.infleantoby;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class TestServiceDecorator implements TestService {
    private final SimpleTestService simpleTestService;

    public TestServiceDecorator(SimpleTestService simpleTestService) {
        this.simpleTestService = simpleTestService;
    }

    @Override
    public String hello(String name) {
        return "***" + this.simpleTestService.hello(name) + "***";
    }

    @Override
    public int countOf(String name) {
        return simpleTestService.countOf(name);
    }
}
