package com.cust.service;

import com.cust.model.Customer;
import com.cust.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer getCustomerById(String customerId) {
        return repository.findById(customerId).orElseThrow();
    }
    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }
}