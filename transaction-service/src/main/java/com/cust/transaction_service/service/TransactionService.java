package com.cust.transaction_service.service;



import com.cust.transaction_service.model.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface TransactionService {
    Transaction getTransactionById(String transactionId);
    Transaction saveTransaction(Transaction transaction) throws JsonProcessingException;
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByCustomerId(String customerId);
}