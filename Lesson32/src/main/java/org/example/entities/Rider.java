package org.example.entities;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Rider {

    private double weight;
    private final String name;


    public Rider(String name) {
        weight = (Math.random() * (100 - 40)) + 40;
        this.name = name;
    }
}
