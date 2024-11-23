package com.example.Delivery_Service.controller;

import com.example.Delivery_Service.model.Delivery;
import com.example.Delivery_Service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    // Assign delivery agent
    @PostMapping
    public ResponseEntity<Delivery> assignDelivery(@RequestBody DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryService.assignDelivery(deliveryRequest);
        return ResponseEntity.ok(delivery);
    }

    // Get delivery status
    @GetMapping("/{id}/status")
    public ResponseEntity<Delivery> getDeliveryStatus(@PathVariable Long id) {
        Delivery delivery = deliveryService.getDeliveryStatus(id);
        return ResponseEntity.ok(delivery);
    }
}

