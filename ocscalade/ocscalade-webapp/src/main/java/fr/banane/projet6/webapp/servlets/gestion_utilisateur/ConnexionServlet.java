package fr.banane.projet6.webapp.servlets.gestion_utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConnexionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("_ok_") != null) {
                //req.setAttribute("pseudo", vDepartementResource.getListDepartement());
                //req.setAttribute("password", vDepartementResource.getDepartement(Integer.parseInt(req.getParameter("id_departement"))));
                String pseudo = req.getParameter("pseudo");
                String password = req.getParameter("password");

                System.out.println("pseudo : "+pseudo+", password : "+password+".");
        }

        boolean connect = false;
        boolean new_user = false;

        if(!connect)
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/connexion.jsp").forward(req, resp);

        if(new_user)
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/nouvel_utilisateur.jsp").forward(req, resp);

        if (connect)
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
