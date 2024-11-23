package com.example.Restaurant_Service.serviceImpl;

import com.example.Restaurant_Service.model.MenuItem;
import com.example.Restaurant_Service.model.Restaurant;
import com.example.Restaurant_Service.repository.MenuItemRepository;
import com.example.Restaurant_Service.repository.RestaurantRepository;
import com.example.Restaurant_Service.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public List<Restaurant> getRestaurantsByLocation(String location) {
        return restaurantRepository.findByLocation(location);
    }

    @Override
    public List<MenuItem> getMenuForRestaurant(UUID restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public Restaurant getRestaurantById(UUID restaurantId) {
        return restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantNotFoundException("Restaurant not found"));
    }
}

