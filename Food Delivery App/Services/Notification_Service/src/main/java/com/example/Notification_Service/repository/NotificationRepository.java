package com.example.Notification_Service.repository;

import com.example.Notification_Service.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    // Find notifications by user ID
    List<Notification> findByUserId(UUID userId);

    // Find all notifications for a specific order (status, etc.)
    List<Notification> findByOrderId(UUID orderId);
}

