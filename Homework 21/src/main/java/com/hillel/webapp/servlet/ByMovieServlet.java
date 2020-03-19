package com.hillel.webapp.servlet;

import com.hillel.webapp.service.impl.FilmLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletForActorsByMovie")
public class ByMovieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/FilmNameForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmName = request.getParameter("filmName");
        request.setAttribute("actors", FilmLibrary.getInstance().getActorsByFilm(filmName));
        request.setAttribute("film", filmName);
        request.getRequestDispatcher("/jsp/getActorsByFilm.jsp").forward(request, response);
    }
}