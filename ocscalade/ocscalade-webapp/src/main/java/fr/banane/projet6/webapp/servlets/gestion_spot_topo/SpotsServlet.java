package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.*;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.technical.SubStringDescription;
import fr.banane.projet6.webapp.technical.TransfertImage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpotsServlet extends HttpServlet {

    private Spot vSpot;
    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;
    private List<Secteur> vListSecteurs;

    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;

    private TransfertImage transfertImage = new TransfertImage();
    private SubStringDescription subStringDescription = new SubStringDescription();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //--INIT
        HttpSession session = req.getSession();

        vListSpots = subStringDescription.cutDescription(vSpotResource.getListSpot());
        vListDepartements = vDepartementResource.getListDepartement();

        req.setAttribute("vListDepartements", vListDepartements);
        req.setAttribute("vListSpots", vListSpots);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spots.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Utilisateur  vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");

        //--Nouveau spot
        if(req.getParameter("_nouveau_spot_") != null) {

            vSpot = new Spot();
            vSpot.setNom(req.getParameter("nom"));
            System.out.println(vSpot.getNom());
            vSpot.setCreateur(vUtilisateur);
            System.out.println(vSpot.getCreateur().getPseudo());
            vSpot.setOfficiel(false);
            System.out.println(req.getParameter("departement"));
            vSpot.setDepartement(vDepartementResource.getDepartement(Integer.valueOf(req.getParameter("departement"))));
            vSpot.setAdresse(req.getParameter("localisation"));
            System.out.println(req.getParameter("description"));
            vSpot.setDescription(req.getParameter("description"));

            vSpotResource.newSpot(vSpot);

            vSpot = vSpotResource.getSpotByName(req.getParameter("nom"));

            //--IMAGE
            ArrayList<Part> parts = new ArrayList<>();

            // On récupère le champ du fichier
            if(req.getPart("image1") != null){
                parts.add(req.getPart("image1"));
            }
            if(req.getPart("image2") != null){
                parts.add(req.getPart("image2"));
            }
            if(req.getPart("image3") != null){
                parts.add(req.getPart("image3"));
            }


            for(int i =0; i<parts.size(); i++){
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

            this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
        }
    }
}
