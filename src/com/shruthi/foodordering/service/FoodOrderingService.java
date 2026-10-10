package com.shruthi.foodordering.service;

import com.shruthi.foodordering.model.*;

public class FoodOrderingService {
    private final FoodItem[] menu;

    // Instance field: belongs to each FoodOrderingService object.
    private int nextOrderId = 1001;

    // Static field: shared by all FoodOrderingService objects.
    private static int serviceCalls = 0;

    public FoodOrderingService() {
        menu = new FoodItem[] {
            new FoodItem(1, "Veg Burger", 120.00, "Fast Food", true),
            new FoodItem(2, "Chicken Biryani", 220.00, "Main Course", true),
            new FoodItem(3, "Paneer Pizza", 280.00, "Fast Food", true),
            new FoodItem(4, "Masala Dosa", 90.00, "South Indian", true),
            new FoodItem(5, "Chocolate Cake", 150.00, "Dessert", true)
        };
    }

    public FoodItem[] getMenu() {
        serviceCalls++;
        return menu;
    }

    public static int getServiceCalls() {
        return serviceCalls;
    }

    public FoodItem findItem(int id) {
        for (FoodItem item : menu) {
            if (item.getItemId() == id) {
                return item;
            }
        }
        return null;
    }

    public void searchMenu(String keyword) {
        String cleaned = keyword.trim(); // String trim()
        if (cleaned.isEmpty()) {
            System.out.println("Search keyword cannot be empty.");
            return;
        }

        String[] words = cleaned.split("\\s+"); // String split()
        System.out.println("\nSearch results for: " + cleaned);

        boolean found = false;
        for (FoodItem item : menu) {
            if (item.getName().toLowerCase().contains(cleaned.toLowerCase()) ||
                item.getCategory().toLowerCase().contains(cleaned.toLowerCase())) { // contains()
                System.out.println(item);
                found = true;
            }
        }

        if (words.length > 1) {
            System.out.println("Search terms detected: " + words.length);
        }

        if (!found) {
            System.out.println("No matching food item found.");
        }
    }

    public void showCategory(String category) {
        System.out.println("\nCategory: " + category);
        for (FoodItem item : menu) {
            if (!item.getCategory().equalsIgnoreCase(category)) { // String comparison
                continue; // jump statement
            }
            System.out.println(item);
        }
    }

    public Order createOrder(Customer customer) {
        if (customer == null) {
            return null; // jump statement
        }
        return new Order(nextOrderId++, customer);
    }
}
