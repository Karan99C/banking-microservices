package com.cust.config;

import com.cust.dto.TransactionEventDto;
import com.cust.service.CustomerRewardService;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventHandler {
    private final CustomerRewardService rewardService;

    public TransactionEventHandler(CustomerRewardService rewardService) {
        this.rewardService = rewardService;
    }

    public void process(TransactionEventDto event) {
        if (event.getCustomerId() == null || event.getAmount() <= 0) return;

        rewardService.updateReward(event.getCustomerId(), event.getAmount());
        System.out.println("Reward updated for customer: " + event.getCustomerId());
    }
}
