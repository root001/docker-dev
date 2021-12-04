package com.iapl.java.springboot.abdulbasit.dockerdev.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("user_address")
public class AddressData {
    @Id
    UUID id;
    String street;
    String city;
    String zipCode;
}
