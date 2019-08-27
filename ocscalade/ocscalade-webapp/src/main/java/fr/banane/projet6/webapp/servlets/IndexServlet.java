package fr.banane.projet6.webapp.servlets;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.UtilisateurResource;
import fr.banane.projet6.webapp.technical.PasswordDigest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private Utilisateur vUtilisateur;
    private UtilisateurResource vUtilisateurResource = new UtilisateurResource();

    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session != null){
            vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");
        }

        vListSpots = vSpotResource.getListSpot();

        //reduction des déscriptions
        for (int i = 0; i < vListSpots.size(); i++) {
            String str;
            if(vListSpots.get(i).getDescription().length()>31){
                str = vListSpots.get(i).getDescription().substring(0, 30)+"...";
                vListSpots.get(i).setDescription(str);
            }
        }
        req.setAttribute("vListSpots", vListSpots);

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
            System.out.println("mpd connexion : " + password);

            vUtilisateur = vUtilisateurResource.getUtilisateurByPseudo(pseudo);
            if (password.equals(vUtilisateur.getPassword())) {
                session.setAttribute("utilisateur", vUtilisateur);
                this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);
            }
        }

        vListSpots = vSpotResource.getListSpot();

        //reduction des déscriptions
        for (int i = 0; i < vListSpots.size(); i++) {
            String str;
            if(vListSpots.get(i).getDescription().length()>31){
                str = vListSpots.get(i).getDescription().substring(0, 30)+"...";
                vListSpots.get(i).setDescription(str);
            }
        }
        req.setAttribute("vListSpots", vListSpots);

        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
