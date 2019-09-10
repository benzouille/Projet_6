package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Reservation;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Classe du module webapp proposant des méthodes de récupération, création, mise à jour et suppression d'une reservation ou recuperation de la liste complète de reservations.
 *
 * @author Banane
 *
 */
public class ReservationResource extends AbstractResource {

    /**
     * Crée une Reservation.
     * @param vReservation objet à envoyer en bdd
     */
    public void newReservation(Reservation vReservation){
        getManagerFactory().getReservationManager().newReservation(vReservation);
    }

    /**
     * Retourne un objet Reservation en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Reservation
     * @return L'objet Reservation correspondant à l'identifiant.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    public Reservation getReservation(Integer pId){
        return getManagerFactory().getReservationManager().getReservation(pId);
    }

    /**
     * Retourne la liste des Reservations.
     * @return Une liste de Reservation.
     */
    public List<Reservation> getListReservation(){
        return getManagerFactory().getReservationManager().getListReservation();
    }

    /**
     * Retourne la liste des Reservation crée par un utilisateur.
     * @return Une liste de Reservation.
     */
    public List<Reservation> getListReservationByLocataire(int id_locataire){
        return getManagerFactory().getReservationManager().getListReservationByLocataire(id_locataire);
    }

    /**
     * Retourne la liste des Reservation d'un topo.
     * @return Une liste de Reservation.
     */
    public List<Reservation> getListReservationByTopo(int id_topo){
        return getManagerFactory().getReservationManager().getListReservationByTopo(id_topo);
    }

    /**
     * Retourne la liste des Reservation selon le proprietaire du ou des topo réservé.
     * @return Une liste de Reservation.
     */
    public List<Reservation> getListReservationByProprietaireTopo(int id_proprietaire){
        return getManagerFactory().getReservationManager().getListReservationByProprietaireTopo(id_proprietaire);
    }

    /**
     * Met à jour une Reservation.
     * @param vReservation objet Reservation
     */
    public void updateReservation(Reservation vReservation){
        getManagerFactory().getReservationManager().updateReservation(vReservation);
    }

    /**
     * Supprime une Reservation
     * @param vReservation objet Reservation
     */
    public void deleteReservation(Reservation vReservation){
        getManagerFactory().getReservationManager().deleteReservation(vReservation);
    }
}
