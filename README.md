# R24SA017_K_Shruthi_JavaProject
Online Food Ordering System using Java
# K SHRUTHI - Online Food Ordering System

## Mini Project - Console-Based Real-World Application Using Java

### 1\. Objective

The Online Food Ordering System is a console-based Java application that allows a customer to view food items, search/filter the menu, create an order, calculate discounts and delivery charges, and display the final bill.

The project demonstrates the required Object-Oriented Programming concepts from Unit I and Unit II.

### 2\. Package Structure

```text
src/
└── com/shruthi/foodordering/
    ├── app/
    │   └── Main.java
    ├── model/
    │   ├── AppConfig.java
    │   ├── Customer.java
    │   ├── DeliveryPartner.java
    │   ├── Discountable.java
    │   ├── FoodItem.java
    │   ├── Gender.java
    │   ├── Order.java
    │   ├── Payable.java
    │   └── Person.java
    └── service/
        └── FoodOrderingService.java
```

### 3\. Traceability of Mandatory Features

|Requirement|Implementation|
|-|-|
|3-4 classes with encapsulation|`Person`, `Customer`, `DeliveryPartner`, `FoodItem`, `Order` - all fields are private with getters/setters|
|Varied data types|`int`, `double`, `String`, `boolean`, `enum` in model classes|
|final constants|`AppConfig.APP\_NAME`, `AppConfig.MIN\_ORDER\_AMOUNT`, `Main.SCANNER`|
|Variable scope|Instance fields in `Person`, `FoodOrderingService`; local variables in `calculateFoodTotal()` and `placeOrder()`; static fields such as counters|
|Operators|Arithmetic, relational, logical, assignment and conditional operators throughout the project|
|Operator precedence|`double tax = foodTotal \* 0.05 + deliveryFee \* 0.00;` (`\*` evaluated before `+`) in `Order.printBill()`|
|Type conversion/casting|`int roundedBill = (int) finalAmount;` in `Order.printBill()`|
|Enum|`Gender.java`|
|if-else|`Order`, `FoodOrderingService`, `Main`|
|switch|Main menu in `Main.java`|
|Loops|`while`, `for`, enhanced `for` in `Main`, `Order`, `FoodOrderingService`|
|Jump statements|`break`, `continue`, `return`|
|Array of objects|`FoodItem\[] menu` in `FoodOrderingService` and `Main`|
|Console I/O|`Scanner` in `Main.java`|
|Formatted output|`System.out.printf()` and `String.format()`|
|Constructor overloading|Default and parameterized constructors in `Person`, `Customer`, `DeliveryPartner`, `FoodItem`, `Order`|
|Method overloading|`Order.addItem(FoodItem)` and `Order.addItem(FoodItem, int)`|
|Static fields/methods|`personCount`, `itemCount`, `orderCount`, `serviceCalls` and getter methods|
|this reference|Constructor chaining such as `this(0, "Unknown", ...)`|
|String methods|`trim()`, `split()`, `contains()`, `equalsIgnoreCase()`, `toLowerCase()`|
|Base class + 2 subclasses|`Person` -> `Customer`, `DeliveryPartner`|
|super keyword|Child constructors call `super(...)`; overridden `displayBasicInfo()` calls `super.displayBasicInfo()`|
|Method overriding|`getRole()`, `displayBasicInfo()`, `toString()`|
|Dynamic binding|`Person person1/person2` refer to `Customer`/`DeliveryPartner`; overridden methods execute at runtime|
|Abstract class + abstract method|`Person` and abstract `getRole()`|
|Interface|`Discountable`, `Payable`; accessed through interface references|
|Object class overriding|`toString()` and `equals()`|
|final method/class|`Person.getIdentity()` is final; `AppConfig` is final. Final prevents unintended overriding/inheritance for these fixed-purpose elements|
|2+ custom packages|`com.shruthi.foodordering.model`, `com.shruthi.foodordering.service`, `com.shruthi.foodordering.app`|
|Correct imports|`Main.java` and `FoodOrderingService.java` use package imports|

### 4\. Compilation and Execution

From the project root:

```bash
javac -d out $(find src -name "\*.java")
java -cp out com.shruthi.foodordering.app.Main
```

On Windows PowerShell:

```powershell
javac -d out (Get-ChildItem -Recurse src -Filter \*.java | ForEach-Object {$\_.FullName})
java -cp out com.shruthi.foodordering.app.Main
```

### 5\. Sample Console Output

```text
==============================================
SHRUTHI'S ONLINE FOOD ORDERING SYSTEM
==============================================

--- Dynamic Binding Demo ---
Person: Shruthi, Phone: 9876543210
Role: Customer
Person: Arun, Phone: 9123456780
Role: Delivery Partner
Interface discount on ₹600: ₹60.00
Interface delivery partner pay: ₹70.00

------------- MAIN MENU -------------
1. Display Food Menu
2. Search Food
3. Filter by Category
4. Place Order
5. Show Object Statistics
0. Exit
-------------------------------------
Enter your choice: 4

Enter customer name: K Shruthi
Enter phone number: 9876543210
Enter delivery address: Bengaluru

Created: Order{id=1001, customer='K Shruthi', items=0, paid=false}

Enter food ID (0 to finish): 2
Enter quantity: 2
2 x Chicken Biryani added.

Enter food ID (0 to finish): 5
Enter quantity: 1
1 x Chocolate Cake added.

Enter food ID (0 to finish): 0

========== ORDER BILL ==========
Order ID      : 1001
Customer      : K Shruthi
Food Total    : ₹590.00
Discount      : ₹59.00
Delivery Fee  : ₹40.00
Tax (5%)      : ₹29.50
Final Amount  : ₹600.50
Integer Bill  : ₹571 (after casting)
================================
Payment Status: PAID
Order saved successfully.

Thank you for using the Online Food Ordering System!
```

### 6\. Conclusion

The project successfully implements a real-world online food ordering workflow using Java. It demonstrates encapsulation, inheritance, abstraction, polymorphism, interfaces, constructors, method overloading/overriding, arrays, control flow, exception handling, static members, final members, type casting, strings, packages, and formatted console I/O.

### 

