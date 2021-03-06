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
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Servlet de la jsp mes_topos permettant de gérer ses topos, les demande de reservation et les topos qui sont pretés à l'utilisateur.
 */
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

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/mes_topos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //--DISPONIBILITE D'UN TOPO
        if(req.getParameter("_topo_dispo_") != null) {

            //appel à la bdd
            vTopo = vTopoResource.getTopo(Integer.parseInt(req.getParameter("idTopo")));

            if (req.getParameter("topo_dispo") != null){
                vTopo.setReservable(true);
            }
            else{
                vTopo.setReservable(false);
            }

            vTopoResource.updateTopo(vTopo);

            //mise a null de l'objet et des parametres
            vTopo = null;
            req.removeAttribute("_topo_dispo_");
            req.removeAttribute("idTopo");
            req.removeAttribute("topo_dispo");
        }

        //--ACCEPTER RESERVATION
        if(req.getParameter("_accepte_") != null) {

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

            //mise a null de l'objet et des parametres
            vReservation = null;
            req.removeAttribute("_accepte_");
            req.removeAttribute("id_reservation_accepte");
            req.removeAttribute("id_reservation_refus");
        }

        initPage(req);

        this.getServletContext().getRequestDispatcher("/WEB-INF/gestion_spot_topo/mes_topos.jsp").forward(req, resp);
    }

    /**
     * Initialisation de la servlet et transmission des données à la jsp
     * @param req la requete
     */
    private void initPage(HttpServletRequest req){
        Utilisateur utilisateur = (Utilisateur)req.getSession().getAttribute("utilisateur");

        vListTopos = vTopoResource.getListTopoByUser(utilisateur.getId());
        req.setAttribute("vListMesTopos", vListTopos);

        vListDemandeReservations = vReservationResource.getListReservationByProprietaireTopo(utilisateur.getId());
        req.setAttribute("vListDemandeReservations", vListDemandeReservations);

        vListPrete = new ArrayList<>();
        List<Reservation> vListPreteFull = vReservationResource.getListReservationByLocataire(utilisateur.getId());
        for(Reservation reservation : vListPreteFull){
            if(reservation.isAccepte()){
                vListPrete.add(reservation);
            }
        }
        req.setAttribute("vListPrete", vListPrete);
    }
}
