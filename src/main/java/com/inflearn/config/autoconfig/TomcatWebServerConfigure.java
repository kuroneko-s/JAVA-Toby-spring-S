package com.inflearn.config.autoconfig;

import com.inflearn.config.EnableMyConfigurationProperties;
import com.inflearn.config.MyAutoConfiguration;
import com.inflearn.config.MyConditionalOnClass;
import com.inflearn.config.autoconfig.properties.ServerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
@MyConditionalOnClass("org.apache.catalina.startup.Tomcat")
@EnableMyConfigurationProperties(ServerProperties.class) // Conditional이 만족하지 않으면 Import 되지않음.
public class TomcatWebServerConfigure {
    @Bean(name = "tomcatServletWebserverFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory(Environment environment, ServerProperties serverProperties) {
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        serverFactory.setContextPath(serverProperties.getContextPath());
        serverFactory.setPort(serverProperties.getPort());

        return serverFactory;
    }
}
