package com.iapl.java.springboot.abdulbasit.dockerdev.service;

import com.iapl.java.springboot.abdulbasit.dockerdev.model.UserData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<UserData, UUID> {
}
