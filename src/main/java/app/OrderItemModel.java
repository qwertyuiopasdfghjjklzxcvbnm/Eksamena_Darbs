package app;

import java.util.UUID;

public class OrderItemModel {
    public int quantity;
    public double priceAtPurchase;
    public UUID id; 
    public UUID orderId; 
    public String sku;   

    public OrderItemModel(int quantity, double price, UUID orderId, String sku) {
        this.id = UUID.randomUUID();
        this.quantity = quantity;
        this.priceAtPurchase = price;
        this.orderId = orderId;
        this.sku = sku;
    }
}