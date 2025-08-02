package com.notification.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.dto.NotificationRequest;
import com.notification.service.NotificationService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.LogManager;

@Component
public class RewardEventListener {
    private static final Logger log = LoggerFactory.getLogger(RewardEventListener.class);

    private final NotificationService notificationService;
    private final ObjectMapper objectMapper;
    private final Counter processedCounter;
    private final Counter errorCounter;
    private final Tracer tracer;

    public RewardEventListener(NotificationService notificationService,
                               ObjectMapper objectMapper, MeterRegistry registry,Tracer tracer ) {
        this.notificationService = notificationService;
        this.objectMapper = objectMapper;
        this.processedCounter= Counter
                .builder("notification_kafka_events_total")
                .description("Kafka messages processed")
                .register(registry);
        this.errorCounter = Counter
                .builder("notification_kafka_errors_total")
                .description("Kafka errors")
                .register(registry);
        this.tracer = tracer;
    }


    @KafkaListener(topics = "customer-reward-updated", groupId = "notification-group",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(String payload) throws Exception {
        Span span = tracer.spanBuilder("processRewardNotification").startSpan();
        try(Scope scope = span.makeCurrent()) {
            if(payload == null || payload.isBlank()){
                log.warn("⚠️ Received empty payload, skipping processing");
                return;

            }
            NotificationRequest request = objectMapper.readValue(payload, NotificationRequest.class);
//            if (request == null || request.getRecipient() == null) {
//                log.error("💥 Deserialization issue: recipient is null. Payload={}", payload);
//                throw new IllegalArgumentException("Payload is not valid NotificationRequest format");
//            }
            span.setAttribute("user.email", request.getRecipient());

            String traceId = span.getSpanContext().getTraceId();
            String spanId = span.getSpanContext().getSpanId();
            log.info(" Received notification request — traceId={}, spanId={}, email={}",
                    traceId, spanId, request.getRecipient());
//                    traceId, spanId);


            notificationService.dispatch(request);
            processedCounter.increment();

        }
        catch(Exception e){
            errorCounter.increment();
            span.recordException(e);
            span.setStatus(StatusCode.ERROR);
            log.error("❌ Failed to process message", e);

        }
        finally {
            span.end();
        }
    }
}
