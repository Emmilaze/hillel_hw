package com.hillel.webapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hillel.webapp.UtilClass.sortArray;

@WebServlet("/ServletForArray")
public class ServletForArray extends HttpServlet {

    public ServletForArray() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String input = request.getParameter("array");
        response.getWriter().append(sortArray(input));
    }
}
