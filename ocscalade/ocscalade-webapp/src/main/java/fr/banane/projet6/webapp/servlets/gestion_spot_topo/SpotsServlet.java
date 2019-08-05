package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.*;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.technical.SubStringDescription;
import fr.banane.projet6.webapp.technical.TransfertImage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpotsServlet extends HttpServlet {

    private Spot vSpot;
    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;
    private List<Secteur> vListSecteurs;

    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;


    private SubStringDescription subStringDescription = new SubStringDescription();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //--INIT
        HttpSession session = req.getSession();

        vListSpots = subStringDescription.cutDescription(vSpotResource.getListSpot());
        vListDepartements = vDepartementResource.getListDepartement();

        req.setAttribute("vListDepartements", vListDepartements);
        req.setAttribute("vListSpots", vListSpots);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Utilisateur  vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }
}
