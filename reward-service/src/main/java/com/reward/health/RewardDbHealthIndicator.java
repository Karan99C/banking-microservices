package com.reward.health;

import com.reward.repository.RewardRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RewardDbHealthIndicator implements HealthIndicator {

    private final RewardRepository rewardRepository;

    public RewardDbHealthIndicator(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @Override
    public Health health() {
        try {
            long count = rewardRepository.count();  // lightweight DB call
            return Health.up()
                    .withDetail("reachable", true)
                    .withDetail("recordCount", count)
                    .build();
        } catch (Exception ex) {
            return Health.down(ex).build();
        }
    }
}
