package com.cust.transaction_service.service;

import com.cust.transaction_service.dto.TransactionEvent;
import com.cust.transaction_service.kafka.TransactionEventProducer;
import com.cust.transaction_service.kafka.TransactionEventPublisher;
import com.cust.transaction_service.model.Transaction;
import com.cust.transaction_service.repository.TransactionRepository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionEventPublisher eventPublisher;
    private final ObjectMapper objectMapper;


    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  TransactionEventPublisher eventPublisher, ObjectMapper objectMapper) {
        this.transactionRepository = transactionRepository;
        this.eventPublisher = eventPublisher;
        this.objectMapper = objectMapper;
    }

    @Override
    public Transaction getTransactionById(String transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) throws JsonProcessingException {
        Transaction savedTx = transactionRepository.save(transaction);
        TransactionEvent event = new TransactionEvent();
        event.setTransactionId(savedTx.getTransactionId());
        event.setCustomerId(savedTx.getCustomerId());
        event.setAmount(savedTx.getAmount());
        event.setType(savedTx.getType());
        event.setTimestamp(Instant.now());
        eventPublisher.publishEvent(event);
        return savedTx;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByCustomerId(String customerId) {
        return transactionRepository.findByCustomerId(customerId);
    }
}