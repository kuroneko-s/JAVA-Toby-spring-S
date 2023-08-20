package com.inflearn.infleantoby;

import org.springframework.stereotype.Service;

@Service
public class SimpleTestService implements TestService {
    private final HelloRepository repository;

    public SimpleTestService(HelloRepository repository) {
        this.repository = repository;
    }

    public String hello(String name) {
        this.repository.increaseCount(name);

        return "hello " + name;
    }

    @Override
    public int countOf(String name) {
        return repository.countOf(name);
    }
}
