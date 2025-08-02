package com.cust.transaction_service.controller;

import com.cust.transaction_service.model.Transaction;
import com.cust.transaction_service.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transaction APIs", description = "CRUD operations and customer-based queries")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Fetch transaction by ID")
    @ApiResponse(responseCode = "200", description = "Transaction found")
    @ApiResponse(responseCode = "404", description = "Transaction not found")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable String id) {
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PostMapping("/save")
    @Operation(summary = "Create a new transaction")
    @ApiResponse(responseCode = "200", description = "Transaction created successfully")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) throws JsonProcessingException {
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.ACCEPTED);
    }

    @GetMapping
    @Operation(summary = "Get all transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "Fetch transactions by customer ID")
    public ResponseEntity<List<Transaction>> getTransactionsByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok(transactionService.getTransactionsByCustomerId(customerId));
    }
}