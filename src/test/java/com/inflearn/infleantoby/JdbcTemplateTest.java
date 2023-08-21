package com.inflearn.infleantoby;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {
        jdbcTemplate.execute("CREATE TABLE if not exists hello(name varchar(50) primary key, count int)");
    }

    @Test
    void template() {
        jdbcTemplate.update("insert into hello values(?, ?)", "dong", 1);
        jdbcTemplate.update("insert into hello values(?, ?)", "choi", 3);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertEquals(count, 2);
    }
}
