package com.tsinjo.app.repository;

import javax.sql.DataSource;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DataSourceConfig {
    private Dotenv dotenv = Dotenv.load();
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(dotenv.get("URL")+dotenv.get("PREPROD_DATABASE"))
                .username(dotenv.get("USERNAME"))
                .password(dotenv.get("PASSWORD"))
                .driverClassName("org.postgresql.Driver")
                .build();
    }
}
