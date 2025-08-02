# 🚪 Gateway Service

## 📌 Overview
The `gateway-service` acts as a smart entry point for client requests. It handles routing, request filtering, authentication, and load distribution across microservices like transaction, reward, preference, and notification.

## 🚀 Features
- Centralized routing with Spring Cloud Gateway
- Rate limiting and circuit breaker support
- Path rewriting and header manipulation
- Role-based access control (optional)
- Load balancing via service discovery
- Prometheus metrics & OpenTelemetry tracing

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Spring Cloud Gateway
- Docker
- Prometheus + Micrometer
- OpenTelemetry

## 📁 Project Structure
gateway-service/ ├── src/ │ ├── main/java/com/example/gateway/ │ │ ├── config/ │ │ ├── filter/ │ │ └── GatewayServiceApplication.java │ ├── resources/ │ │ └── application.yml │ └── test/ ├── Dockerfile ├── pom.xml └── README.md

## 🧪 Testing

- Route match tests
- Custom filter unit tests


## 📊 Observability
    Health: GET /actuator/health
    Metrics: GET /actuator/prometheus

## 🧭 Route Configuration

### 🌐 Example Routes
```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: transaction-service
          uri: http://localhost:8081
          predicates:
            - Path=/transactions/**
        - id: reward-service
          uri: http://localhost:8083
          predicates:
            - Path=/rewards/**
        - id: preference-service
          uri: http://localhost:8084
          predicates:
            - Path=/preferences/**


  docker build -t gateway-service .
  docker run -p 8085:8085 gateway-service
