package com.example.Notification_Service.controller;

package com.example.notificationservice.controller;

import com.example.Notification_Service.service.NotificationService;
import com.example.notificationservice.dto.NotificationRequest;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.sendNotification(notificationRequest);
        return ResponseEntity.ok("Notification sent successfully");
    }
}
