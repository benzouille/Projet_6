package fr.banane.projet6.webapp.servlets.gestion_utilisateur;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.bean.Sexe;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SexeResource;
import fr.banane.projet6.webapp.resource.UtilisateurResource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfilServlet extends HttpServlet {

    private Utilisateur vUtilisateur;
    private UtilisateurResource vUtilisateurResource = new UtilisateurResource();

    private DepartementResource vDepartementResource = new DepartementResource();
    private List<Departement> vListDepartements;
    private Departement vDepartement;
    private SexeResource vSexeResource = new SexeResource();
    private List<Sexe> vListSexes;
    private Sexe vSexe;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/profil.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        if(session != null) {
            vUtilisateur = (Utilisateur) session.getAttribute("utilisateur");
        }

        //--MODIFIER PROFIL
        if(req.getParameter("_modifier_profil_") != null){

            if (!req.getParameter("departement").equals("Séléctionnez")) {
                vDepartement = vDepartementResource.getDepartementByNum(req.getParameter("departement"));
                vUtilisateur.setDepartement(vDepartement);
            }
            if (!req.getParameter("sexe").equals("Séléctionnez")) {
                vSexe = vSexeResource.getSexeBySexe(req.getParameter("sexe"));
                vUtilisateur.setSexe(vSexe);
            }
            if (!req.getParameter("email").equals(vUtilisateur.getEmail())){
                vUtilisateur.setEmail(req.getParameter("email"));
            }

            vUtilisateurResource.updateUtilisateur(vUtilisateur);

            req.removeAttribute("departement");
            req.removeAttribute("sexe");
            req.removeAttribute("email");
            req.removeAttribute("_modifier_profil_");
        }

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_utilisateur/profil.jsp").forward(req, resp);
    }

    private void initPage(HttpServletRequest req){

        vListDepartements = vDepartementResource.getListDepartement();
        vListSexes = vSexeResource.getListSexe();

        req.setAttribute("vListSexes", vListSexes);
        req.setAttribute("vListDepartements", vListDepartements);
    }
}
