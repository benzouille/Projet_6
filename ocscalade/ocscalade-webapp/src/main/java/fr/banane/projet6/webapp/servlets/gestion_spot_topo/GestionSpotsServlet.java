package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.TechnicalException;
import fr.banane.projet6.webapp.resource.SpotResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Servlet de la jsp gestion_spots utilisé par les modérateur pour officialiser ou non les spots
 */
public class GestionSpotsServlet extends HttpServlet {

    private Spot vSpot;
    private List<Spot> vListSpots;
    private SpotResource vSpotResource = new SpotResource();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/gestion_spots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //--MODIFIER SPOT
        if(req.getParameter("_spot_officiel_") != null) {

            //appel à la bdd
            try {
                vSpot = vSpotResource.getSpot(Integer.parseInt(req.getParameter("idSpot")));
            } catch (TechnicalException e) {
                e.printStackTrace();
            }

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

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/gestion_spots.jsp").forward(req, resp);
    }

    /**
     * Initialisation de la servlet et transmission des données à la jsp
     * @param req la requete
     */
    private void initPage(HttpServletRequest req){
        Utilisateur utilisateur = (Utilisateur)req.getSession().getAttribute("utilisateur");

        vListSpots = vSpotResource.getListSpot();
        req.setAttribute("vListSpots", vListSpots);
    }
}