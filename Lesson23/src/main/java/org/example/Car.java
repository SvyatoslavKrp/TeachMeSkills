package org.example;

import org.apache.commons.lang3.StringUtils;

public class Car {

    private String id;
    private String brand;
    private String color = "a color hasn't been entered";

    public Car(String id, String brand, String color) {
        this.id = id;
        this.brand = brand;
        if (!StringUtils.isBlank(color)) {
            this.color = color;
        }
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

    public String getColor() {
        return color;
    }
}
