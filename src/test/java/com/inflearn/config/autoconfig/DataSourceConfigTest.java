package com.inflearn.config.autoconfig;

import com.inflearn.infleantoby.App;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = App.class)
@TestPropertySource("classpath:/application.properties")
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