package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.bean.Secteur;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.webapp.resource.DifficulteResource;
import fr.banane.projet6.webapp.resource.SecteurResource;
import fr.banane.projet6.webapp.resource.SpotResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SecteurServlet extends HttpServlet {

    private Secteur vSecteur;
    private SecteurResource vSecteurResource = new SecteurResource();

    private Spot vSpot;
    private SpotResource vSpotResource = new SpotResource();

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
        //Lien secteur
        int id_secteur = 0;
        if(req.getParameter("_secteur_") != null){
            id_secteur = Integer.valueOf(req.getParameter("id_secteur"));
            vSecteur = vSecteurResource.getSecteur(id_secteur);
            String vCreateur = vSpotResource.getSpot(vSecteur.getId_spot()).getCreateur().getPseudo();
            req.setAttribute("vCreateur", vCreateur);
            req.setAttribute("vSecteur", vSecteur);
            this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/secteur.jsp").forward(req, resp);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/secteur.jsp").forward(req, resp);
    }
}