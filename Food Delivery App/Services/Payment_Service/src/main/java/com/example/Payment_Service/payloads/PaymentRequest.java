package com.example.Payment_Service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentRequest {

    private Long orderId;
    private double amount;
    private String paymentMethod;

    // Getters and Setters
}
