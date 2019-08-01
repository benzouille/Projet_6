package fr.banane.projet6.webapp.test;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.UtilisateurResource;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Test")
public class TestServlet extends HttpServlet {

    private UtilisateurResource vUtilisateurResource = new UtilisateurResource();
    private DepartementResource vDepartementResource = new DepartementResource();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("departements", vDepartementResource.getListDepartement());

        this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("_ok_") != null) {
            System.out.println("passé par _ok_");
                req.setAttribute("departements", vDepartementResource.getListDepartement());
                req.setAttribute("departement", vDepartementResource.getDepartement(Integer.parseInt(req.getParameter("id_departement"))));
        }

        if(req.getParameter("_ok_connexion_") != null) {
            System.out.println("passé par _ok_connexion_");
            req.setAttribute("utilisateur", vUtilisateurResource.getUtilisateurByPseudo(req.getParameter("pseudo")));
        }

        if(req.getParameter("_ok_creation_") != null) {
            System.out.println("passé par _ok_creation_");
            Utilisateur vUtilisateur = new Utilisateur();
            vUtilisateur.setPseudo(req.getParameter("pseudo"));
            vUtilisateur.setEmail(req.getParameter("email"));
            vUtilisateur.setPassword(req.getParameter("password"));

            vUtilisateurResource.newUtilisateur(vUtilisateur);

            req.setAttribute("utilisateur", vUtilisateurResource.getUtilisateurByPseudo(req.getParameter("pseudo")));
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(req, resp);
    }
}
