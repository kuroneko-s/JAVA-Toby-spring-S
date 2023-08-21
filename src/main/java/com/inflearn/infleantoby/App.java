package com.inflearn.infleantoby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class App {
    // implements InitializingBean 예전애 초기화 사용하던 객체.
    private final JdbcTemplate jdbcTemplate;

    public App(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct // 초기화 후 동작
    void init() {
        jdbcTemplate.execute("CREATE TABLE if not exists hello(name varchar(50) primary key, count int)");
    }

    // standalone program
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
