package com.cust.controller;

import com.cust.model.Customer;
import com.cust.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Management", description = "Customer operations")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @Operation(summary = "Create customer")
    @ApiResponse(responseCode = "200", description = "Customer created successfully")
    @PostMapping("/create")
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.createCustomer(customer));
    }

    @Operation(summary = "Fetch customer by ID")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> get(@PathVariable String customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));
    }

    @Operation(summary = "Fetch All customers")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }
}