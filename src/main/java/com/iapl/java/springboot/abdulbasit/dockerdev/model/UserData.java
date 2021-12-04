package com.iapl.java.springboot.abdulbasit.dockerdev.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("Users")
@Data
public class UserData {
    @Id
    UUID id;
    String name;
    String username;
    String phone;
    String email;
    AddressData address;
}
