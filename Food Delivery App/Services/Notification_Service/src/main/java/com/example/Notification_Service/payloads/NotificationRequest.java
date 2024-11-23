package com.example.Notification_Service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NotificationRequest {
    private Long userId;
    private String message;
    private String type;

    // Getters and Setters
}
