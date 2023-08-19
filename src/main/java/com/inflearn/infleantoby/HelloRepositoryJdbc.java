package com.inflearn.infleantoby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class HelloRepositoryJdbc implements HelloRepository {
    private final JdbcTemplate jdbcTemplate;

    public HelloRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Hello findHello(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from hello where name = '" + name + "'", (rs, rowNum) -> {
                Hello hello = new Hello();
                hello.setName(rs.getString("name"));
                hello.setCount(rs.getInt("count"));
                return hello;
            });
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);
        if (hello == null)
            jdbcTemplate.update("insert into hello values (?, ?)", name, 1);
        else
            jdbcTemplate.update("update hello set count = ? where name = ?", hello.getCount() + 1, hello.getName());
    }

    @Override
    public void insertHello(Hello hello) {
        jdbcTemplate.update("insert into hello values(?, ?)", hello.getName(), hello.getCount());
    }
}
