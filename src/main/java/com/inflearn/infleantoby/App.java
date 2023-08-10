package com.inflearn.infleantoby;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan(basePackages = "com.inflearn.*")
public class App {



    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    // standalone program
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
