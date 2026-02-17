package com.acuver.avroconsumer.controller;

import com.acuver.avroconsumer.dto.OrderDto;
import com.acuver.avroconsumer.service.OrderConsumerService;
import com.example.avro.OrderCreatedEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderConsumerController {
    private final OrderConsumerService consumerService;

    public OrderConsumerController(OrderConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/last-order")
    public Object getLastOrder() {
        OrderCreatedEvent order = consumerService.getLastOrder();
        if (order == null) {
            return "No order consumed yet";
        }
        return new OrderDto(
                order.getOrderId(),
                order.getUserId(),
                order.getAmount(),
                order.getStatus(),
                order.getCreatedAt()
        );
    }

}
