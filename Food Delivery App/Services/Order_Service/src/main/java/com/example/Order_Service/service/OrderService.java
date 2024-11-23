package com.example.Order_Service.service;

import com.example.Order_Service.model.Order;
import com.example.Order_Service.model.OrderItem;
import com.example.Order_Service.model.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface OrderService {

    // Place a new order
    Order placeOrder(UUID userId, UUID restaurantId, List<OrderItem> orderItems, UUID addressId);

    // Get order details by ID
    Order getOrderById(UUID orderId);

    // Update the status of an order
    Order updateOrderStatus(UUID orderId, OrderStatus status);

    // Get all orders for a user
    List<Order> getOrdersByUserId(UUID userId);

    // Calculate the total amount of an order
    BigDecimal calculateTotalAmount(List<OrderItem> orderItems);
}

