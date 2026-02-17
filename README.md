# Kafka Avro Schema Registry

This project demonstrates a Kafka Producer and Consumer using Apache Avro and Confluent Schema Registry with Spring Boot.

It focuses on schema-based message serialization to maintain compatibility between producers and consumers.

---

## Avro & Schema Registry

- Avro schema defined for `OrderCreatedEvent`
- Java classes generated using Avro Maven plugin
- Confluent Avro serializers used for Kafka messaging
- Schema Registry used for centralized schema management

---

## How to Run

### Start Kafka & Schema Registry
```bash
docker-compose up -d
Run Producer
cd avro-producer
mvn spring-boot:run
Run Consumer
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

Consumer is configured with specific.avro.reader=true
