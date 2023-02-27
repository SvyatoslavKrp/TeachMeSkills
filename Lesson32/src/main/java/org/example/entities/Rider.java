package org.example.entities;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Getter
public class Rider {

    private double weight;

    @NotBlank
    @Size(min = 3, max = 10)
    private String name;

    public Rider(String name) {
        weight = (Math.random() * (100 - 40)) + 40;
        this.name = name;
    }
}
