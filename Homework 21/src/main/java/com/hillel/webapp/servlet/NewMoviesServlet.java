package com.hillel.webapp.servlet;

import com.hillel.webapp.service.impl.FilmLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletForNewMovies")
public class NewMoviesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies", FilmLibrary.getInstance().getNewFilms());
        request.getRequestDispatcher("/jsp/recentMovies.jsp").forward(request, response);
    }
}