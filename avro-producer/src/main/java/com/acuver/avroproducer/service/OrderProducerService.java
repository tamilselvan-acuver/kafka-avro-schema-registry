package com.acuver.avroproducer.service;


import com.example.avro.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducerService {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Value("${topic.order-created}")
    private String topicName;

    public OrderProducerService(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder() {

        com.example.avro.OrderCreatedEvent event = OrderCreatedEvent.newBuilder()
                .setOrderId("ORD-001")
                .setUserId("USR-101")
                .setAmount(1500.00)
                .setStatus("CREATED")
                .setCreatedAt(System.currentTimeMillis())
                .build();

        kafkaTemplate.send(topicName, event);

        System.out.println("Order event sent to Kafka: " + event);
    }
}
