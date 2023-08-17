package com.inflearn.config.autoconfig;

import com.inflearn.config.MyAutoConfiguration;
import com.inflearn.config.autoconfig.properties.ServerProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {
    @Bean
    public ServerProperties serverProperties(Environment environment) {
        /*
        ServerProperties serverProperties = new ServerProperties();
        serverProperties.setContextPath(environment.getProperty("contextPath"));
        String port = environment.getProperty("port");
        serverProperties.setPort(Integer.parseInt(port != null ? port : "8080"));
        */

        return Binder.get(environment)
                .bind("", ServerProperties.class)
                .get();
    }
}
