package com.notification.kafka;

import com.notification.dto.PreferenceDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PreferenceConsumer {

    @KafkaListener(topics = "user-preference-updated", groupId = "notification-group")
    public void consumePreferenceUpdate(PreferenceDTO dto) {
        System.out.println("📩 Received updated preferences for user: " + dto.getUserId());
        System.out.println("🔧 Email: " + dto.isEmail() + ", SMS: " + dto.isSms() + ", Push: " + dto.isPush());
        // Future hook: store in cache, DB, or trigger notification strategy
    }
}
