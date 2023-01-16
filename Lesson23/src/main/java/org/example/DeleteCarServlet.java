package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteCarServlet", value = "/delete")
public class DeleteCarServlet extends HttpServlet {
    private final CarsService carService = new CarsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> cars = carService.getList();
        request.setAttribute("cars", cars);
        request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        carService.delete(id);
        response.sendRedirect("/delete");
    }
}
