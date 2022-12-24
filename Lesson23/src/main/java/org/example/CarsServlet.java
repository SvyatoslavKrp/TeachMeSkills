package org.example;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@WebServlet(value = "/cars")
public class CarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addDateCooke(resp);

        ServletOutputStream outputStream = resp.getOutputStream();
        Map<String, Car> container = CarsContainer.getContainer();
        container.forEach((key, value) -> {
            try {
                outputStream.println(key + " " + value);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        String id = req.getParameter("id");
        if (container.containsKey(id)) {
            Car car = container.get(id);
            outputStream.println(car + " has id = " + id);
        } else {
            outputStream.print("There is no a car with this id");
        }
        outputStream.close();
        resp.sendRedirect("https://www.google.com/");
    }

    private static void addDateCooke(HttpServletResponse resp) {
        Date date = new Date();
        long time = date.getTime();
        Cookie cookie = new Cookie("lastVisit", String.valueOf(time));
        resp.addCookie(cookie);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        addDateCooke(resp);

        String model = req.getParameter("model");
        String color = req.getParameter("color");
        Map<String, Car> container = CarsContainer.getContainer();
        Car newCar = new Car(model, color);
        String id = CarsContainer.getNextId();
        container.put(id, newCar);
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.print(newCar + " has been added");
        outputStream.close();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        addDateCooke(resp);

        String id = req.getParameter("id");

        Map<String, Car> container = CarsContainer.getContainer();
        ServletOutputStream outputStream = resp.getOutputStream();

        if (container.containsKey(id)) {
            String newColor = req.getParameter("color");
            Car car = container.get(id);
            String oldColor = car.getColor();
            car.setColor(newColor);
            outputStream.print("The color of the " + car.getModel() + " has been changed from " + oldColor + " to " + newColor);
        } else {
            outputStream.print("There is no a car with this id");
        }
        outputStream.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        addDateCooke(resp);

        String id = req.getParameter("id");
        Map<String, Car> container = CarsContainer.getContainer();
        ServletOutputStream outputStream = resp.getOutputStream();

        if (container.containsKey(id)) {
            Car car = container.get(id);
            outputStream.print(car + " has been removed");
            container.remove(id);
        } else {
            outputStream.print("There is no a car with this id");
        }
        outputStream.close();
    }
}
