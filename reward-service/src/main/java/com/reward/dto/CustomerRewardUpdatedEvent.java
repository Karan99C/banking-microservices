package com.reward.dto;

import lombok.Data;

import java.time.LocalDateTime;


public class CustomerRewardUpdatedEvent {
    private String customerId;
    private double rewardPoints;
    private LocalDateTime timestamp;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(double rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
