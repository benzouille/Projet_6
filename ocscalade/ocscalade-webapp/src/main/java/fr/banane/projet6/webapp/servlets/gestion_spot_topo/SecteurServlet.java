package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.bean.Secteur;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Voie;
import fr.banane.projet6.webapp.resource.DifficulteResource;
import fr.banane.projet6.webapp.resource.SecteurResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.VoieResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SecteurServlet extends HttpServlet {

    private int id_secteur;
    private Secteur vSecteur;
    private SecteurResource vSecteurResource = new SecteurResource();

    private SpotResource vSpotResource = new SpotResource();

    private Voie vVoie;
    private VoieResource vVoieResource = new VoieResource();

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

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        vListDifficultes = vDifficulteResource.getListDifficulte();
        req.setAttribute("vListDifficultes", vListDifficultes);

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
            String vCreateur = vSpotResource.getSpot(vSecteur.getId_spot()).getCreateur().getPseudo();
            id_secteur = vSecteur.getId();
            //renvoi à la vue
            req.setAttribute("vCreateur", vCreateur);
            req.setAttribute("vSecteur", vSecteur);

            //mise a null de l'objet et des parametres
            vSecteur = null;
            req.removeAttribute("_nouveau_secteur_");
            req.removeAttribute("id_spot");
            req.removeAttribute("nom");
            req.removeAttribute("description");
        }

        //--NOUVELLE VOIE
        if(req.getParameter("_nouvelle_voie_") != null) {
//            System.out.println("je passe par NOUVELLE VOIE de SecteurServlet");
//            System.out.println(" voie diff : "+req.getParameter("difficulte"));
//            System.out.println(" voie equi : "+req.getParameter("equipement"));
//            System.out.println(" voie desc : "+req.getParameter("description"));

            vVoie = new Voie();
            vVoie.setId_secteur(id_secteur);
            vVoie.setNom(req.getParameter("nom"));
            vVoie.setDifficulte(vDifficulteResource.getDifficulte(req.getParameter("difficulte")));
            if(req.getParameter("equipement") != null) {
                vVoie.setEquipement(true);
                vVoie.setNb_point(Integer.valueOf(req.getParameter("nb_point")));
            }
            vVoie.setNb_longueur(Integer.valueOf(req.getParameter("nb_longueur")));
            vVoie.setDescription(req.getParameter("description"));

            //mise en bdd
            vVoieResource.newVoie(vVoie);
            //appel de l'objet crée
            vSecteur = vSecteurResource.getSecteur(id_secteur);
            String vCreateur = vSpotResource.getSpot(vSecteur.getId_spot()).getCreateur().getPseudo();
            //renvoi à la vue
            req.setAttribute("vCreateur", vCreateur);
            req.setAttribute("vSecteur", vSecteur);

            //mise a zero de l'objet et des parametres
            vVoie = null;
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
            System.out.println("lien secteur : " +vSecteur.getVoies().toString());
            String vCreateur = vSpotResource.getSpot(vSecteur.getId_spot()).getCreateur().getPseudo();
            req.setAttribute("vCreateur", vCreateur);
            req.setAttribute("vSecteur", vSecteur);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/secteur.jsp").forward(req, resp);
    }
}