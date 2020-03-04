package com.hillel.webapp.servlet;

import com.hillel.webapp.filmlibrary.FilmLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletForNewMovies")
public class ServletForNewMovies extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("movies", FilmLibrary.getInstance().getNewFilms());
        request.getRequestDispatcher("/recentMovies.jsp").forward(request, response);
    }
}