package com.reward.service;

import com.reward.dto.CustomerRewardUpdatedEvent;
import com.reward.model.RewardRecord;
import com.reward.repository.RewardRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RewardServiceImpl implements RewardService{

    private final RewardRepository repository;
    private final Counter rewardSaveCounter;
    private final Timer saveTimer;

    public RewardServiceImpl(RewardRepository repository, MeterRegistry meterRegistry){
        this.repository=repository;
        this.rewardSaveCounter =
                Counter.builder("rewardservice_reward_save_total")
                        .description("Total rewards saved")
                        .register(meterRegistry);
        this.saveTimer=Timer.builder("rewardservice_reward_save_duration_seconds")
                .description("Time to save reward")
                .register(meterRegistry);

    }
    @Override
    public void saveReward(CustomerRewardUpdatedEvent event) {
        saveTimer.record(() -> {
                    RewardRecord record = new RewardRecord();
                    record.setCustomerId(event.getCustomerId());
                    record.setRewardPoints(event.getRewardPoints());
                    record.setReceivedAt(event.getTimestamp());


                    repository.save(record);
                    rewardSaveCounter.increment();
                });


    }

    @Override
    public List<RewardRecord> getRewardsForCustomer(String customerId) {
        return repository.findByCustomerId(customerId);
    }


}
