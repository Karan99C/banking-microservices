# 🎁 Reward Service

## 📌 Overview
The `reward-service` is responsible for calculating and managing customer rewards based on transaction and preference events. It listens to Kafka topics and performs reward logic based on event payloads, allowing for real-time incentive delivery.

## 🚀 Features
- Kafka consumer for event-driven reward processing
- Stateless reward computation logic
- Configurable thresholds or rules via environment
- Integration with notification-service (optional trigger)
- Exposed REST endpoint(s) for debug or insights

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Apache Kafka
- Docker
- OpenTelemetry (optional)
- Micrometer & Prometheus (optional)

## 📁 Project Structure
reward-service/ ├── src/ │ ├── main/java/com/example/reward/ │ │ ├── consumer/ │ │ ├── service/ │ │ ├── dto/ │ │ ├── config/ │ │ └── RewardServiceApplication.java │ ├── resources/ │ │ └── application.yml │ └── test/ ├── Dockerfile ├── pom.xml └── README.md

## 🔌 API Endpoints
| Method | Endpoint            | Description      |
|--------|---------------------|------------------|
| POST   | `/api/rewards/save` | saves the reward |
| GET    | `/api/rewards/{id}` | Retrieve reward  |


## 🔌 Kafka Integration
- **Topics Subscribed:** `transaction-events`, `preference-events`
- **Consumer Group:** `reward-group`
- **Payloads:** Deserialized as DTOs, used for reward calculation

## 🧪 Testing
- Unit tests with JUnit & Mockito
- Kafka consumer tests using mocks or Testcontainers (optional)

## 📊 Observability
    Health: GET /actuator/health
    Metrics: GET /actuator/prometheus

## 🐳 Docker Usage
```bash
docker build -t reward-service .
docker run -p 8083:8083 reward-service
