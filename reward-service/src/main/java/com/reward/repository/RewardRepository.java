package com.reward.repository;

import com.reward.model.RewardRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardRepository extends JpaRepository<RewardRecord, Long> {
    List<RewardRecord> findByCustomerId(String customerId);
}

