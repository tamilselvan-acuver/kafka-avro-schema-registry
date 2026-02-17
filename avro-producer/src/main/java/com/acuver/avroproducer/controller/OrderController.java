package com.acuver.avroproducer.controller;

import com.acuver.avroproducer.service.OrderProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderProducerService orderProducerService;

    public OrderController(OrderProducerService orderProducerService) {
        this.orderProducerService = orderProducerService;
    }

    @GetMapping("/send")
    public String sendOrder() {
        orderProducerService.sendOrder();
        return "Order created event sent to Kafka";
    }
}
