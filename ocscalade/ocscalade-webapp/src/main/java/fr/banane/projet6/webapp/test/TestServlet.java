package fr.banane.projet6.webapp.test;

import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.webapp.resource.DepartementResource;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Test")
public class TestServlet extends HttpServlet {

    private DepartementResource vDepartementResource = new DepartementResource();
    Integer id_departement = -1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departements", vDepartementResource.getListDepartement());

        this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("_ok_") != null) {
            try {
                req.setAttribute("departements", vDepartementResource.getListDepartement());
                req.setAttribute("departement", vDepartementResource.getDepartement(Integer.parseInt(req.getParameter("id_departement"))));
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

            this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(req, resp);
    }
}
