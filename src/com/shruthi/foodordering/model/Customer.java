package com.shruthi.foodordering.model;

public class Customer extends Person implements Discountable {
    private String address;
    private double walletBalance;

    public Customer() {
        this(0, "Guest", "Not Provided", Gender.OTHER, "Not Provided", 0.0);
    }

    public Customer(int id, String name, String phone, Gender gender,
                    String address, double walletBalance) {
        super(id, name, phone, gender);
        this.address = address;
        this.walletBalance = walletBalance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    @Override
    public void displayBasicInfo() {
        super.displayBasicInfo(); // super method call
        System.out.println("Role: " + getRole());
    }

    @Override
    public double calculateDiscount(double amount) {
        return amount >= 500 ? amount * 0.10 : 0.0;
    }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, name='%s', address='%s', wallet=%.2f}",
                getId(), getName(), address, walletBalance);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer other = (Customer) obj;
        return getId() == other.getId();
    }
}
