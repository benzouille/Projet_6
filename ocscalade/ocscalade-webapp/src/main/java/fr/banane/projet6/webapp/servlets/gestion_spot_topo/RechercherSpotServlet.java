package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.DifficulteResource;
import fr.banane.projet6.webapp.resource.SpotResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RechercherSpotServlet extends HttpServlet {

    private DepartementResource vDepartementResource = new DepartementResource();

    private DifficulteResource vDifficulteResource = new DifficulteResource();

    private SpotResource vSpotResource = new SpotResource();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/rechercher_spot.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (req.getParameter("_recherche_spot_") != null) {

            String param1 = null,
                    param2 = null,
                    param3 = null;
            boolean param4 = false,
                    param5 = false;

            if (!req.getParameter("departement").equals("Séléctionnez")) {
                param1 = req.getParameter("departement");
            }
            if (!req.getParameter("difficulte").equals("Séléctionnez")) {
                param2 = req.getParameter("difficulte");
            }
            if (!req.getParameter("nbreSecteur").equals("Séléctionnez")) {
                param3 = req.getParameter("nbreSecteur");
            }
            if (req.getParameter("equipement") != null) {
                param4 = true;
            }
            if (req.getParameter("officiel") != null) {
                param5 = true;
            }

            if(param1 == null && param2 == null && param3 == null && !param4 && !param5){
                String erreur = "Aucun critère de recherche n'est entré !";
                req.setAttribute("erreur", erreur);
            }
            else {
                vSpotResource.getListSpotByQuery( param1, param2, param3, param4, param5);
                System.out.println("recherche : " + param1 + " " + param2 + " " + param3 + " " + param4 + " " + param5);
            }

            req.removeAttribute("departement");
            req.removeAttribute("difficulte");
            req.removeAttribute("nbreSecteur");
            req.removeAttribute("equipement");
            req.removeAttribute("officiel");

        }

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/rechercher_spot.jsp").forward(req, resp);
    }

    private void intiPage(HttpServletRequest req){

        List<Departement> vListDepartements = vDepartementResource.getListDepartement();
        req.setAttribute("vListDepartements", vListDepartements);

        List<Difficulte> vListDifficultes = vDifficulteResource.getListDifficulte();
        req.setAttribute("vListDifficultes", vListDifficultes);

        List<Spot> vListSpots = vSpotResource.getListSpot();
        ArrayList<Integer> vListNbreSecteurs = new ArrayList<>();


        for(Spot spot : vListSpots){
            vListNbreSecteurs.add(spot.getSecteurs().size());
        }
        Set<Integer> set = new HashSet<>(vListNbreSecteurs);
        vListNbreSecteurs.clear();
        vListNbreSecteurs.addAll(set);

        req.setAttribute("vListNbreSecteurs", vListNbreSecteurs);
    }
}

