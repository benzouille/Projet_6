package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.*;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.technical.SubStringDescription;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet de la liste de spots liée à la jsp spots corespondante, permet le choix de consulter un spot.
 */
public class SpotsServlet extends HttpServlet {

    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;

    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;

    private SubStringDescription subStringDescription = new SubStringDescription();

    private static final String cheminImage = "/static/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
    }

    /**
     * Initialisation de la servlet et transmission des données à la jsp
     * @param req la requete
     */
    private void initPage(HttpServletRequest req){

        HttpSession session = req.getSession();
        Utilisateur  vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");

        vListDepartements = vDepartementResource.getListDepartement();

        vListSpots = subStringDescription.cutDescription(vSpotResource.getListSpot());
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

        req.setAttribute("vListDepartements", vListDepartements);
        req.setAttribute("vListSpots", vListSpots);
    }
}

