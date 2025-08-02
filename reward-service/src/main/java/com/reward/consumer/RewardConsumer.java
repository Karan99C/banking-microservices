package com.reward.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reward.dto.CustomerRewardUpdatedEvent;
import com.reward.service.RewardService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RewardConsumer {
    private final ObjectMapper objectMapper;
    private final RewardService rewardService;

    public RewardConsumer(ObjectMapper objectMapper, RewardService rewardService) {
        this.objectMapper = objectMapper;
        this.rewardService = rewardService;
    }

    @KafkaListener(topics = "customer-reward-updated", groupId = "reward-group")
    public void consume(String payload) {
        try {
            CustomerRewardUpdatedEvent event = objectMapper.readValue(payload, CustomerRewardUpdatedEvent.class);
            rewardService.saveReward(event);
        } catch (Exception e) {
            System.err.println("Failed to process reward event: " + e.getMessage());
        }
    }
}
