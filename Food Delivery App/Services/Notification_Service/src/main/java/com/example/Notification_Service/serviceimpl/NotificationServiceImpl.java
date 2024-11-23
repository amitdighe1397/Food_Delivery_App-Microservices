package com.example.Notification_Service.serviceimpl;

import com.example.Notification_Service.model.Notification;
import com.example.Notification_Service.model.NotificationType;
import com.example.Notification_Service.repository.NotificationRepository;
import com.example.Notification_Service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void sendNotification(UUID userId, String message, NotificationType type) {
        Notification notification = new Notification();
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setType(type);
        notification.setSentAt(System.currentTimeMillis());  // Using current time as timestamp
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByUserId(UUID userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public void sendOrderStatusNotification(UUID orderId, String message) {
        // Sending order status update to the user
        sendNotification(UUID.randomUUID(), message, NotificationType.ORDER_STATUS);  // Just a placeholder
    }

    @Override
    public void sendDeliveryStatusNotification(UUID deliveryId, String message) {
        // Sending delivery status update to the user
        sendNotification(UUID.randomUUID(), message, NotificationType.DELIVERY_STATUS);  // Just a placeholder
    }
}

