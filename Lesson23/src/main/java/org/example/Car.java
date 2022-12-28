package org.example;

public class Car {

    private final String model;
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.model + " " + this.color;
    }

}
