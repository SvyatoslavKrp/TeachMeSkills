package org.example;

import java.util.*;

public class CarsService {
    private Map<String, Car> container = new HashMap<>() {{
        put(getId(), new Car("opel", "white"));
        put(getId(), new Car("mazda", "grey"));
        put(getId(), new Car("bmw", "black"));
        put(getId(), new Car("jmc", "red"));
        put(getId(), new Car("fiat", "green"));
    }};

    public String getId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public Optional<Car> getById(String id) {
        return Optional.ofNullable(container.get(id));
    }

    public Map<String, Car> getContainer() {
        if (container.size() != 0) {
            return container;
        } else {
            throw new RuntimeException("The garage is empty");
        }
    }

    public Car createCar(String model, String color) {

        if (model == null) throw new RuntimeException("The model of a car hasn't been typed in");

        return new Car(model, Objects.requireNonNullElse(color, ""));
    }
}
