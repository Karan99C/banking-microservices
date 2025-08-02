package com.cust.transaction_service.kafka;

import com.cust.transaction_service.dto.TransactionEvent;

public interface TransactionEventPublisher {
    void publishEvent(TransactionEvent event);
}
