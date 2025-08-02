# 🧾 Customer Service

## 📌 Overview
The `customer-service` is a Spring Boot microservice responsible for handling customer-related operations including creation, retrieval, updates, and deletion. It also publishes customer creation events to Kafka for downstream services.

## 🚀 Features
- RESTful APIs for customer CRUD operations
- Kafka producer integration for event publishing
- DTO-based request/response handling
- Service discovery support (via Eureka or similar)
- Configurable via `application.yml`

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Apache Kafka
- Docker
- OpenTelemetry (optional tracing)

## 📁 Project Structure


## 🔌 API Endpoints
| Method | Endpoint                | Description              |
|--------|-------------------------|--------------------------|
| POST   | `/api/customers/create` | Create a new customer    |
| GET    | `/api/customers/{id}`   | Retrieve customer by ID  |
| PUT    | `/api/customers/{id}`   | Update customer info     |
| DELETE | `/api/customers/{id}`   | Delete a customer        |

## 📦 Kafka Integration
- **Topic:** `customer-events`
- **Event Type:** `CustomerCreatedEvent`
- **Payload:** Serialized DTO (JSON)

## 🧪 Testing
- Unit and integration tests with JUnit & Mockito
- Optional Kafka mocking with Testcontainers

## 🚨 Health Check
Endpoint: GET /actuator/health

## 🐳 Docker Usage
```bash
docker build -t customer-service .
docker run -p 8080:8080 customer-service


