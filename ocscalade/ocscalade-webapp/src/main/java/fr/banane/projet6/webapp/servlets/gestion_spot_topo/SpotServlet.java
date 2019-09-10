package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.*;
import fr.banane.projet6.model.exception.TechnicalException;
import fr.banane.projet6.webapp.resource.CommentaireResource;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.ImageResource;
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

    private ImageResource vImageResource = new ImageResource();

    private static final String cheminImage = "/static/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        initPage(req, resp);

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

            //mise a null de l'objet et des parametres
            vSpot = null;
            req.removeAttribute("_nouveau_spot_");
            req.removeAttribute("nom");
            req.removeAttribute("departement");
            req.removeAttribute("localisation");
            req.removeAttribute("description");
        }

        //--NOUVELLE IMAGE
        if(req.getParameter("_image_") != null) {

            ArrayList<Part> parts = new ArrayList<>();

            // On récupère le champ du fichier
            if (req.getPart("image1").getSize() > 0) {
                parts.add(req.getPart("image1"));;
            }
            if (req.getPart("image2").getSize() > 0) {
                parts.add(req.getPart("image2"));
            }
            if (req.getPart("image3").getSize() > 0) {
                parts.add(req.getPart("image3"));
            }

            for (Part part : parts) {
                // On vérifie qu'on a bien reçu un fichier
                String nomImage = TransfertImage.getNomFichier(part);

                // Si on a bien un fichier
                if (nomImage != null && !nomImage.isEmpty()) {
                    // Corrige un bug du fonctionnement d'Internet Explorer
                    nomImage = nomImage.substring(nomImage.lastIndexOf('/') + 1)
                            .substring(nomImage.lastIndexOf('\\') + 1);

                    // On écrit définitivement le fichier sur le disque
                    TransfertImage.transfert(part, nomImage);
                    Image vImage = new Image();
                    vImage.setId_spot(vSpot.getId());
                    vImage.setTitre(nomImage);
                    vImageResource.newImage(vImage);
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
            try {
                vCommentaireResource.newCommentaire(vCommentaire);
            } catch (TechnicalException e) {
                req.setAttribute("erreur", e.getMessage());
                this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
                e.printStackTrace();
            }

            //mise a null de l'objet et des parametres
            vCommentaire = null;
            req.removeAttribute("_nouveau_commentaire_");
            req.removeAttribute("commentaire");
        }

        //--SUPPRIMER COMMENTAIRE
        if(req.getParameter("_supprimer_commentaire_") != null) {

            //appel à la bdd
            try {
                vCommentaire = vCommentaireResource.getCommentaire(Integer.valueOf(req.getParameter("id_commentaire")));
            } catch (TechnicalException e) {
                req.setAttribute("erreur", e.getMessage());
                this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
                e.printStackTrace();
            }
            vCommentaireResource.deleteCommentaire(vCommentaire);

            //mise a null de l'objet et des parametres
            vCommentaire = null;
            req.removeAttribute("_supprimer_commentaire_");
            req.removeAttribute("id_commentaire");
        }

        //--MODIFIER COMMENTAIRE
        if(req.getParameter("_modifier_commentaire_") != null) {

            //appel à la bdd
            try {
                vCommentaire = vCommentaireResource.getCommentaire(Integer.valueOf(req.getParameter("id_modifier_commentaire")));
            } catch (TechnicalException e) {
                req.setAttribute("erreur", e.getMessage());
                this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
                e.printStackTrace();
            }
            vCommentaire.setCommentaire(req.getParameter("modifier_commentaire"));
            vCommentaireResource.updateCommentaire(vCommentaire);

            //mise a null de l'objet et des parametres
            vCommentaire = null;
            req.removeAttribute("_modifier_commentaire_");
            req.removeAttribute("id_modifier_commentaire");
            req.removeAttribute("modifier_commentaire");
        }

        //--CONSULTATION D'UN SPOT
        if(req.getParameter("idSpot") != null) {
            id_spot = Integer.valueOf(req.getParameter("idSpot"));
        }

        initPage(req, resp);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
    }

    /**
     * Initialisation de la servlet et transmission des données à la jsp
     * @param req la requete
     */
    private void initPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            vSpot = vSpotResource.getSpot(id_spot);
        } catch (TechnicalException e) {
            req.setAttribute("erreur", e.getMessage());
            this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
            e.printStackTrace();
        }

        List<String> vListImagesPath = new ArrayList<>();
        if(vSpot.getImages().size() != 0){
            for (Image image : vSpot.getImages()){
                vListImagesPath.add(cheminImage + image.getTitre());
            }
        }
        else{
            vListImagesPath.add(cheminImage + "default.jpg");
        }

        boolean imageFull = false;

        if(vSpot.getImages().size() == 3){
            imageFull = true;
        }

        req.setAttribute("spot", vSpot);
        req.setAttribute("vListImagesPath", vListImagesPath);
        req.setAttribute("imageFull", imageFull);
    }
}