package com.example.Order_Service.repository;

import com.example.Order_Service.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    // Find all items for a specific order
    List<OrderItem> findByOrderId(UUID orderId);
}

