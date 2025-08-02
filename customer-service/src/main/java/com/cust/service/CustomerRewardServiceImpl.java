package com.cust.service;

import com.cust.model.Customer;
import com.cust.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerRewardServiceImpl implements CustomerRewardService{
    private final CustomerRepository customerRepository;

    public CustomerRewardServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void updateReward(String customerId, Double transactionAmount) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        double rewardPoints = transactionAmount * 0.1; // Example logic: 10% as points
        customer.setRewardPoints(customer.getRewardPoints() + rewardPoints);
        customerRepository.save(customer);

        System.out.println("Updated reward points for customer " + customerId);


    }
}
