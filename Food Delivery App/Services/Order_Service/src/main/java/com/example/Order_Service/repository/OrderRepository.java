package com.example.Order_Service.repository;

import com.example.Order_Service.model.Order;
import com.example.Order_Service.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    // Find orders by user ID
    List<Order> findByUserId(UUID userId);

    // Find an order by its status (if needed)
    List<Order> findByStatus(OrderStatus status);
}

