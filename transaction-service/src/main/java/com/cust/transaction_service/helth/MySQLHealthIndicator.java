package com.cust.transaction_service.helth;

import com.cust.transaction_service.repository.TransactionRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MySQLHealthIndicator implements HealthIndicator {

    private final TransactionRepository transactionRepository;

    public MySQLHealthIndicator(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Health health() {
        try {
            // Make a lightweight query
            long count = transactionRepository.count();
            return Health.up().withDetail("MySQL", "Available").withDetail("Rows", count).build();
        } catch (Exception e) {
            return Health.down().withDetail("MySQL", "Unavailable").withException(e).build();
        }
    }
}