package com.acuver.avroconsumer.service;

import com.example.avro.OrderCreatedEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerService {

    private OrderCreatedEvent lastOrder;

    @KafkaListener(topics = "${topic.order-created}", groupId = "order-consumer-group")
    public void consume(ConsumerRecord<String, OrderCreatedEvent> record) {

        OrderCreatedEvent event = record.value();

        System.out.println("Order received from Kafka");
        System.out.println("OrderId : " + event.getOrderId());
        System.out.println("Amount  : " + event.getAmount());

        this.lastOrder = event;
    }

    public OrderCreatedEvent getLastOrder() {
        return lastOrder;
    }
}
