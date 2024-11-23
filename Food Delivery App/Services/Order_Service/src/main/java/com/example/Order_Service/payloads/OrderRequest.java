package com.example.Order_Service.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderRequest {
    private Long userId;
    private Long restaurantId;
    private List<OrderItem> items;
    private Long addressId;

    // Getters and Setters
}
