package com.cust.transaction_service.controller;

import com.cust.transaction_service.service.NotificationPublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class NotificationTestController {

    private final NotificationPublisherService notificationPublisherService;

    public NotificationTestController(NotificationPublisherService notificationPublisherService) {
        this.notificationPublisherService = notificationPublisherService;
    }

    @GetMapping("/send-notification")
    public ResponseEntity<String> sendTestNotification(@RequestParam String email, @RequestParam String message) {
        notificationPublisherService.publishNotification(email, message);
        return ResponseEntity.ok("✅ Notification published to Kafka for " + email);
    }
}
