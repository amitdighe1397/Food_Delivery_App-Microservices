package com.example.Notification_Service.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Unique identifier for the notification.

    @Column(nullable = false)
    private UUID userId; // Associated user's ID.

    @Column(nullable = false, length = 500)
    private String message; // Notification message content.

    @Column(nullable = false, length = 50)
    private String type; // Type of notification (e.g., ORDER_STATUS, DELIVERY_STATUS).

    @Column(nullable = false)
    private LocalDateTime sentAt; // When the notification was sent.

}

