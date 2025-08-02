# 🗂️ Service Registry

## 📌 Overview
The `service-registry` provides centralized service discovery for all microservices in the system. Built with Spring Cloud Netflix Eureka, it enables client-side load balancing and dynamic routing through the gateway-service.

## 🚀 Features
- Eureka server for service registration and discovery
- Dashboard UI for instance monitoring
- Health aggregation of registered services
- Peer-to-peer replication in clustered mode (optional)

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Spring Cloud Netflix Eureka
- Docker
- Micrometer (optional)

## 📁 Project Structure
service-registry/ ├── src/ │ ├── main/java/com/example/registry/ │ │ └── ServiceRegistryApplication.java │ ├── resources/ │ │ └── application.yml │ └── test/ ├── Dockerfile ├── pom.xml └── README.md


## ⚙️ Configuration Highlights

### `application.yml`
```yaml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
```
## 🔍 Dashboard
- Access UI at http://localhost:8761
- View registered services and instance status
- Auto-refresh enabled for real-time view

## 🔗 Service Registration (Client-side)
    eureka:
    client:
    service-url:
    defaultZone: http://localhost:8761/eureka/

## 🧪 Testing
- Service registration and heartbeat
- UI dashboard verification

## 🐳 Docker Usage
    docker build -t service-registry .
    docker run -p 8761:8761 service-registry

## 📊 Observability
    GET /actuator/metrics
    GET /actuator/prometheus

