package app;

import enums.ShoeCategory;

public class ShoeProductModel {
    public String name;
    public ShoeCategory category;
    public double price;
    public int stockQuantity;
    public int size_eu;
    public String color;
    public String material;
    public String stockID;

    public ShoeProductModel(String name, ShoeCategory category, double price, int stock, int size, String color, String material, String stockID) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stock;
        this.size_eu = size;
        this.color = color;
        this.material = material;
        this.stockID = stockID;
    }

    public String getName() {
        return name;
    }

    public ShoeCategory getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getSize_eu() {
        return size_eu;
    }
    
    public String getStockID() {
        return stockID;
    }
    
    public int getStockQuantity() {
        return stockQuantity;
    }
}