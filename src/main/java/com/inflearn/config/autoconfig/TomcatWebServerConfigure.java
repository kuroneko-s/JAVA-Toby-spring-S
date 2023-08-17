package com.inflearn.config.autoconfig;

import com.inflearn.config.MyAutoConfiguration;
import com.inflearn.config.MyConditionalOnClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@MyConditionalOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfigure {
    @Value("${contextPath}")
    String contextPath;

    @Bean(name = "tomcatServletWebserverFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(Environment environment) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setContextPath(contextPath);

        return serverFactory;
    }
}
