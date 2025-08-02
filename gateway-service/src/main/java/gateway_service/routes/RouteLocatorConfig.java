package gateway_service.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {


    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("notification_route", r -> r.path("/notification/**")
                        .uri("http://localhost:8084")) // notification-service port

                .route("customer_route", r -> r.path("/customer/**")
                        .uri("http://localhost:8081")) // customer-service port

                .build();
    }
}
