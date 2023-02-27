package org.example.entities;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Getter
public class Horse {

    private double speed;
    @NotBlank
    @Size(min = 3, max = 10)
    private String name;

    public Horse(String name) {
        this.name = name;
        speed = (Math.random() * (55 - 50)) + 50;
    }

    public double horseEndurance() {
        return (Math.random() * (20 - 1) + 20);
    }
}
