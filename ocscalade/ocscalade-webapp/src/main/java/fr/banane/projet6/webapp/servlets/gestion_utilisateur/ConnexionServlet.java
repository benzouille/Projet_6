package fr.banane.projet6.webapp.servlets.gestion_utilisateur;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.UtilisateurResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConnexionServlet extends HttpServlet {

    //TODO voir la portée de la connexion à session, revoir comment on fait.
    private UtilisateurResource vUtilisateurResource = new UtilisateurResource();
    private Utilisateur vUtilisateur;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if(req.getParameter("_ok_") != null) {

                String pseudo = req.getParameter("pseudo");
                String password = req.getParameter("password");

                vUtilisateur = vUtilisateurResource.getUtilisateurByPseudo(pseudo);
                if(password.equals(vUtilisateur.getPassword())){
                    session.setAttribute("utilisateur", vUtilisateur);
                    this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                }
                else {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);
                }
                //System.out.println("pseudo : "+pseudo+", password : "+password+".");
        }
    }
}
