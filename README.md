Kafka Avro Schema Registry

This project demonstrates a Kafka Producer and Consumer implementation using Apache Avro and Confluent Schema Registry with Spring Boot.

It shows how schema-based serialization helps maintain data consistency in distributed systems.

Tech Stack

Java 21

Spring Boot

Apache Kafka

Apache Avro

Confluent Schema Registry

Docker & Docker Compose

Maven

Project Structure
kafka-avro-schema-registry
│
├── avro-producer        # Kafka producer service
├── avro-consumer        # Kafka consumer service
├── docker-compose.yml  # Kafka, Zookeeper, Schema Registry setup
└── README.md

Avro & Schema Registry (Task Overview)

Learned Apache Avro and its importance in distributed systems

Set up Confluent Schema Registry using Docker

Created Avro schema for OrderCreatedEvent

Generated Java classes using Avro Maven plugin

Produced and consumed Avro messages using Confluent serializers

How to Run the Project
1. Start Kafka and Schema Registry
docker-compose up -d

2. Run Producer Application
cd avro-producer
mvn spring-boot:run

3. Run Consumer Application
cd avro-consumer
mvn spring-boot:run

APIs
Producer API

Publishes an order event to Kafka.

GET http://localhost:8080/send

Consumer API

Fetches the last consumed order event.

GET http://localhost:8082/last-order

Kafka Topic

order.created

Notes

Messages are serialized using Avro

Schemas are managed centrally using Schema Registry

Consumer uses KafkaAvroDeserializer with specific.avro.reader=true
