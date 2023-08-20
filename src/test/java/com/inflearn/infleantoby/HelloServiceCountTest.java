package com.inflearn.infleantoby;

import com.inflearn.config.autoconfig.DataSourceTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Enumeration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataSourceTest
public class HelloServiceCountTest {
    @Autowired
    private TestService testService;

    @Autowired
    private HelloRepository helloRepository;

    @Test
    void hello() {
        IntStream.range(0, 10).forEach(number -> {
            testService.hello("dong");
            assertEquals(helloRepository.countOf("dong"), number + 1);
        });
    }
}
