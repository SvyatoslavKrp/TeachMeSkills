package org.example;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarsServiceImpl implements CarsService {

    private final StartupServlet startupServlet = new StartupServlet();

    @Override
    public List<Car> getList() {
        Connection connection = startupServlet.getConnection();
        List<Car> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars");
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String brand = resultSet.getString("brand");
                String color = resultSet.getString("color");
                Car car = new Car(id, brand, color);
                list.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Get list exc " + e);
            throw new RuntimeException();
        }
        return list;
    }

    public void add(Car car) {
        Connection connection = startupServlet.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cars (id, brand, color) values (?, ?, ?)");
            preparedStatement.setString(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getColor());

            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("add car exc");
            throw new RuntimeException();
        }
    }

    @Override
    public String generateId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public Car getById(String id) {
        Connection connection = startupServlet.getConnection();
        Car car = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars WHERE id = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String brand = resultSet.getString("brand");
                String color = resultSet.getString("color");
                car = new Car(id, brand, color);
            }
        } catch (SQLException e) {
            System.out.println("getByIdExc");
            throw new RuntimeException(e);
        }
        if (car == null) throw new RuntimeException("the car hasn't been found");
        return car;
    }

    public void delete(String id) {
        Connection connection = startupServlet.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cars WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("delete exc");
            throw new RuntimeException();
        }
    }

    @Override
    public void repaintCar(String id, String newColor) {
        Connection connection = startupServlet.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cars " +
                    "SET color = ? " +
                    "WHERE id = ?");
            if (StringUtils.isBlank(newColor)) {
                newColor = "a color hasn't been entered";
            }
            preparedStatement.setString(1, newColor);
            preparedStatement.setString(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("repaint car exc");
            throw new RuntimeException(e);
        }
    }
}
