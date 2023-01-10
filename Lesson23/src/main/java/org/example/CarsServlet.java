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
import java.util.Set;

@WebServlet(value = "/cars")
public class CarsServlet extends HttpServlet {

    CarsService service = new CarsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addDateCooke(resp);

        ServletOutputStream outputStream = resp.getOutputStream();
        String id = req.getParameter("id");
        Car car = service.getById(id).orElse(null);

        if (car == null) {
            Set<String> keys = service.getContainer().keySet();
            for (String key : keys) {
                outputStream.println(key + " " + service.getContainer().get(key));
            }
        } else {
            outputStream.println(id + " " + car);
        }

        outputStream.close();

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

        Car car = service.createCar(model, color);

        ServletOutputStream outputStream = resp.getOutputStream();

        String id = service.getId();
        service.getContainer().put(id, car);
        outputStream.println(id + " " + car.toString());

        outputStream.close();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        addDateCooke(resp);

        String id = req.getParameter("id");

        ServletOutputStream outputStream = resp.getOutputStream();

        Car car = service.getById(id).orElse(null);

        if (car != null) {
            String color = req.getParameter("color");
            car.setColor(color);
            outputStream.println(id + " " + car + " has its color changed to " + color);
        }

        outputStream.close();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        addDateCooke(resp);

        String id = req.getParameter("id");
        ServletOutputStream outputStream = resp.getOutputStream();

        Car car = service.getById(id).orElse(null);

        if (car == null) {
            outputStream.println("There is no such car");
        } else {
            outputStream.println(id + " " + car + " has been removed");
            service.getContainer().remove(id);
        }

        outputStream.close();
    }
}
