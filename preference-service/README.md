# 🧠 Preference Service

## 📌 Overview
The `preference-service` manages customer preferences, enabling personalized experiences across services. It consumes relevant events from Kafka and offers APIs to fetch or update user preferences. This service acts as a central store for customization and behavioral data.

## 🚀 Features
- Kafka consumer for ingesting preference update events
- REST APIs for CRUD operations on preferences
- JSON-based DTOs for flexible payloads
- Emits change events for downstream services (optional)
- Integrates with caching for rapid access (if needed)

## 🛠️ Tech Stack
- Java 17
- Spring Boot
- Apache Kafka
- Docker
- OpenTelemetry (optional)
- Micrometer & Prometheus (optional)

## 📁 Project Structure
preference-service/ ├── src/ │ ├── main/java/com/example/preference/ │ │ ├── controller/ │ │ ├── service/ │ │ ├── dto/ │ │ ├── consumer/ │ │ ├── config/ │ │ └── PreferenceServiceApplication.java │ ├── resources/ │ │ └── application.yml │ └── test/ ├── Dockerfile ├── pom.xml └── README.md

## 🔌 API Endpoints
| Method | Endpoint            | Description                     |
|--------|---------------------|---------------------------------|
| PUT    | `/preferences/save` | Manually change the preferances |
| GET    | `/preferences/{id}` | Retrieve preferances            |

## 🔌 Kafka Integration
- **Topics Subscribed:** `preference-events`
- **Payloads:** Reflect user-defined preferences (notifications, language, themes, etc.)
- **Producer (Optional):** Emits events to `preference-updates`

## 🧪 Testing
- Unit tests for service & controller layers
- Kafka consumer tests with mocking or embedded Kafka

## 📊 Observability

    Health: GET /actuator/health
    Metrics: GET /actuator/prometheus

## 🐳 Docker Usage
```bash
docker build -t preference-service .
docker run -p 8084:8084 preference-service
