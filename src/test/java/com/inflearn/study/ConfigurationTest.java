package com.inflearn.study;


import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class School_1 {
    private Student student;

    public School_1(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public String print() {
        return this.student.getName() + " school";
    }
}

class School_2 {
    private Student student;

    public School_2(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public String print() {
        return this.student.getName() + " school";
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Configuration
class TestConfigure {
    @Bean
    public Student student() {
        return new Student("bean1");
    }

    @Bean
    public School_1 school1() {
        return new School_1(student());
    }

    @Bean
    public School_2 school2() {
        return new School_2(student());
    }
}

class MyTestConfigureProxy extends TestConfigure {
    private Student student;

    @Override
    public Student student() {
        if (this.student == null) {
            this.student = super.student();
        }

        return student;
    }
}

public class ConfigurationTest {
    @Test
    public void proxyConfiguration() {
        MyTestConfigureProxy configure = new MyTestConfigureProxy();

        School_1 school1 = configure.school1();
        School_2 school2 = configure.school2();

        assertSame(school1.getStudent(), school2.getStudent());
    }

    @Test
    public void configuration() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TestConfigure.class);
        applicationContext.refresh();

        School_1 school1 = applicationContext.getBean(School_1.class);
        School_2 school2 = applicationContext.getBean(School_2.class);

        assertSame(school1.getStudent(), school2.getStudent());
    }
}
