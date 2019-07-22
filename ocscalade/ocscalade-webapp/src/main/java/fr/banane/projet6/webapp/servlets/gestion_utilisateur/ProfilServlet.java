package fr.banane.projet6.webapp.servlets.gestion_utilisateur;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.bean.Sexe;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SexeResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfilServlet extends HttpServlet {

    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;
    private SexeResource vSexeResource = new SexeResource();
    private List<Sexe> vListSexes;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        vListDepartements = vDepartementResource.getListDepartement();
        vListSexes = vSexeResource.getListSexe();

        req.setAttribute("vListSexes", vListSexes);
        req.setAttribute("vListDepartements", vListDepartements);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/profil.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
