package com.iapl.java.springboot.abdulbasit.dockerdev.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iapl.java.springboot.abdulbasit.dockerdev.config.HttpClient;
import com.iapl.java.springboot.abdulbasit.dockerdev.model.UserServiceResponse;

import java.util.List;

public class UserRestServiceImpl implements UserRestService {
    ObjectMapper mapper;
    private String baseUrl = "";
    private HttpClient httpClient;

    public UserRestServiceImpl(String baseUrl, HttpClient httpClient) {
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public List<UserServiceResponse> fetchUsersWhenEmpty() throws Exception {
        String response = httpClient.getHttp(baseUrl + "/cbn-rates/");
        if (response != "" && response != null && response.equals("null")) {
            return mapper.readValue(response, new TypeReference<List<UserServiceResponse>>() {
            });
        }
        return null;
    }
}