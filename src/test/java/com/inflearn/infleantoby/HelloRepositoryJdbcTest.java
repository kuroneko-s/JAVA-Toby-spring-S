package com.inflearn.infleantoby;

import com.inflearn.config.autoconfig.DataSourceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@DataSourceTest
class HelloRepositoryJdbcTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private HelloRepository repository;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("CREATE TABLE if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void findHelloFailed() {
        Hello hello = repository.findHello("dong");
        assertNotNull(hello);
    }

    @Test
    void increaseCount() {
        assertEquals(repository.countOf("dong"), 0);

        repository.increaseCount("dong");
        assertEquals(repository.countOf("dong"), 1);

        repository.increaseCount("dong");
        assertEquals(repository.countOf("dong"), 2);
    }
}