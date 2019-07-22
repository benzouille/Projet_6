package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SpotResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SpotsServlet extends HttpServlet {

    private Spot spot;

    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;

    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        vListSpots = vSpotResource.getListSpot();
        vListDepartements = vDepartementResource.getListDepartement();

        req.setAttribute("vListDepartements", vListDepartements);
        req.setAttribute("vListSpots", vListSpots);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("_ok_") != null) {
            spot = new Spot();
            spot.setNom(req.getParameter("nom"));
            spot.setAdresse(req.getParameter("localisation"));
            //spot.setDepartement(req.getParameter("departement"));
            spot.setDescription(req.getParameter("description"));
            req.getParameter("image1");
            req.getParameter("image2");
            req.getParameter("image3");
        }


        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }
}
