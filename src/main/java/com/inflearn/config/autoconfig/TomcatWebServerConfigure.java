package com.inflearn.config.autoconfig;

import com.inflearn.config.MyAutoConfiguration;
import com.inflearn.config.MyConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfiguration
@MyConditionalOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfigure {
    @Bean(name = "tomcatServletWebserverFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}
