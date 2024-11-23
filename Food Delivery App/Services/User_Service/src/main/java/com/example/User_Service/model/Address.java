package com.example.User_Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {

    @Id
    private long id;
    @DBRef
    private User user;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private Instant createdAt;
    private Instant updatedAt;

}
