package org.example.entities;

import lombok.Getter;

@Getter
public class Pair {

    private Horse horse;
    private Rider rider;
    private double speed;
    private boolean isChosen;

    public Pair(Horse horse, Rider rider) {
        this.horse = horse;
        this.rider = rider;

        double horseSpeed = horse.getSpeed();
        double riderWeight = rider.getWeight();

        this.speed = horseSpeed - ((horseSpeed * riderWeight) / 1000);
    }

    @Override
    public String toString() {
        String horseName = horse.getName();
        String riderName = rider.getName();

        return isChosen ?
                riderName + " is performing on " + horseName + " (your choice)" :
                riderName + " is performing on " + horseName;
    }

    public void setChosen(boolean isChosen) {
        this.isChosen = isChosen;
    }
}
