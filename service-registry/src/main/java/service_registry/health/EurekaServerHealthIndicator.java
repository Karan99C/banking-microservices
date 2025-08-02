package service_registry.health;



import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EurekaServerHealthIndicator implements HealthIndicator {

    private final EurekaClient eurekaClient;

    public EurekaServerHealthIndicator(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @Override
    public Health health() {
        Map<String, Object> details = new HashMap<>();

        try {
            // Check Eureka status
            String status = eurekaClient.getInstanceRemoteStatus().toString();
            details.put("eurekaStatus", status);

            // Check peer registrations
            List<Application> registeredApps = eurekaClient.getApplications().getRegisteredApplications();
            details.put("registeredServiceCount", registeredApps.size());

            return "UP".equals(status)
                    ? Health.up().withDetails(details).build()
                    : Health.down().withDetails(details).build();
        } catch (Exception e) {
            return Health.down(e).build();
        }
    }
}
