package com.shruthi.foodordering.model;

import java.util.ArrayList;
import java.util.List;

public class Order implements Payable {
    private int orderId;
    private Customer customer;
    private List<FoodItem> items;
    private double deliveryFee;
    private boolean paid;

    private static int orderCount = 0;

    public Order() {
        this(0, null);
    }

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.deliveryFee = 40.0;
        this.paid = false;
        orderCount++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    // Method overloading: add one item or add the same item multiple times.
    public void addItem(FoodItem item) {
        if (item != null && item.isAvailable()) {
            items.add(item);
        }
    }

    public void addItem(FoodItem item, int quantity) {
        if (item == null || !item.isAvailable()) {
            return;
        }
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public double calculateFoodTotal() {
        double total = 0.0; // local variable
        for (FoodItem item : items) { // enhanced for loop
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public double calculatePay(double baseAmount) {
        return baseAmount + deliveryFee;
    }

    public void printBill() {
        double foodTotal = calculateFoodTotal();
        double discount = customer.calculateDiscount(foodTotal);
        double subtotal = foodTotal - discount;
        double finalAmount = calculatePay(subtotal);

        // Explicit narrowing conversion: double to int.
        int roundedBill = (int) finalAmount;

        // Operator precedence: * happens before +, so tax is calculated correctly.
        double tax = foodTotal * 0.05 + deliveryFee * 0.00;
        finalAmount += tax;

        System.out.println("\n========== ORDER BILL ==========");
        System.out.printf("Order ID      : %d%n", orderId);
        System.out.printf("Customer      : %s%n", customer.getName());
        System.out.printf("Food Total    : ₹%.2f%n", foodTotal);
        System.out.printf("Discount      : ₹%.2f%n", discount);
        System.out.printf("Delivery Fee  : ₹%.2f%n", deliveryFee);
        System.out.printf("Tax (5%%)      : ₹%.2f%n", tax);
        System.out.printf("Final Amount  : ₹%.2f%n", finalAmount);
        System.out.printf("Integer Bill  : ₹%d (after casting)%n", roundedBill);
        System.out.println("================================");
    }

    @Override
    public String toString() {
        return String.format("Order{id=%d, customer='%s', items=%d, paid=%s}",
                orderId, customer.getName(), items.size(), paid);
    }
}
