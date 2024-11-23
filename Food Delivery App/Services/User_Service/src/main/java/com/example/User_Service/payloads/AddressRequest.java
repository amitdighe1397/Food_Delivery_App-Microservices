package com.example.User_Service.payloads;

import com.example.User_Service.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressRequest {

    private Long id;
    private User user;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private Instant createdAt;
    private Instant updatedAt;
    // Getters and Setters
}

