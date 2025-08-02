package com.cust.service;

import com.cust.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(String customerId);
    List<Customer> getAllCustomers();
}

