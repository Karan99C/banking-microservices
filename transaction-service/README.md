# 💳 Transaction Service

## 📌 Overview
The `transaction-service` is a Spring Boot microservice that handles customer transactions, including initiation, retrieval, and validation. It emits events to Kafka for downstream services such as notifications or audits.

## 🚀 Features
- REST APIs for initiating and querying transactions
- Kafka producer for publishing transaction events
- DTO serialization with validation
- OpenTelemetry-enabled tracing (optional)
- Health and metrics endpoints via Spring Actuator

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Apache Kafka
- Docker
- OpenTelemetry
- Prometheus & Grafana (optional observability)

## 📁 Project Structure
transaction-service/ ├── src/ │ ├── main/java/com/example/transaction/ │ │ ├── controller/ │ │ ├── service/ │ │ ├── dto/ │ │ ├── config/ │ │ └── TransactionServiceApplication.java │ ├── resources/ │ │ ├── application.yml │ │ └── kafka/ │ └── test/ ├── Dockerfile ├── pom.xml └── README.md



## 🔌 API Endpoints
| Method | Endpoint                      | Description                   |
|--------|-------------------------------|-------------------------------|
| POST   | `/api/transactions/save`      | Create a new transaction      |
| GET    | `/api/transactions/{id}`      | Get transaction details by ID |
| GET    | `/api/transactions` | Get all transactions for a customer |

## 📦 Kafka Integration
- **Topic:** `transaction-events`
- **Event Type:** `TransactionInitiatedEvent`
- **Payload:** Serialized transaction DTO (JSON)

## 🧪 Testing
- JUnit & Mockito based unit/integration tests
- Kafka mocking with Testcontainers (recommended)


## 📊 Observability
    Prometheus endpoint at /actuator/prometheus

## 🚨 Health Check
    Endpoint: GET /actuator/health

## 🐳 Docker Usage
```bash
docker build -t transaction-service .
docker run -p 8081:8081 transaction-service



