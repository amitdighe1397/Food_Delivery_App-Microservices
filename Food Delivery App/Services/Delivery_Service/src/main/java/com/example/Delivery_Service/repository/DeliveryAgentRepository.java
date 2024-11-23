package com.example.Delivery_Service.repository;

import com.example.Delivery_Service.model.DeliveryAgent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface DeliveryAgentRepository extends MongoRepository<DeliveryAgent, UUID> {

    // Find a delivery agent by their phone or name (if needed)
    Optional<DeliveryAgent> findByPhone(String phone);
}

