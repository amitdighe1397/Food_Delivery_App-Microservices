package com.example.Restaurant_Service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RestaurantResponse {
    private Long id;
    private String name;
    private String location;

    // Getters and Setters
}

