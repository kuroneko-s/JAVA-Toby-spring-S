package com.inflearn.infleantoby;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// SpringBootTest를 사용하면 Web을 실행한 후 테스트가 동작한다.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // 내가 지정한 포트 사용
class AppTest {
    @Test
    void helloTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        String nameParameter = "dong";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:7070/api/hello?name={name}", String.class, nameParameter);

        assertEquals(responseEntity.getStatusCode().value(), 200);
        assertTrue(Objects.requireNonNull(responseEntity.getBody()).contains("hello " + nameParameter));
        assertTrue(Objects.requireNonNull(responseEntity.getHeaders().getContentType()).toString().startsWith(MediaType.TEXT_PLAIN_VALUE));
    }

}
