package com.acuver.avroconsumer.dto;

import com.example.avro.OrderCreatedEvent;

public class OrderDto {

    private String orderId;
    private String userId;
    private double amount;
    private String status;
    private long createdAt;

    public OrderDto() {
    }

    public OrderDto(String orderId, String userId, double amount, String status, long createdAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public static OrderDto fromEvent(OrderCreatedEvent event) {
        if (event == null) {
            return null;
        }
        return new OrderDto(
                event.getOrderId(),
                event.getUserId(),
                event.getAmount(),
                event.getStatus(),
                event.getCreatedAt()
        );
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
