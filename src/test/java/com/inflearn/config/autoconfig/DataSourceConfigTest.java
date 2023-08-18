package com.inflearn.config.autoconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@DataSourceTest
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