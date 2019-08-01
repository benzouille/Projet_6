package fr.banane.projet6.webapp.servlets;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.SpotResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {

    private Utilisateur vUtilisateur;

    private Spot vSpot;
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

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(req.getParameter("_disconnect_") != null) {
            session.invalidate();
        }
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
