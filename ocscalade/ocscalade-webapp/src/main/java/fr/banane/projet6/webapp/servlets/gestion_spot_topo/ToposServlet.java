package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.webapp.resource.DepartementResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToposServlet extends HttpServlet {
    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        vListDepartements = vDepartementResource.getListDepartement();
        req.setAttribute("vListDepartements", vListDepartements);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/topos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/topos.jsp").forward(req, resp);
    }
}
