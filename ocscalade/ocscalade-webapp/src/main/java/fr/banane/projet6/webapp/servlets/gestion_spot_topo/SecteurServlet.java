package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.*;
import fr.banane.projet6.model.exception.TechnicalException;
import fr.banane.projet6.webapp.resource.DifficulteResource;
import fr.banane.projet6.webapp.resource.SecteurResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.VoieResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Classe Servlet de la jsp secteur permettant d'afficher un secteur ou créer un nouveau secteurs ou nouvelle voie.
 */
public class SecteurServlet extends HttpServlet {

    String vCreateur;

    private int id_secteur;
    private Secteur vSecteur;
    private SecteurResource vSecteurResource = new SecteurResource();

    private Spot vSpot;
    private SpotResource vSpotResource = new SpotResource();

    private Voie vVoie;
    private VoieResource vVoieResource = new VoieResource();

    private DifficulteResource vDifficulteResource = new DifficulteResource();
    private List<Difficulte> vListDifficultes;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/secteur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        Utilisateur vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");

        //--NOUVEAU SECTEUR
        if(req.getParameter("_nouveau_secteur_") != null) {

            vSecteur = new Secteur();
            vSecteur.setId_spot(Integer.valueOf(req.getParameter("id_spot")));
            vSecteur.setNom(req.getParameter("nom"));
            vSecteur.setDescription(req.getParameter("description"));

            //mise en bdd
            vSecteurResource.newSecteur(vSecteur);
            //appel de l'objet crée
            vSecteur = vSecteurResource.getSecteurByName(req.getParameter("nom"));
            vCreateur = null;
            try {
                vCreateur = vSpotResource.getSpot(vSecteur.getId_spot()).getCreateur().getPseudo();
            } catch (TechnicalException e) {
                req.setAttribute("erreur", e.getMessage());
                this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
                e.printStackTrace();
            }
            id_secteur = vSecteur.getId();

            //mise a null de l'objet et des parametres

            req.removeAttribute("_nouveau_secteur_");
            req.removeAttribute("id_spot");
            req.removeAttribute("nom");
            req.removeAttribute("description");
        }

        //--NOUVELLE VOIE
        if(req.getParameter("_nouvelle_voie_") != null) {
//
            vVoie = new Voie();
            vVoie.setId_secteur(id_secteur);
            vVoie.setNom(req.getParameter("nom"));

                try {
                    vVoie.setDifficulte(vDifficulteResource.getDifficulte(req.getParameter("difficulte")));
                } catch (TechnicalException e) {
                    e.printStackTrace();
                }
            if(req.getParameter("equipement") != null) {
                vVoie.setEquipement(true);
                vVoie.setNb_point(Integer.valueOf(req.getParameter("nb_point")));
            }
            vVoie.setNb_longueur(Integer.valueOf(req.getParameter("nb_longueur")));
            vVoie.setDescription(req.getParameter("description"));

            //mise en bdd
            vVoieResource.newVoie(vVoie);

            vCreateur = null;
            try {
                vCreateur = vSpotResource.getSpot(vSecteur.getId_spot()).getCreateur().getPseudo();
            } catch (TechnicalException e) {
                req.setAttribute("erreur", e.getMessage());
                this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
                e.printStackTrace();
            }

            //mise a zero des parametres
            req.removeAttribute("_nouvelle_voie_");
            req.removeAttribute("nom");
            req.removeAttribute("difficulte");
            req.removeAttribute("equipement");
            req.removeAttribute("nb_point");
            req.removeAttribute("nb_longueur");
            req.removeAttribute("description");
        }

        //--LIEN SECTEUR

        if(req.getParameter("_secteur_") != null){
            id_secteur = 0;
            id_secteur = Integer.valueOf(req.getParameter("id_secteur"));
            vSecteur = vSecteurResource.getSecteur(id_secteur);
            vCreateur = null;
            try {
                vCreateur = vSpotResource.getSpot(vSecteur.getId_spot()).getCreateur().getPseudo();
            } catch (TechnicalException e) {
                req.setAttribute("erreur", e.getMessage());
                this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
                e.printStackTrace();
            }

        }

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/secteur.jsp").forward(req, resp);
    }

    /**
     * Initialisation de la servlet et transmission des données à la jsp
     * @param req la requete
     */
    private void initPage(HttpServletRequest req){

        vListDifficultes = vDifficulteResource.getListDifficulte();

        vSecteur = vSecteurResource.getSecteur(id_secteur);
        try {
            vSpot = vSpotResource.getSpot(vSecteur.getId_spot());
        } catch (TechnicalException e) {
            e.printStackTrace();
        }

        req.setAttribute("vListDifficultes", vListDifficultes);
        req.setAttribute("vCreateur", vCreateur);
        req.setAttribute("vSecteur", vSecteur);
        req.setAttribute("vSpot", vSpot);
    }
}