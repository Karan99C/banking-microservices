package gateway_service.health;


import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Component
public class GatewayHealthIndicator implements HealthIndicator {
    private final WebClient webClient;



    @Value("${preference.service.url}")
    private String preferenceServiceUrl;

    public GatewayHealthIndicator(WebClient.Builder webClient) {
        this.webClient =webClient.build();
    }

    @Override
    public Health health() {
        Map<String, Object> details = new HashMap<>();
        try {
            String result = webClient.get()
                    .uri(preferenceServiceUrl + "/actuator/health")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(); // blocking here for simplicity
            details.put("preferenceService", "UP");
        } catch (Exception e) {
            details.put("preferenceService", "UNREACHABLE");
        }
        details.put("registry", "UP");
        return Health.up().withDetails(details).build();
    }

}
