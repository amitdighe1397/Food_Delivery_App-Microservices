package com.example.Payment_Service.service;

import com.example.Payment_Service.model.Payment;
import com.example.Payment_Service.model.PaymentMethod;
import com.example.Payment_Service.model.PaymentStatus;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentService {

    // Process payment for an order
    Payment processPayment(UUID orderId, BigDecimal amount, PaymentMethod paymentMethod);

    // Get payment details by ID
    Payment getPaymentById(UUID paymentId);

    // Get payment status for an order
    PaymentStatus getPaymentStatus(UUID orderId);

    // Refund a payment (if necessary)
    Payment refundPayment(UUID paymentId);
}

