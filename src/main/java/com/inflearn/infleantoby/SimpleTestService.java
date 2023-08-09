package com.inflearn.infleantoby;

public class SimpleTestService implements TestService{
    public String hello(String name) {
        return "hello " + name;
    }
}
