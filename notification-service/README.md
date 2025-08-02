# 📣 Notification Service

## 📌 Overview
The `notification-service` handles the delivery of system notifications based on events received from other services. It consumes Kafka messages, processes them, and triggers notifications through supported channels (e.g., email, SMS, etc.).

## 🚀 Features
- Kafka consumer to receive event payloads (e.g., transactions, preferences)
- REST APIs for notification management and testing
- DTO-based message parsing and validation
- Health monitoring via Spring Actuator
- Containerized for easy deployment

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Apache Kafka
- Docker
- OpenTelemetry (optional)
- Prometheus & Grafana (optional observability)

## 📁 Project Structure
notification-service/ ├── src/ │ ├── main/java/com/example/notification/ │ │ ├── controller/ │ │ ├── service/ │ │ ├── consumer/ │ │ ├── dto/ │ │ ├── config/ │ │ └── NotificationServiceApplication.java │ ├── resources/ │ │ ├── application.yml │ │ └── kafka/ │ └── test/ ├── Dockerfile ├── pom.xml └── README.md



## 🔌 API Endpoints
| Method | Endpoint              | Description                       |
|--------|-----------------------|-----------------------------------|
| POST   | `/api/notify/send`    | Manually trigger a notification   |
| GET    | `/api/notify/{id} `   | Retrieve a sent notification      |


## 📦 Kafka Integration
- **Topic Subscribed:** `transaction-events`, `preference-events`
- **Consumer Group:** `notification-group`
- **Payload:** `NotificationRequest` DTO

## 🧪 Testing
- Unit & integration tests (JUnit, Mockito)
- Kafka consumer testing with Testcontainers

## 📊 Observability
   Endpoint :  GET /actuator/prometheus

## 🐳 Docker Usage
```bash
docker build -t notification-service .
docker run -p 8082:8082 notification-service
