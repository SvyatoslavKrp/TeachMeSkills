package org.example.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Pair {

    private Horse horse;
    private Rider rider;
    private double speed;
    private boolean isChosen;
    private String pairName;

    public Pair(Horse horse, Rider rider) {
        this.horse = horse;
        this.rider = rider;

        pairName = rider.getName() + " is performing on " + horse.getName();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Double.compare(pair.speed, speed) == 0 && horse.equals(pair.horse) && rider.equals(pair.rider);
    }

}
