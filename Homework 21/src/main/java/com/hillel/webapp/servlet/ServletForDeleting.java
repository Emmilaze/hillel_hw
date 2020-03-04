package com.hillel.webapp.servlet;

import com.hillel.webapp.filmlibrary.FilmLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletForDeleting")
public class ServletForDeleting extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/deletingForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilmLibrary.getInstance().deleteOldFilms(Integer.parseInt(request.getParameter("years")));
        request.getRequestDispatcher("/deletingSuccess.jsp").forward(request, response);
    }
}
