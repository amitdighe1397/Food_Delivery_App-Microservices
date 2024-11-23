package com.example.Restaurant_Service.controller;

import com.example.Restaurant_Service.model.MenuItem;
import com.example.Restaurant_Service.model.Restaurant;
import com.example.Restaurant_Service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Get a list of restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    // Get menu for a restaurant
    @GetMapping("/{id}/menu")
    public ResponseEntity<MenuItem> getMenu(@PathVariable Long id) {
        MenuItem menu = restaurantService.getMenuByRestaurantId(id);
        return ResponseEntity.ok(menu);
    }
}

