package com.inflearn.infleantoby;

import com.inflearn.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;

@MySpringBootApplication
@AutoConfiguration
public class App {
    // standalone program
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
