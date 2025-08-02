package com.notification.provider;

import com.notification.model.Notification;

public interface NotificationProvider {
    void send(Notification notification);
}
