package fr.banane.projet6.webapp.servlets;

import fr.banane.projet6.model.bean.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IndexServlet extends HttpServlet {

    private Utilisateur vUtilisateur;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session != null){
            vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");
        }

        this.getServletContext().getRequestDispatcher("/../index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/../index.jsp").forward(req, resp);
    }
}
