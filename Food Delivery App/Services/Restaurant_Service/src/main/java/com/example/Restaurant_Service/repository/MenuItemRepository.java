package com.example.Restaurant_Service.repository;

import com.example.Restaurant_Service.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {

    // Get menu items for a specific restaurant
    List<MenuItem> findByRestaurantId(UUID restaurantId);
}

