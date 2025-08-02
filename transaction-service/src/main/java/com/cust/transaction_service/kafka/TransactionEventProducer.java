package com.cust.transaction_service.kafka;

import com.cust.transaction_service.dto.TransactionEvent;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TransactionEventProducer implements  TransactionEventPublisher  {

    private static final String TOPIC = "transaction-events";
    private final KafkaTemplate<String, TransactionEvent> kafkaTemplate;
    private final Counter successCounter;
    private final Counter failureCounter;


    @Autowired
    public TransactionEventProducer(KafkaTemplate<String, TransactionEvent> kafkaTemplate,
                                    MeterRegistry meterRegistry) {
        this.kafkaTemplate = kafkaTemplate;
        this.successCounter = meterRegistry.counter("kafka.producer.success.count");
        this.failureCounter = meterRegistry.counter("kafka.producer.failure.count");

    }


//    @Override
//    public void publishEvent(TransactionEvent event) {
//        kafkaTemplate.send(TOPIC, event.getTransactionId(), event);
//    }

    @Override
    public void publishEvent(TransactionEvent event) {
        kafkaTemplate.send("transaction-events", event.getTransactionId(), event)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        successCounter.increment();
                    } else {
                        failureCounter.increment();
                    }
                });
    }

}
