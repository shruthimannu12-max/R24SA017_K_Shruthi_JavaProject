package com.shruthi.foodordering.app;

import java.util.Scanner;
import com.shruthi.foodordering.model.*;
import com.shruthi.foodordering.service.FoodOrderingService;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        FoodOrderingService service = new FoodOrderingService();

        System.out.println("==============================================");
        System.out.println(AppConfig.APP_NAME);
        System.out.println("==============================================");

        // Array of objects.
        FoodItem[] menu = service.getMenu();

        // Demonstrating dynamic binding: parent reference points to child objects.
        Person person1 = new Customer(1, "Shruthi", "9876543210",
                Gender.FEMALE, "Bengaluru", 1000.0);
        Person person2 = new DeliveryPartner(2, "Arun", "9123456780",
                Gender.MALE, "KA01AB1234", 50.0);

        System.out.println("\n--- Dynamic Binding Demo ---");
        person1.displayBasicInfo();
        person2.displayBasicInfo();

        // Interface reference accessing an implemented class.
        Discountable discountRef = (Customer) person1;
        System.out.printf("Interface discount on ₹600: ₹%.2f%n",
                discountRef.calculateDiscount(600));

        Payable payableRef = (DeliveryPartner) person2;
        System.out.printf("Interface delivery partner pay: ₹%.2f%n",
                payableRef.calculatePay(50));

        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    displayMenu(menu);
                    break;

                case 2:
                    String keyword = readLine("Enter food/category to search: ");
                    service.searchMenu(keyword);
                    break;

                case 3:
                    String category = readLine(
                            "Enter category (Fast Food/Main Course/South Indian/Dessert): ");
                    service.showCategory(category);
                    break;

                case 4:
                    placeOrder(service);
                    break;

                case 5:
                    System.out.println("\n--- Object Statistics ---");
                    System.out.println("FoodItem objects created : " + FoodItem.getItemCount());
                    System.out.println("Person objects created   : " + Person.getPersonCount());
                    System.out.println("Order objects created    : " + Order.getOrderCount());
                    System.out.println("Service menu calls       : " + FoodOrderingService.getServiceCalls());
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using the Online Food Ordering System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        SCANNER.close();
    }

    private static void printMenu() {
        System.out.println("\n------------- MAIN MENU -------------");
        System.out.println("1. Display Food Menu");
        System.out.println("2. Search Food");
        System.out.println("3. Filter by Category");
        System.out.println("4. Place Order");
        System.out.println("5. Show Object Statistics");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------");
    }

    private static void displayMenu(FoodItem[] menu) {
        System.out.println("\nID  Food                 Category      Price      Status");
        System.out.println("-----------------------------------------------------------");
        for (FoodItem item : menu) {
            System.out.println(item);
        }
    }

    private static void placeOrder(FoodOrderingService service) {
        String name = readLine("Enter customer name: ").trim();
        String phone = readLine("Enter phone number: ").trim();
        String address = readLine("Enter delivery address: ").trim();

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            System.out.println("Customer details cannot be empty.");
            return;
        }

        Customer customer = new Customer(
                Person.getPersonCount() + 1,
                name,
                phone,
                Gender.OTHER,
                address,
                2000.0
        );

        Order order = service.createOrder(customer);
        System.out.println("\nCreated: " + order);

        while (true) {
            displayMenu(service.getMenu());
            int id = readInt("Enter food ID (0 to finish): ");

            if (id == 0) {
                break;
            }

            FoodItem item = service.findItem(id);

            if (item == null) {
                System.out.println("Invalid food ID.");
                continue;
            }

            int quantity = readInt("Enter quantity: ");

            if (quantity <= 0) {
                System.out.println("Quantity must be positive.");
                continue;
            }

            order.addItem(item, quantity); // overloaded method
            System.out.println(quantity + " x " + item.getName() + " added.");
        }

        if (order.getItems().isEmpty()) {
            System.out.println("No items selected. Order cancelled.");
            return;
        }

        if (order.calculateFoodTotal() < AppConfig.MIN_ORDER_AMOUNT) {
            System.out.printf("Minimum order amount is ₹%.2f%n",
                    AppConfig.MIN_ORDER_AMOUNT);
            return;
        }

        order.printBill();
        order.setPaid(true);
        System.out.println("Payment Status: PAID");
        System.out.println("Order saved successfully.");
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static String readLine(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }
}
