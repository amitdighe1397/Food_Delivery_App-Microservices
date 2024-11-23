package com.example.Restaurant_Service.repository;

import com.example.Restaurant_Service.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

    // Find a restaurant by its name (if needed)
    Optional<Restaurant> findByName(String name);

    // Find restaurants by their location (city/area)
    List<Restaurant> findByLocation(String location);
}
