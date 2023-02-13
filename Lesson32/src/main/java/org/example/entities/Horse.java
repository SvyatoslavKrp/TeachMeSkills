package org.example.entities;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Horse {

    private double speed;
    private String name;

    public Horse(String name) {
        speed = (Math.random() * (89 - 50)) + 50;
        this.name = name;
    }

    public double horseEndurance() {
        return (Math.random() * (20 - 1) + 20);
    }
}
