package com.example.Payment_Service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentResponse {

    private Long paymentId;
    private String status;
    private Long orderId;

    // Getters and Setters
}
