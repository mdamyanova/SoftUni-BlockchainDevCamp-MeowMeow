package org.meow.meow.servlets.users;

import org.meow.meow.models.User;
import org.meow.meow.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        if(!password.equals(confirmPassword)) {
            resp.sendRedirect("/users/register");
            return;
        }
        User user = new User(username, password);
        ((UserRepository)this.getServletContext().getAttribute("users")).add(user);
        resp.sendRedirect("/");
    }
}