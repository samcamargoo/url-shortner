package com.sam.urlshortner.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DatabaseConfig {


    @Bean
    public Map<String, String> longUrlDatabase() {
        return new HashMap<>();
    }
    @Bean
    public Map<String, String> shortenedUrlDatabase() {
        return new HashMap<>();
    }
}
