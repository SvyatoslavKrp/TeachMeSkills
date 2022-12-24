package org.example;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/cars")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletOutputStream outputStream = response.getOutputStream();
        String requestString = ((HttpServletRequest) request).getMethod();
        if ("get".equalsIgnoreCase(requestString)) {
            outputStream.println("the filter has worked");
            chain.doFilter(request, response);
        }

        String headerName = ((HttpServletRequest) request).getHeader("id");

        if (headerName == null) {
            outputStream.println("the filter has caught smth");
            throw new ServletException();
        } else {
            outputStream.print("the filter has worked");
            chain.doFilter(request, response);
        }
        outputStream.close();
    }

    @Override
    public void destroy() {

    }
}
