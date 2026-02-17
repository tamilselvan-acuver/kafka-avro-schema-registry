# Kafka Avro Schema Registry

This project demonstrates a **Kafka Producer and Consumer** implementation using **Apache Avro** and **Confluent Schema Registry** with **Spring Boot**.

It focuses on schema-based message serialization to ensure data consistency between Kafka producers and consumers.

---

## Tech Stack

- Java 21
- Spring Boot
- Apache Kafka
- Apache Avro
- Confluent Schema Registry
- Docker & Docker Compose
- Maven

---

## Project Structure

kafka-avro-schema-registry
│
├── avro-producer # Kafka producer application
├── avro-consumer # Kafka consumer application
├── docker-compose.yml # Kafka, Zookeeper, Schema Registry setup
└── README.md


---

## Avro & Schema Registry

- Defined Avro schema for `OrderCreatedEvent`
- Generated Java classes using Avro Maven plugin
- Used Confluent Avro serializers for Kafka messaging
- Managed schemas centrally using Schema Registry

---

## How to Run

### 1. Start Kafka & Schema Registry

```bash
docker-compose up -d
2. Run Producer
cd avro-producer
mvn spring-boot:run
3. Run Consumer
cd avro-consumer
mvn spring-boot:run
APIs
Producer API
Publishes an order event to Kafka.

GET http://localhost:8080/send
Consumer API
Returns the last consumed order event.

GET http://localhost:8082/last-order
Kafka Topic
order.created

Notes
Avro is used for message serialization

Schema Registry ensures producer–consumer compatibility

Consumer uses specific.avro.reader=true
