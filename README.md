# Kafka Avro Schema Registry

This project demonstrates a Kafka Producer and Consumer using Apache Avro and Confluent Schema Registry with Spring Boot.

It focuses on schema-based message serialization to ensure compatibility between producers and consumers.

---

## Avro & Schema Registry

- Avro schema defined for `OrderCreatedEvent`
- Java classes generated using Avro Maven plugin
- Confluent Avro serializers used for Kafka messaging
- Schema evolution handled by Schema Registry
- Ensures producer–consumer schema compatibility

---

## Producer

- Publishes `OrderCreatedEvent` messages to Kafka
- Uses Avro for message serialization
- Automatically registers schema in Schema Registry

---

## Consumer

- Subscribes to Kafka topic `order.created`
- Deserializes messages using Avro
- Uses `specific.avro.reader=true`
- Processes strongly typed `OrderCreatedEvent`

---

## How to Run

 Start Kafka & Schema Registry

docker-compose up -d
Run Producer
cd avro-producer
mvn spring-boot:run
Run Consumer
cd avro-consumer
mvn spring-boot:run
---


### APIs
Producer API
Publishes an order event to Kafka.

GET /send
Consumer API
Returns the last consumed order event.

GET /last-order
Kafka Topic
order.created

### Notes
Avro provides compact and fast binary serialization

Schema Registry prevents schema incompatibility issues

Strong typing improves reliability in distributed systems
