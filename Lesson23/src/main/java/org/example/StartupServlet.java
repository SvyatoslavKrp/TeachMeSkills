package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(value = "/", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");

//            для теста
//            Connection connection = getConnection();
//            connection.createStatement().execute("DROP TABLE IF EXIST cars");
//            connection.createStatement().execute("CREATE TABLE cars (id VARCHAR PRIMARY KEY " +
//                    " brand varchar NOT NULL" +
//                    " color varchar)");

        } catch (ClassNotFoundException e) {
            System.out.println("Connection exc " + e);
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection exc " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/title.jsp").forward(request, response);
    }
}
