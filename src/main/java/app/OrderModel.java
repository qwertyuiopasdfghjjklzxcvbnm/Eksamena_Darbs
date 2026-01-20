package app;

import java.time.LocalDate;
import java.util.UUID;

import enums.OrderStatus;

public class OrderModel {
    public LocalDate orderDate;
    public OrderStatus status;
    public double totalAmount;
    public UUID id;
    public UUID customerID;

    public OrderModel(double totalAmount, UUID customerID) {
        this.id = UUID.randomUUID();
        this.orderDate = LocalDate.now();
        this.status = OrderStatus.PENDING;
        this.totalAmount = totalAmount;
        this.customerID = customerID;
    }
}