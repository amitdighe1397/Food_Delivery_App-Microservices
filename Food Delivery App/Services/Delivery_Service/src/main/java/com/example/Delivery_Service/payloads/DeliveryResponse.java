package com.example.Delivery_Service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeliveryResponse {

    private Long id;
    private Long orderId;
    private Long agentId;
    private String status;

    // Getters and Setters
}
