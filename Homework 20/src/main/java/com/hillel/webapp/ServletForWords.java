package com.hillel.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hillel.webapp.UtilClass.findWord;

@WebServlet("/ServletForWords")
public class ServletForWords extends HttpServlet {

    public ServletForWords() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("word");
        response.getWriter().append(findWord(text));
    }
}
