package com.inflearn.infleantoby;

public interface TestService {
    String hello(String name);

    default int countOf(String name) {
        return 0;
    }
}
