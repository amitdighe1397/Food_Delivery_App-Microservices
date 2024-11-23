package com.example.Delivery_Service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DeliveryRequest {
    private Long orderId;
    private Long userId;
    private String deliveryAddress;

    // Getters and Setters
}

