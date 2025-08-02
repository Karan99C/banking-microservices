package com.notification.service;

import com.notification.dto.NotificationRequest;
import com.notification.model.Notification;
import com.notification.provider.NotificationProvider;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements  NotificationService{
    private final NotificationProvider provider;

    public NotificationServiceImpl(NotificationProvider provider) {
        this.provider = provider;
    }

    @Override
    public void dispatch(NotificationRequest request) {
        Notification notification = new Notification(
                request.getRecipient(),
                request.getSubject(),
                request.getBody()
        );

        provider.send(notification);
    }
}
