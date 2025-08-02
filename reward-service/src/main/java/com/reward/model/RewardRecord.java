package com.reward.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
public class RewardRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private double rewardPoints;
    private LocalDateTime receivedAt;

    public RewardRecord(Long id, String customerId, double rewardPoints, LocalDateTime receivedAt) {
        this.id = id;
        this.customerId = customerId;
        this.rewardPoints = rewardPoints;
        this.receivedAt = receivedAt;
    }

    public RewardRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    @Override
    public String toString() {
        return "RewardRecord{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", rewardPoints=" + rewardPoints +
                ", receivedAt=" + receivedAt +
                '}';
    }
}
