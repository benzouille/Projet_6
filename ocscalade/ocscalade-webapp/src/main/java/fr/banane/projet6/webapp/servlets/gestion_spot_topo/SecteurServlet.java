package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.webapp.resource.DifficulteResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SecteurServlet extends HttpServlet {

    private DifficulteResource vDifficulteResource = new DifficulteResource();
    private List<Difficulte> vListDifficultes;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        vListDifficultes = vDifficulteResource.getListDifficulte();
        req.setAttribute("vListDifficultes", vListDifficultes);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/secteur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/secteur.jsp").forward(req, resp);
    }
}