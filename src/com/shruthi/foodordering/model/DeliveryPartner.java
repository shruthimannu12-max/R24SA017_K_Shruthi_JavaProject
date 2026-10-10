package com.shruthi.foodordering.model;

public class DeliveryPartner extends Person implements Payable {
    private String vehicleNumber;
    private double basePay;

    public DeliveryPartner() {
        this(0, "Unknown Partner", "Not Provided", Gender.OTHER, "NA", 50.0);
    }

    public DeliveryPartner(int id, String name, String phone, Gender gender,
                           String vehicleNumber, double basePay) {
        super(id, name, phone, gender);
        this.vehicleNumber = vehicleNumber;
        this.basePay = basePay;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public double getBasePay() {
        return basePay;
    }

    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    @Override
    public String getRole() {
        return "Delivery Partner";
    }

    @Override
    public void displayBasicInfo() {
        super.displayBasicInfo(); // super method call
        System.out.println("Role: " + getRole());
    }

    @Override
    public double calculatePay(double baseAmount) {
        return baseAmount + 20.0;
    }

    @Override
    public String toString() {
        return String.format("DeliveryPartner{id=%d, name='%s', vehicle='%s'}",
                getId(), getName(), vehicleNumber);
    }
}
