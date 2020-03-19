package com.hillel.webapp.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hillel.webapp.filmlibrary.user.Role;
import com.hillel.webapp.filmlibrary.user.User;

@WebFilter("/ServletForDeleting")
public class DeleteRequestFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getMethod().equals("POST")) {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null && user.getRole() == Role.ADMIN) {
                chain.doFilter(request, response);
            } else {
                request.setAttribute("error", "You don't have permission!");
                request.getRequestDispatcher("/jsp/deletingForm.jsp").forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}