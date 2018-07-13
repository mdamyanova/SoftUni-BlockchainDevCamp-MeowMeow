package org.meow.meow.servlets.cats;

import org.meow.meow.models.AdoptionCat;
import org.meow.meow.models.enums.Gender;
import org.meow.meow.repos.AdoptionCatRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/cats/add")
public class AddCatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gender");
        String town = req.getParameter("town");
        String description = req.getParameter("description");
        String imageHash = ""; // TODO
        String organization = req.getParameter("organization");

        AdoptionCat cat = new AdoptionCat(
                name, age, gender, town, description, imageHash, organization);

        ((AdoptionCatRepository)this.getServletContext().getAttribute("cats")).add(cat);

        resp.sendRedirect("/cats/profile?catName=" + cat.getName());
    }
}