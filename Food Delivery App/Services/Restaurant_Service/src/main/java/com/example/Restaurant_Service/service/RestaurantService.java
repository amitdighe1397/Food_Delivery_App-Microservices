package com.example.Restaurant_Service.service;

import com.example.Restaurant_Service.model.MenuItem;
import com.example.Restaurant_Service.model.Restaurant;

import java.util.List;
import java.util.UUID;

public interface RestaurantService {

    // Get all restaurants based on location
    List<Restaurant> getRestaurantsByLocation(String location);

    // Get menu for a specific restaurant
    List<MenuItem> getMenuForRestaurant(UUID restaurantId);

    // Get restaurant details by ID
    Restaurant getRestaurantById(UUID restaurantId);
}

