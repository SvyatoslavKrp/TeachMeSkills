package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateCarServlet", value = "/update")
public class UpdateCarServlet extends HttpServlet {
    private CarsService carsService = new CarsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> cars = carsService.getList();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String newColor = request.getParameter("newColor");
        carsService.repaintCar(id, newColor);
        response.sendRedirect("/update");
    }
}
