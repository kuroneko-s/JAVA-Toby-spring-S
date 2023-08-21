package com.inflearn.infleantoby;

import com.inflearn.infleantoby.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@JdbcTest
class DataSourceConfigTest {
    @Autowired
    private DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();

        System.out.println("is Closded ? - " + connection.isClosed());
        if (!connection.isClosed()) {
            connection.close();
        }
    }
}