package org.meow.meow.servlets.cats;

import org.meow.meow.models.AdoptionCat;
import org.meow.meow.repos.AdoptionCatRepository;
import org.meow.meow.services.implementations.IPFSServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

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
        Part image = req.getPart("image");
        String imageHash = new IPFSServiceImpl().add(image, name); // TODO - This is not good - Fix!
        String organization = req.getParameter("organization");
        AdoptionCat cat = new AdoptionCat(
                name, age, gender, town, description, imageHash, organization);
        ((AdoptionCatRepository)this.getServletContext().getAttribute("cats")).add(cat);
        // TODO - IPFS JSON file add :))) Important!!!
        resp.sendRedirect("/cats/profile?catName=" + cat.getName());
    }
}