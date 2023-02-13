package org.tms.lesson31;


import lombok.Getter;

@Getter
public enum Position {

    DIRECTOR(1.3, 1500),
    WORKER(1.1, 1000);

    private final double coef;
    private final double baseRate;

    Position(double coef, double baseRate) {
        this.coef = coef;
        this.baseRate = baseRate;
    }

}
