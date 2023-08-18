package com.inflearn.config.autoconfig.properties;


import com.inflearn.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "h2.db")
public class MyDataSourceProperties {
    private String driverClassname;

    private String username;

    private String password;

    private String url;

    public String getDriverClassname() {
        return driverClassname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
}
