package com.inflearn.infleantoby;

import com.inflearn.config.MySpringBootApplication;
import org.springframework.boot.SpringApplication;

@MySpringBootApplication
public class App {
    // standalone program
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
