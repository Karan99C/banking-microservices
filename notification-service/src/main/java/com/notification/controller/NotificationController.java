package com.notification.controller;

import com.notification.dto.NotificationRequest;
import com.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify")
public class NotificationController {

    private final NotificationService notificationService;


    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;

    }

    @PostMapping("send")
    public ResponseEntity<String> send(@RequestBody NotificationRequest request){
        notificationService.dispatch(request);
        return ResponseEntity.ok("Request sent");
    }
}
