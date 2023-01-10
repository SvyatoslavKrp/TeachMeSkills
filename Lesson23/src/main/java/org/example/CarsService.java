package org.example;

import java.util.List;

public interface CarsService {

    Car createCar(String id, String brand, String color);

    List<Car> getList();

    String generateId();

    Car getById(String id);

    void delete(String id);

    void repaintCar(String id, String newColor);

}
