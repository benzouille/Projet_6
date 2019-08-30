package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.SpotResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionSpotsServlet extends HttpServlet {

    private Spot vSpot;
    private List<Spot> vListSpots;
    private SpotResource vSpotResource = new SpotResource();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/gestion_spots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //--MODIFIER SPOT
        if(req.getParameter("_spot_officiel_") != null) {

            //appel à la bdd
            vSpot = vSpotResource.getSpot(Integer.parseInt(req.getParameter("idSpot")));

            if (req.getParameter("spot_officiel") != null){
                vSpot.setOfficiel(true);
            }
            else{
                vSpot.setOfficiel(false);
            }

            vSpotResource.updateSpot(vSpot);

            //mise a null de l'objet et des parametres
            vSpot = null;
            req.removeAttribute("_spot_officiel_");
            req.removeAttribute("idSpot");
            req.removeAttribute("spot_officiel");

        }

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/gestion_spots.jsp").forward(req, resp);
    }


    private void intiPage(HttpServletRequest req){
        Utilisateur utilisateur = (Utilisateur)req.getSession().getAttribute("utilisateur");

        vListSpots = vSpotResource.getListSpot();
        req.setAttribute("vListSpots", vListSpots);
    }
}