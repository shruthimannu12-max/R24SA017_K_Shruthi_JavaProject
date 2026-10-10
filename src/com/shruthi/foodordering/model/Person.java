package com.shruthi.foodordering.model;

public abstract class Person {
    private int id;
    private String name;
    private String phone;
    private Gender gender;

    private static int personCount = 0;

    public Person() {
        this(0, "Unknown", "Not Provided", Gender.OTHER);
    }

    public Person(int id, String name, String phone, Gender gender) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        personCount++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public abstract String getRole();

    // Final because every person in this application uses the same identity format.
    public final String getIdentity() {
        return id + " - " + name;
    }

    public void displayBasicInfo() {
        System.out.println("Person: " + name + ", Phone: " + phone);
    }

    @Override
    public String toString() {
        return String.format("Person{id=%d, name='%s', phone='%s', gender=%s}",
                id, name, phone, gender);
    }
}
