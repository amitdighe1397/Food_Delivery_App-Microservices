package com.example.Delivery_Service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "delivery_agents")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DeliveryAgent {

    @Id
    private UUID id;
    private String name;
    private String phone;
    private String vehicle;
    private AgentStatus status;

}
