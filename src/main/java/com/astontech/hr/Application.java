package com.astontech.hr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.activation.DataSource;

/**
 * Created by Julian.Chatterton on 3/23/2017.
 */

@SpringBootApplication
public class Application {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.datasource.driverClassName}")
    private String datasourceDriverClassName;

    @Bean
    public org.apache.tomcat.jdbc.pool.DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName(datasourceDriverClassName);
        ds.setUrl(datasourceUrl);
        ds.setUsername(datasourceUsername);
        ds.setPassword(datasourcePassword);

        return ds;
    }

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);
    }
}
