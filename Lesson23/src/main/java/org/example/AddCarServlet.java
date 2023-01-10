package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/add")
public class AddCarServlet extends HttpServlet {

    private final CarsServiceImpl carService = new CarsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = carService.getList();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = carService.generateId();
        String brand = req.getParameter("brand");
        String color = req.getParameter("color");

        Car car = new Car(id, brand, color);

        carService.add(car);

        resp.sendRedirect("/add");
    }
}
