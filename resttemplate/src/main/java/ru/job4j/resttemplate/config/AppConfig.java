package ru.job4j.resttemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import ru.job4j.resttemplate.handler.RestTemplateResponseErrorHandler;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
//        return new RestTemplate();
        return new RestTemplateBuilder()
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }
}