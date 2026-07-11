package com.weather;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String city = request.getParameter("city");

        WeatherService service = new WeatherService();

        String weather = service.getWeather(city);

        request.setAttribute("weather", weather);

        request.getRequestDispatcher("result.jsp")
                .forward(request,response);

    }
}