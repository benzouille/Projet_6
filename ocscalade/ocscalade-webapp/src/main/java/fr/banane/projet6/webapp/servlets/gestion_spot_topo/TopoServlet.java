package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.TopoResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

public class TopoServlet extends HttpServlet {

    private  int id_topo;
    private Topo vTopo;
    private TopoResource vTopoResource = new TopoResource();

    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        vListSpots = vSpotResource.getListSpot();
        req.setAttribute("vListSpots", vListSpots);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/topo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        Utilisateur vUtilisateur = (Utilisateur)session.getAttribute("utilisateur");

        //--NOUVEAU TOPO
        if(req.getParameter("_nouveau_topo_") != null) {
            System.out.println("je passe par NOUVEAU TOPO de TopoServlet");

            vTopo = new Topo();
            vTopo.setNom(req.getParameter("nom"));
            vTopo.setUtilisateur(vUtilisateur);
            vTopo.setSpot(vSpotResource.getSpot(Integer.valueOf(req.getParameter("id_spot"))));
            vTopo.setDescription(req.getParameter("description"));
            if(req.getParameter("reservable") != null) {
                vTopo.setReservable(true);
            }
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            vTopo.setDate_creation(timestamp);

            //mise en bdd
            vTopoResource .newTopo(vTopo);
            //appel de l'objet crée
            vTopo = vTopoResource.getTopoByName(req.getParameter("nom"));
            id_topo = vTopo.getId();

            //renvoi à la vue
            req.setAttribute("topo", vTopo);

            //mise a null de l'objet et des parametres
            vTopo = null;
            req.removeAttribute("_nouveau_topo_");
            req.removeAttribute("nom");
            req.removeAttribute("id_spot");
            req.removeAttribute("description");
            req.removeAttribute("reservable");
        }

        //--CONSULTATION D'UN SPOT
        if(req.getParameter("idTopo") != null) {
            id_topo = 0;
            id_topo = Integer.valueOf(req.getParameter("idTopo"));
            vTopo = vTopoResource.getTopo(id_topo);

            req.setAttribute("topo", vTopo);
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/topo.jsp").forward(req, resp);
    }
}
