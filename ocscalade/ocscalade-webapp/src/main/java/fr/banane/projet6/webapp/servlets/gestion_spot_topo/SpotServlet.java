package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.*;
import fr.banane.projet6.webapp.resource.CommentaireResource;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SecteurResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.technical.TransfertImage;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet d'un spot liée à la jsp spot corespondante, permet la consultation d'un spot, la création de nouveaux spot, commentaires, ajout d'image.
 */
public class SpotServlet extends HttpServlet {

    private  int id_spot;
    private Spot vSpot;
    private SpotResource vSpotResource = new SpotResource();

    private DepartementResource vDepartementResource = new DepartementResource();

    private Commentaire vCommentaire;
    private CommentaireResource vCommentaireResource = new CommentaireResource();

    private ArrayList<Image> vImages;
    private TransfertImage transfertImage = new TransfertImage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        Utilisateur  vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");

        //--NOUVEAU SPOT
        if(req.getParameter("_nouveau_spot_") != null) {

            vSpot = new Spot();
            vSpot.setNom(req.getParameter("nom"));
            vSpot.setCreateur(vUtilisateur);
            vSpot.setOfficiel(false);
            vSpot.setDepartement(vDepartementResource.getDepartementByNum(req.getParameter("departement")));
            vSpot.setAdresse(req.getParameter("localisation"));
            vSpot.setDescription(req.getParameter("description"));

            //mise en bdd
            vSpotResource.newSpot(vSpot);
            //appel de l'objet crée
            vSpot = vSpotResource.getSpotByName(req.getParameter("nom"));
            id_spot = vSpot.getId();
            //renvoi à la vue
            req.setAttribute("spot", vSpot);

            //mise a null de l'objet et des parametres
            vSpot = null;
            req.removeAttribute("_nouveau_spot_");
            req.removeAttribute("nom");
            req.removeAttribute("departement");
            req.removeAttribute("localisation");
            req.removeAttribute("description");
        }

        //--IMAGE
        if(req.getParameter("_image_") != null) {

            System.out.println("je passe par IMAGE de SpotServlet");

            ArrayList<Part> parts = new ArrayList<>();

            // On récupère le champ du fichier
            if (req.getPart("image1") != null) {
                parts.add(req.getPart("image1"));
            }
            if (req.getPart("image2") != null) {
                parts.add(req.getPart("image2"));
            }
            if (req.getPart("image3") != null) {
                parts.add(req.getPart("image3"));
            }

            for (int i = 0; i < parts.size(); i++) {
                // On vérifie qu'on a bien reçu un fichier
                String nomImage = transfertImage.getNomFichier(parts.get(i));

                // Si on a bien un fichier
                if (nomImage != null && !nomImage.isEmpty()) {
                    String nomChamp = parts.get(i).getName();
                    // Corrige un bug du fonctionnement d'Internet Explorer
                    nomImage = nomImage.substring(nomImage.lastIndexOf('/') + 1)
                            .substring(nomImage.lastIndexOf('\\') + 1);

                    // On écrit définitivement le fichier sur le disque
                    transfertImage.transfert(parts.get(i), nomImage);
                    Image vImage = new Image();
                    vImage.setId_spot(vSpot.getId());
                    vImage.setTitre(nomImage);
                }
            }
        }

        //--NOUVEAU COMMENTAIRE
        if(req.getParameter("_nouveau_commentaire_") != null) {

            vCommentaire = new Commentaire();
            vCommentaire.setIdSpot(id_spot);
            vCommentaire.setUtilisateur(vUtilisateur);
            vCommentaire.setCommentaire(req.getParameter("commentaire"));

            //set time
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            vCommentaire.setDate(timestamp);

            //mise en bdd
            vCommentaireResource.newCommentaire(vCommentaire);
            //appel de l'objet crée
            vSpot = vSpotResource.getSpot(id_spot);
            //renvoi à la vue
            req.setAttribute("spot", vSpot);

            //mise a null de l'objet et des parametres
            vCommentaire = null;
            req.removeAttribute("_nouveau_commentaire_");
            req.removeAttribute("commentaire");
        }

        //--SUPPRIMER COMMENTAIRE
        if(req.getParameter("_supprimer_commentaire_") != null) {

            //appel à la bdd
            vCommentaire = vCommentaireResource.getCommentaire(Integer.valueOf(req.getParameter("id_commentaire")));
            vCommentaireResource.deleteCommentaire(vCommentaire);

            //appel de l'objet modifié
            vSpot = vSpotResource.getSpot(id_spot);
            //renvoi à la vue
            req.setAttribute("spot", vSpot);

            //mise a null de l'objet et des parametres
            vCommentaire = null;
            req.removeAttribute("_supprimer_commentaire_");
            req.removeAttribute("id_commentaire");
        }

        //--MODIFIER COMMENTAIRE
        if(req.getParameter("_modifier_commentaire_") != null) {
            System.out.println("id commentaire : "+req.getParameter("id_modifier_commentaire"));
            //appel à la bdd
            vCommentaire = vCommentaireResource.getCommentaire(Integer.valueOf(req.getParameter("id_modifier_commentaire")));
            vCommentaire.setCommentaire(req.getParameter("modifier_commentaire"));
            vCommentaireResource.updateCommentaire(vCommentaire);

            //appel de l'objet modifié
            vSpot = vSpotResource.getSpot(id_spot);
            //renvoi à la vue
            req.setAttribute("spot", vSpot);

            //mise a null de l'objet et des parametres
            vCommentaire = null;
            req.removeAttribute("_modifier_commentaire_");
            req.removeAttribute("id_modifier_commentaire");
            req.removeAttribute("modifier_commentaire");
        }

        //--CONSULTATION D'UN SPOT
        if(req.getParameter("idSpot") != null) {
            id_spot = 0;
            id_spot = Integer.valueOf(req.getParameter("idSpot"));
            vSpot = vSpotResource.getSpot(id_spot);

            req.setAttribute("spot", vSpot);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
    }
}