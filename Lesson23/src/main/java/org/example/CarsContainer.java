package org.example;

import java.util.HashMap;
import java.util.Map;

public class CarsContainer {
    private static volatile Map<String, Car> container = new HashMap<>() {{
        put("1", new Car("opel", "white"));
        put("2", new Car("mazda", "grey"));
        put("3", new Car("bmw", "black"));
        put("4", new Car("jmc", "red"));
        put("5", new Car("fiat", "green"));
    }};
    private static String currentId = String.valueOf(container.size());

    public static Map<String, Car> getContainer() {
        return container;
    }

    public static synchronized String getNextId() {
        int id = Integer.parseInt(currentId);
        id++;
        currentId = String.valueOf(id);
        return String.valueOf(id);
    }
}
