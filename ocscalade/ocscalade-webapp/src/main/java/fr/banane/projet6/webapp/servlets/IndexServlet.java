package fr.banane.projet6.webapp.servlets;

import fr.banane.projet6.model.bean.Image;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.TechnicalException;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.UtilisateurResource;
import fr.banane.projet6.webapp.technical.PasswordDigest;
import fr.banane.projet6.webapp.technical.SubStringDescription;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Servlet de la jsp index
 */
public class IndexServlet extends HttpServlet {

    private Utilisateur vUtilisateur;
    private UtilisateurResource vUtilisateurResource = new UtilisateurResource();

    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;

    private SubStringDescription subStringDescription = new SubStringDescription();

    private static final String cheminImage = "/static/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session != null){
            vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");
        }

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(req.getParameter("_disconnect_") != null) {
            session.invalidate();
        }

        if(req.getParameter("_ok_") != null) {

            String pseudo = req.getParameter("pseudo");
            String password = PasswordDigest.hashAndSalt(req.getParameter("password"));

            try {
                vUtilisateur = vUtilisateurResource.getUtilisateurByPseudo(pseudo);
            } catch (TechnicalException e) {
                req.setAttribute("erreur", e.getMessage());
                this.getServletContext().getRequestDispatcher("/WEB-INF/error_page.jsp").forward(req, resp);
                e.printStackTrace();
            }
            if (password.equals(vUtilisateur.getPassword())) {
                session.setAttribute("utilisateur", vUtilisateur);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);
            }
        }

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    /**
     * Initialisation de la servlet et transmission des données à la jsp
     * @param req la requete
     */
    private void initPage(HttpServletRequest req){

        vListSpots = subStringDescription.cutDescription(vSpotResource.getListSpotForIndex());

        for(Spot vSpot : vListSpots) {
            if(vSpot.getImages().size() != 0){
                for (Image image : vSpot.getImages()){
                    image.setTitre(cheminImage + image.getTitre());
                }
            }
            else {
                Image vImage = new Image();
                vImage.setTitre(cheminImage + "default.jpg");
                List<Image> images = new ArrayList<>();
                images.add(vImage);
                vSpot.setImages(images);
            }
        }

        List<String> images = new ArrayList<>();
        images.add(cheminImage + "faille_1920_600.jpg");
        images.add(cheminImage + "gorge_1920_600.jpg");
        images.add(cheminImage + "pic_1920_600.jpg");

        req.setAttribute("vListSpots", vListSpots);
        req.setAttribute("images", images);

    }
}
