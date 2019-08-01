package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.*;
import fr.banane.projet6.webapp.resource.SecteurResource;
import fr.banane.projet6.webapp.resource.SpotResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class SpotServlet extends HttpServlet {

    private Spot vSpot;
    private SpotResource vSpotResource = new SpotResource();

    private ArrayList<Commentaire> vCommentaires;


    private ArrayList<Secteur> vSecteurs;

    private ArrayList<Image> vImages;

    private int idSpot;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println("je passe par doGet de SpotServlet");


        if(req.getParameter("idSpot") != null) {
            idSpot = Integer.valueOf(req.getParameter("idSpot"));
            vSpot = vSpotResource.getSpot(idSpot);
            req.setAttribute("spot", vSpot);
            System.out.println("je passe par if de SpotServlet");
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("je passe par doPost de SpotServlet");

        if(req.getParameter("idSpot") != null) {
            idSpot = Integer.valueOf(req.getParameter("idSpot"));
            vSpot = vSpotResource.getSpot(idSpot);
            req.setAttribute("spot", vSpot);
            System.out.println("je passe par if de SpotServlet");
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
        //this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/spot.jsp").forward(req, resp);
    }
}