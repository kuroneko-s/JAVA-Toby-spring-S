package com.inflearn.config.autoconfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@DataSourceTest
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void init() {

    }

    @Test
    void template() {

    }
}
