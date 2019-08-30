package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Reservation;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.ReservationResource;
import fr.banane.projet6.webapp.resource.SpotResource;
import fr.banane.projet6.webapp.resource.TopoResource;
import fr.banane.projet6.webapp.technical.FormatDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TopoServlet extends HttpServlet {

    private int id_topo;
    private Topo vTopo;
    private TopoResource vTopoResource = new TopoResource();

    private SpotResource vSpotResource = new SpotResource();
    private List<Spot> vListSpots;

    private Reservation vReservation;
    private ReservationResource vReservationResource = new ReservationResource();
    private List<Reservation> vListReservations = new ArrayList<>();

    private FormatDate formatDate = new FormatDate();

    Utilisateur vUtilisateur;

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

        //--NOUVEAU TOPO
        if(req.getParameter("_nouveau_topo_") != null) {
            System.out.println("je passe par NOUVEAU TOPO de TopoServlet");

            vTopo = new Topo();
            vTopo.setNom(req.getParameter("nom"));
            vTopo.setUtilisateur(vUtilisateur);
            vTopo.setSpot(vSpotResource.getSpotByName(String.valueOf(req.getParameter("spot"))));
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

            //mise a null de l'objet et des parametres
            vTopo = null;
            req.removeAttribute("_nouveau_topo_");
            req.removeAttribute("nom");
            req.removeAttribute("id_spot");
            req.removeAttribute("description");
            req.removeAttribute("reservable");
        }

        //--RESERVATION D'UN SPOT
        if(req.getParameter("_reserver_") != null) {

            vReservation = new Reservation();
            vReservation.setLocataire((Utilisateur)req.getSession().getAttribute("utilisateur"));
            vReservation.setTopo(vTopoResource.getTopo(id_topo));
            vReservation.setDate_debut(formatDate.stringToTimestamp(req.getParameter("date_debut")));
            vReservation.setDate_fin(formatDate.stringToTimestamp(req.getParameter("date_fin")));
            vReservation.setMessage(req.getParameter("message"));
            vReservation.setTraite(false);

            //mise en bdd
            vReservationResource.newReservation(vReservation);

            //mise a null de l'objet et des parametres

            req.removeAttribute("_reserver_");
            req.removeAttribute("date_debut");
            req.removeAttribute("date_fin");
            req.removeAttribute("message");
            req.removeAttribute("reservable");
        }

        //--CONSULTATION D'UN TOPO
        if(req.getParameter("idTopo") != null) {
            id_topo = 0;
            id_topo = Integer.valueOf(req.getParameter("idTopo"));
        }

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/topo.jsp").forward(req, resp);
    }

    private void intiPage(HttpServletRequest req) {
        vUtilisateur = (Utilisateur) req.getSession().getAttribute("utilisateur");

        List<Reservation> vListReservationsFull = vReservationResource.getListReservationByTopo(id_topo);
        for (Reservation reservation : vListReservationsFull) {
            if (reservation.isAccepte()) {
                vListReservations.add(reservation);
            }
        }

        vTopo = vTopoResource.getTopo(id_topo);

        //renvoi à la vue
        req.setAttribute("topo", vTopo);
        req.setAttribute("vListReservations", vListReservations);
    }
}
