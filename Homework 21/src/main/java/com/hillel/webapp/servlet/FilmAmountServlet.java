package com.hillel.webapp.servlet;

import com.hillel.webapp.service.impl.FilmLibrary;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletForFilmAmount")
public class FilmAmountServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/filmAmountForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int amount = Integer.parseInt(request.getParameter("number"));
        request.setAttribute("number", amount);
        request.setAttribute("actors", FilmLibrary.getInstance().getActorsFilmNumber(amount));
        request.getRequestDispatcher("/jsp/getActorsByFilmAmount.jsp").forward(request, response);
    }
}