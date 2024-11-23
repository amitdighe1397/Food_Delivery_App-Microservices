package com.example.Payment_Service.repository;

import com.example.Payment_Service.model.Payment;
import com.example.Payment_Service.model.PaymentStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends MongoRepository<Payment, UUID> {

    // Find payments by order ID
    Optional<Payment> findByOrderId(UUID orderId);

    // Find payment status for a specific order
    Optional<Payment> findByOrderIdAndStatus(UUID orderId, PaymentStatus status);
}

