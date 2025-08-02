package com.cust.health;

import com.cust.repository.CustomerRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomerDbHealthIndicator implements HealthIndicator {

    private final CustomerRepository customerRepository;

    public CustomerDbHealthIndicator(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Health health() {
        try {
            long count = customerRepository.count(); // lightweight ping
            return Health.up()
                    .withDetail("Customer DB", "Available")
                    .withDetail("Total Records", count)
                    .build();
        } catch (Exception e) {
            return Health.down()
                    .withDetail("Customer DB", "Unavailable")
                    .withException(e)
                    .build();
        }
    }
}