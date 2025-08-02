package com.cust.transaction_service.service;

import com.cust.transaction_service.dto.NotificationRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationPublisherService {

    private final KafkaTemplate<String, NotificationRequest> notificationKafkaTemplate;

    public NotificationPublisherService(KafkaTemplate<String, NotificationRequest> notificationKafkaTemplate) {
        this.notificationKafkaTemplate = notificationKafkaTemplate;
    }


    public void publishNotification(String email, String txnDetails) {
        NotificationRequest request = new NotificationRequest(
                email,
                "Transaction Alert",
                txnDetails
        );
        notificationKafkaTemplate.send("notification-topic", request);
        System.out.println(" Notification published to Kafka: " + request);

    }
}
