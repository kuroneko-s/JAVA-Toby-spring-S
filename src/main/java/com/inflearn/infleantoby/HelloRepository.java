package com.inflearn.infleantoby;

public interface HelloRepository {
    Hello findHello(String name);

    void increaseCount(String name);

    void insertHello(Hello hello);

    default void createSample(Hello hello) {
        this.insertHello(hello);
    }

    default int countOf(String name) {
        Hello hello = findHello(name);

        return hello == null ? 0 : hello.getCount();
    }
}
