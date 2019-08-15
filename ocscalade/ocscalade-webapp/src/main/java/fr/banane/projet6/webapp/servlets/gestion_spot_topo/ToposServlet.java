package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.webapp.resource.DepartementResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.TopoResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class ToposServlet extends HttpServlet {

    private TopoResource vTopoResource = new TopoResource();
    private List<Topo> vListTopos;

    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        vListSpots = vSpotResource.getListSpot();
        vListTopos = vTopoResource.getListTopo();

        req.setAttribute("vListSpots", vListSpots);
        req.setAttribute("vListTopos", vListTopos);



        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/topos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        vListTopos = vTopoResource.getListTopo();

        req.setAttribute("vListTopos", vListTopos);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/topos.jsp").forward(req, resp);
    }
}
