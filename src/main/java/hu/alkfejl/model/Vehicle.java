package hu.alkfejl.model;

import javafx.fxml.FXML;

import java.util.regex.Pattern;

public class Vehicle {
    private String licencePlate;
    private boolean active;
    private Category category;
    private int age;


    public Vehicle() {
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        if(Pattern.matches("^[A-Z]{3}[0-9]{3}$", licencePlate))
            this.licencePlate = licencePlate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public enum Category{
        CAR, BIKE, TRUCK;
    }
}
