package fr.banane.projet6.webapp.servlets.gestion_spot_topo;

import fr.banane.projet6.model.bean.Reservation;
import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.webapp.resource.ReservationResource;
import fr.banane.projet6.webapp.resource.TopoResource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MesToposServlet extends HttpServlet {

    private Topo vTopo;
    private List<Topo> vListTopos;
    private TopoResource vTopoResource = new TopoResource();

    private Reservation vReservation;
    private List<Reservation> vListDemandeReservations, vListPrete;
    private ReservationResource vReservationResource = new ReservationResource();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/mes_topos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //--DISPONIBILITE D'UN TOPO
        if(req.getParameter("_disponible_") != null) {
            System.out.println("je passe par DISPONIBILITE D'UN TOPO");
            //TODO virer le null
            req.setAttribute("vListTopos", null);
        }

        //--ACCEPTER RESERVATION
        if(req.getParameter("_accepte_") != null) {
            //System.out.println("je passe par ACCEPTER RESERVATION. Bouton " + req.getParameter("_accepte_"));

            if(req.getParameter("id_reservation_accepte") != null){
                vReservation = vReservationResource.getReservation(Integer.valueOf(req.getParameter("id_reservation_accepte")));
                vReservation.setAccepte(true);

            }

            if(req.getParameter("id_reservation_refus") != null){
                vReservation = vReservationResource.getReservation(Integer.valueOf(req.getParameter("id_reservation_refus")));
                vReservation.setAccepte(false);

            }

            vReservation.setTraite(true);
            vReservationResource.updateReservation(vReservation);

        }

        intiPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/mes_topos.jsp").forward(req, resp);
    }


    private void intiPage(HttpServletRequest req){
        Utilisateur utilisateur = (Utilisateur)req.getSession().getAttribute("utilisateur");

        vListTopos = vTopoResource.getListTopoByUser(utilisateur.getId());
        req.setAttribute("vListMesTopos", vListTopos);

        vListDemandeReservations = vReservationResource.getListReservationByProprietaireTopo(utilisateur.getId());
        req.setAttribute("vListDemandeReservations", vListDemandeReservations);

        vListPrete = vReservationResource.getListReservationByLocataire(utilisateur.getId());
        req.setAttribute("vListPrete", vListPrete);
    }
}
