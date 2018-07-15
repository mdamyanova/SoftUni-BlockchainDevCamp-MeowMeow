package org.meow.meow.servlets;

import org.meow.meow.repos.AdoptionCatRepository;
import org.meow.meow.repos.UserRepository;
import org.meow.meow.services.implementations.CatContractServiceImpl;
import org.meow.meow.services.interfaces.CatContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        this.getServletContext().setAttribute("cats", new AdoptionCatRepository());
        this.getServletContext().setAttribute("users", new UserRepository());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}