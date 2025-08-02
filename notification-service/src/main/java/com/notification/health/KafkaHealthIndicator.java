package com.notification.health;



import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaHealthIndicator implements HealthIndicator {

    private static final Logger log = LoggerFactory.getLogger(KafkaHealthIndicator.class);

//
//    private String bootstrapServers;

    @Override
    public Health health() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");

        try (AdminClient adminClient = AdminClient.create(props)) {
            DescribeClusterResult cluster = adminClient.describeCluster();
            String clusterId = cluster.clusterId().get(2, TimeUnit.SECONDS);

            return Health.up()
                    .withDetail("Kafka", "Available")
                    .withDetail("Cluster ID", clusterId)
                    .build();

        } catch (Exception e) {
            log.warn("Kafka health check failed", e);
            return Health.down()
                    .withDetail("Kafka", "Unavailable")
                    .withException(e)
                    .build();
        }
    }
}
