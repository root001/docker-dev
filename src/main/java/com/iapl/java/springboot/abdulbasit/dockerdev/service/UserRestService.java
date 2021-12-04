package com.iapl.java.springboot.abdulbasit.dockerdev.service;

import com.iapl.java.springboot.abdulbasit.dockerdev.model.UserServiceResponse;

import java.util.List;

public interface UserRestService {
        List<UserServiceResponse> fetchUsersWhenEmpty() throws Exception;
}
