package com.example.Payment_Service.controller;

import com.example.Payment_Service.model.Payment;
import com.example.Payment_Service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Process payment
    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentResponse response = paymentService.processPayment(paymentRequest);
        return ResponseEntity.ok(response);
    }

    // Get payment status
    @GetMapping("/{id}/status")
    public ResponseEntity<Payment> getPaymentStatus(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentStatus(id);
        return ResponseEntity.ok(payment);
    }
}

