package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.webapp.resource.DepartementResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RechercherTopoServlet extends HttpServlet {

    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        vListDepartements = vDepartementResource.getListDepartement();
        req.setAttribute("vListDepartements", vListDepartements);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/rechercher_topo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/rechercher_topo.jsp").forward(req, resp);
    }
}