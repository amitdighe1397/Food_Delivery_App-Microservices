package com.example.Delivery_Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document(collection = "deliveries")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Delivery {

    @Id
    private UUID id;
    private UUID orderId;
    private UUID deliveryAgentId;
    private DeliveryStatus status;
    private Instant estimatedTime;
    private Instant createdAt;

}
