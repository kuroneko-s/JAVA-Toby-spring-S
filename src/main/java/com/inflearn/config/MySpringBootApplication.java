package com.inflearn.config;

import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
@EnableMyAutoConfiguration
public @interface MySpringBootApplication {
}
