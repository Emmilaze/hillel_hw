package com.hillel.webapp.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

@WebServlet("/changeLangToRU")
public class RusLocale extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Config.set(request.getSession(), "javax.servlet.jsp.jstl.fmt.locale", "ru_RU");
        response.sendRedirect("mainPage");
    }
}
