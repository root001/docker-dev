package com.iapl.java.springboot.abdulbasit.dockerdev.controller;

import com.iapl.java.springboot.abdulbasit.dockerdev.model.UserData;
import com.iapl.java.springboot.abdulbasit.dockerdev.model.UserServiceResponse;
import com.iapl.java.springboot.abdulbasit.dockerdev.service.UserRepository;
import com.iapl.java.springboot.abdulbasit.dockerdev.service.UserRestService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private UserRestService userRestService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="(Gets all users from DB)", notes="Just displays all collected users.")
    public List<UserData> findAll() throws Exception {
        List<UserData> users = userRepository.findAll();
        if(users == null || users.size() == 0 ){
            // make rest template call to url
            List<UserServiceResponse> fetchedUsers = userRestService.fetchUsersWhenEmpty();
            // stream map result to user object List.
            users = fetchedUsers.stream().map(user -> {
                UserData userData = new UserData();

                return userData;
            }).collect(Collectors.toList());
        }
        return users;
    }

}
