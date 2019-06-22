package fr.banane.projet6.webapp.servlets.gestion_utilisateur;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.UtilisateurResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NouvelUtilisateurServlet extends HttpServlet {

    private UtilisateurResource vUtilisateurResource = new UtilisateurResource();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/nouvel_utilisateur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("_ok_creation_") != null) {
            Utilisateur vUtilisateur = new Utilisateur();
            vUtilisateur.setPseudo(req.getParameter("pseudo"));
            vUtilisateur.setEmail(req.getParameter("email"));
            vUtilisateur.setPassword(req.getParameter("password"));

            if(vUtilisateurResource.utilisateurExist(vUtilisateur)) {
                vUtilisateurResource.newUtilisateur(vUtilisateur);
                this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);
            }
            else{
                String str = "Le pseudonyme existe déjà";
                req.setAttribute("erreur", str);
                vUtilisateur = null;
                this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/nouvel_utilisateur.jsp").forward(req, resp);

            }
        }

    }
}
