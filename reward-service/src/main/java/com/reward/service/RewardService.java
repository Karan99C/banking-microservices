package com.reward.service;

import com.reward.dto.CustomerRewardUpdatedEvent;
import com.reward.model.RewardRecord;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RewardService {
    void saveReward(CustomerRewardUpdatedEvent event);
    List<RewardRecord> getRewardsForCustomer(String customerId);

}

