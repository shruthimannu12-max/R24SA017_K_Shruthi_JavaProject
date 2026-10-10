package com.shruthi.foodordering.model;

public class FoodItem {
    private int itemId;
    private String name;
    private double price;
    private String category;
    private boolean available;

    private static int itemCount = 0;

    public FoodItem() {
        this(0, "Unknown Food", 0.0, "General", true);
    }

    public FoodItem(int itemId, String name, double price, String category, boolean available) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.available = available;
        itemCount++;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public static int getItemCount() {
        return itemCount;
    }

    @Override
    public String toString() {
        return String.format("%-3d %-20s %-12s ₹%7.2f %-9s",
                itemId, name, category, price, available ? "Available" : "Sold Out");
    }
}
