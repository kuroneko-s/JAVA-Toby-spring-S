package com.inflearn.infleantoby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InfleanTobyApplication {

    // standalone program
    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean(TestController.class);
        applicationContext.registerBean(SimpleTestService.class);
        applicationContext.refresh(); // 상태 갱신.

        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                    // 인증 처리.
                    // 보안 처리.
                    // 다국어 처리.
                    // 공통 처리.

                    // WebContainer의 Servlet에 Mapping해주는 역할 진행.
                    if (req.getMethod().equals(HttpMethod.GET.name()) && req.getRequestURI().equals("/hello")) {
                        String name = req.getParameter("name");

                        TestController testController = applicationContext.getBean(TestController.class);
                        // applicationContext.getBeanDefinitionNames();
                        String hello = testController.hello(name);

                        resp.setStatus(HttpStatus.OK.value()); // default status is 200
                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        // resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(hello);
                    } else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });

        webServer.start();
    }
}
