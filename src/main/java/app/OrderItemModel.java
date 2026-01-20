package app;

import java.util.UUID;

public class OrderItemModel {
    public int quantity;
    public double price;
    public UUID id; 
    public UUID orderId; 
    public String stockID;   

    public OrderItemModel(int quantity, double price, UUID orderId, String stockID) {
        this.id = UUID.randomUUID();
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.stockID = stockID;
    }
}