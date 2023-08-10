package com.inflearn.infleantoby;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
 import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class InfleanTobyApplication {
    @Bean
    public TestController testController(TestService testService) {
        return new TestController(testService);
    }

    @Bean
    public TestService testService() {
        return new SimpleTestService();
    }

    // standalone program
    public static void main(String[] args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
                WebServer webServer = serverFactory.getWebServer(servletContext -> {
                    servletContext.addServlet("dispatcherServlet",
                                    new DispatcherServlet(this))
                            .addMapping("/*");
                });

                webServer.start();
            }
        };
        applicationContext.register(InfleanTobyApplication.class);
        applicationContext.refresh(); // 상태 갱신. Template Pattern으로 동작한다.
    }
}
