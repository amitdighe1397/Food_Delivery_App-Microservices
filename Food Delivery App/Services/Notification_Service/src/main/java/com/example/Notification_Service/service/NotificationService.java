package com.example.Notification_Service.service;

import com.example.Notification_Service.model.NotificationType;

import java.util.List;
import java.util.UUID;

public interface NotificationService {

    // Send a notification to a user
    void sendNotification(UUID userId, String message, NotificationType type);

    // Get all notifications for a user
    List<NotificationType> getNotificationsByUserId(UUID userId);

    // Send a notification for a specific order status
    void sendOrderStatusNotification(UUID orderId, String message);

    // Send a notification for delivery status
    void sendDeliveryStatusNotification(UUID deliveryId, String message);
}

