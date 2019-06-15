package fr.banane.projet6.webapp.servlets.gestion_utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NouvelUtilisateurServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/nouvel_utilisateur.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean accurate = true;

        if (accurate) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/nouvel_utilisateur.jsp").forward(req, resp);
    }
}
