package com.hillel.webapp.servlet;

import com.hillel.webapp.filmlibrary.user.User;
import com.hillel.webapp.service.UserService;
import com.hillel.webapp.service.impl.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService;

    public LoginServlet() {
        userService = new UserManager();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/Homework 21/mainPage");
        } else {
            request.setAttribute("error", "User not found or wrong password");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}