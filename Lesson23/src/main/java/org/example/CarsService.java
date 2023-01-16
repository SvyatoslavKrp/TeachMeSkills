package org.example;

import java.util.List;

public interface CarsService {

    List<Car> getList();

    String generateId();

    Car getById(String id);

    void delete(String id);

    void repaintCar(String id, String newColor);

}
