package com.inflearn.infleantoby;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {
    @Test
    void helloTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        String nameParameter = "dong";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/hello?name={name}", String.class, nameParameter);

        assertEquals(responseEntity.getStatusCode().value(), 200);
        assertEquals(responseEntity.getBody(), "hello " + nameParameter);
        assertTrue(Objects.requireNonNull(responseEntity.getHeaders().getContentType()).toString().startsWith(MediaType.TEXT_PLAIN_VALUE));


    }

}
