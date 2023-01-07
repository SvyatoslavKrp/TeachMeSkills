package org.example;

public class Car {

    private String id;
    private String brand;
    private String color;

    public Car() {
    }

    public Car(String id, String brand, String color) {
        this.id = id;
        this.brand = brand;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

}
