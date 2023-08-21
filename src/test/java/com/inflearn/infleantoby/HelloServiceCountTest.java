package com.inflearn.infleantoby;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
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
