# 🏦 Banking Microservices

A fully modular, observable, and scalable backend architecture for a fictional banking system. Built with Spring Boot, Kafka, Docker Compose, and integrated observability using Prometheus, Grafana, and OpenTelemetry.

---

## 📦 Microservices

| Service           | Description                             |
|-------------------|-----------------------------------------|
| `transaction-service` | Handles customer transactions and events |
| `account-service`     | Manages account creation and details   |
| `notification-service`| Sends email/SMS alerts via Kafka events|
| `customer-service`    | CRUD operations for customer profiles  |
| `gateway-service`     | API Gateway routing and security       |
| `discovery-service`   | Service registry using Eureka          |

---

## 🚀 Features

- Kafka-based event-driven communication across microservices
- OpenTelemetry-based distributed tracing
- Metrics collection with Prometheus
- Dashboards via Grafana
- Docker Compose orchestration for local testing
- Clean code structure with modular DTOs and error handling

---

## 🧰 Tech Stack

- **Spring Boot** (Java 17)
- **Apache Kafka**
- **Docker & Docker Compose**
- **Prometheus & Grafana**
- **OpenTelemetry Collector**
- **Spring Cloud Gateway + Eureka Discovery**

---

## 📊 Observability Architecture

[Microservices] → [OpenTelemetry Collector] → [Prometheus] → [Grafana] | [Jaeger or OTEL backend]


Each microservice is instrumented for tracing and exposes Prometheus-compatible metrics for seamless debugging and visualization.

---

## 🧪 Running Locally

```bash
# Build all services
./mvn clean build

# Start entire stack
 docker compose up --build ```


 📈 Grafana: http://localhost:3000

🔍 Eureka Dashboard: http://localhost:8761

📡 Gateway: http://localhost:8080

## 📚 Repository Layout

  banking-microservices/
├── transaction-service/
├── account-service/
├── notification-service/
├── customer-service/
├── gateway-service/
├── discovery-service/
├── docker-compose.yml
└── README.md

Each service contains:

/src: Spring Boot source

/config: Kafka & OpenTelemetry setup

Dockerfile: Containerization

## 📝 Project Goals
  ✅ Documented and modular microservices

  ✅ Push code to GitHub with structure

  ✅ Validate system with Docker Compose

  🧭 Deploy to AWS or GCP (planned)

  🔁 Implement CI/CD (planned)

## 🧠 Maintainer
    Arun, a backend engineer obsessed with clarity, reliability, and observability. 📌 Expertise in Kafka, tracing, and scalable system design.

## 💡 Contributing
    PRs and issues welcome! Open a discussion if you'd like to add more services or improve the stack.





