package com.inflearn.infleantoby;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class TestController implements ApplicationContextAware {
    private final TestService testService;
    private final ApplicationContext applicationContext;

    public TestController(TestService testService, ApplicationContext applicationContext) {
        this.testService = testService;
        this.applicationContext = applicationContext;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(name);
        }

        return testService.hello(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }
}
