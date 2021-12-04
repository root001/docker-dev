package com.iapl.java.springboot.abdulbasit.dockerdev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {

    @Autowired
    private RestTemplate restTemplate;

    public String getHttp(String url) throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response == null || response.getStatusCode() != HttpStatus.OK) {
            throw new Exception("GET " + url + " FAILED.");
        } else {
            return response.getBody();
        }
    }
}

