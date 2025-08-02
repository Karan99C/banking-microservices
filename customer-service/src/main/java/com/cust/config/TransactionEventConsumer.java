package com.cust.config;

import com.cust.dto.TransactionEventDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TransactionEventConsumer {
    private final ObjectMapper objectMapper ;
    private final TransactionEventHandler handler;

    public TransactionEventConsumer(ObjectMapper objectMapper, TransactionEventHandler handler) {
        this.objectMapper = objectMapper;
        this.handler = handler;
    }
    public void consume(String payload) {
        try {
            TransactionEventDto event = objectMapper.readValue(payload, TransactionEventDto.class);
            handler.process(event);
        } catch (Exception e) {
            System.err.println("Failed to process event: " + e.getMessage());
            // Optionally increment a failure metric
        }
    }
}
