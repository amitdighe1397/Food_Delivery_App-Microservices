package com.example.Delivery_Service.repository;

import com.example.Delivery_Service.model.Delivery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository extends MongoRepository<Delivery, UUID> {

    // Find deliveries by order ID
    List<Delivery> findByOrderId(UUID orderId);

    // Find deliveries by agent ID
    List<Delivery> findByDeliveryAgentId(UUID deliveryAgentId);

    // Find delivery by delivery ID (status, etc.)
    Optional<Delivery> findById(UUID deliveryId);
}

