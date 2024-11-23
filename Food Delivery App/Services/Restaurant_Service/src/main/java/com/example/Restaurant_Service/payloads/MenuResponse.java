package com.example.Restaurant_Service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuResponse {
    private Long restaurantId;
    private List<MenuItem> menu;

    // Getters and Setters
}

