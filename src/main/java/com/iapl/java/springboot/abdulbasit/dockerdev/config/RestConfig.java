package com.iapl.java.springboot.abdulbasit.dockerdev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(15_000);
        requestFactory.setReadTimeout(60_000);
        return new RestTemplate(requestFactory);
    }
}
