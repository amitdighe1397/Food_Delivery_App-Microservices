package com.example.Delivery_Service.service;

import com.example.Delivery_Service.model.Delivery;
import com.example.Delivery_Service.model.DeliveryStatus;

import java.util.List;
import java.util.UUID;

public interface DeliveryService {

    // Create a new delivery assignment
    Delivery assignDelivery(UUID orderId, UUID deliveryAgentId, String deliveryAddress);

    // Get delivery status for an order
    DeliveryStatus getDeliveryStatus(UUID deliveryId);

    // Update delivery status
    Delivery updateDeliveryStatus(UUID deliveryId, DeliveryStatus status);

    // Get list of all deliveries for an agent
    List<Delivery> getDeliveriesByAgent(UUID agentId);

    // Get all deliveries for an order
    List<Delivery> getDeliveriesByOrder(UUID orderId);
}
