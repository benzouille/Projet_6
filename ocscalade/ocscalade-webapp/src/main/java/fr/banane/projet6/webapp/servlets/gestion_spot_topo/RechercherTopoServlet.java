package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.TopoResource;
import fr.banane.projet6.webapp.resource.UtilisateurResource;
import fr.banane.projet6.webapp.technical.FormatDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RechercherTopoServlet extends HttpServlet {

    private DepartementResource vDepartementResource = new DepartementResource();

    private SpotResource vSpotResource = new SpotResource();

    private TopoResource vTopoResource = new TopoResource();

    private UtilisateurResource vUtilisateurResource = new UtilisateurResource();

    private FormatDate formatDate = new FormatDate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/rechercher_topo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //--RECHERCHE TOPO
        if (req.getParameter("_recherche_topo_") != null) {

            String departement = null,
                    spot = null,
                    createur = null,
                    date = null;
            boolean disponible = false;

            if (!req.getParameter("departement").equals("Séléctionnez")) {

                departement = String.valueOf(vDepartementResource.getDepartementByNum(req.getParameter("departement")).getId());
            }
            if (!req.getParameter("spot").equals("Séléctionnez")) {
                spot = String.valueOf(vSpotResource.getSpotByName(req.getParameter("spot")).getId());
            }
            if (!req.getParameter("createur").equals("Séléctionnez")) {
                createur = String.valueOf(vUtilisateurResource.getUtilisateurByPseudo(req.getParameter("createur")).getId());
            }
            if (!req.getParameter("date").equals("")) {
                System.out.println("la date : "+req.getParameter("date"));
                date = req.getParameter("date");
            }
            else{
                date = null;
            }

            if (req.getParameter("disponible") != null) {
                disponible = true;
            }

            if(departement == null && spot == null && createur == null && date == null && !disponible){
                String erreur = "Aucun critère de recherche n'est entré !";
                req.setAttribute("erreur", erreur);
            }
            else {
                List<Topo> vListTopoRecherche = vTopoResource.getListTopoByQuery( departement, spot, createur, formatDate.stringToTimestamp(date), disponible);
                System.out.println(vListTopoRecherche.toString());
                req.setAttribute("vListTopoRecherche", vListTopoRecherche);
            }

            req.removeAttribute("departement");
            req.removeAttribute("spot");
            req.removeAttribute("createur");
            req.removeAttribute("date");
            req.removeAttribute("disponible");

        }

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/rechercher_topo.jsp").forward(req, resp);
    }

    private void intiPage(HttpServletRequest req){

        List<Departement> vListDepartements = vDepartementResource.getListDepartement();
        req.setAttribute("vListDepartements", vListDepartements);


        List<Topo> vListTopos = vTopoResource.getListTopo();
        req.setAttribute("vListTopos", vListTopos);

        List<String> vListSpots = new ArrayList<>();
        List<String> vListUtilisateurs = new ArrayList<>();
        for(Topo topo : vListTopos){
            vListSpots.add(topo.getSpot().getNom());
            vListUtilisateurs.add(topo.getUtilisateur().getPseudo());
        }
        Set<String> set = new HashSet<>(vListSpots);
        vListSpots.clear();
        vListSpots.addAll(set);
        Set<String> set2 = new HashSet<>(vListUtilisateurs);
        vListUtilisateurs.clear();
        vListUtilisateurs.addAll(set2);

        req.setAttribute("vListSpots", vListSpots);
        req.setAttribute("vListUtilisateurs", vListUtilisateurs);
    }
}