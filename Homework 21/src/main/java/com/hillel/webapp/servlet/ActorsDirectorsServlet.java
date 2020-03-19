package com.hillel.webapp.servlet;

import com.hillel.webapp.service.impl.FilmLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletForActorsDirectors")
public class ActorsDirectorsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("actors", FilmLibrary.getInstance().getActorsDirectors());
        request.getRequestDispatcher("/jsp/actorsAndDirectors.jsp").forward(request, response);
    }
}