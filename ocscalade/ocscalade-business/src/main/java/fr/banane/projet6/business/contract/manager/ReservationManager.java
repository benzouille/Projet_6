package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Reservation;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération, création, mise à jour et suppression d'une reservation ou recuperation de la liste complète des reservations.
 *
 * @author Banane
 *
 */
public interface ReservationManager {

    /**
     * Crée une Reservation.
     *
     * @param vReservation objet à envoyer en bdd
     */
    void newReservation(Reservation vReservation);
    //TODO ajouter les exceptions NotFoundException et DuplicateException

    /**
     * Retourne un objet Reservation en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Reservation
     * @return L'objet Reservation correspondant à l'identifiant.
     * @throws NotFoundException
     */
    Reservation getReservation(Integer pId);

    /**
     * Retourne la liste des Reservations.
     *
     * @return Une liste de Reservation.
     */
    List<Reservation> getListReservation();

    /**
     * Retourne la liste des Reservation crée par un utilisateur.
     *
     * @return Une liste de Reservation.
     */
    List<Reservation> getListReservationByLocataire(int id_locataire);


    /**
     * Retourne la liste des Reservation selon le proprietaire des topos de la liste de reservation.
     *
     * @return Une liste de Reservation.
     */
    List<Reservation> getListReservationByProprietaireTopo(int id_proprietaire);

    /**
     * Retourne la liste des Reservation d'un département.
     *
     * @return Une liste de Reservation.
     */
    List<Reservation> getListReservationByTopo(int id_topo);

    /**
     * Met à jour une Reservation.
     * @param vReservation
     */
    void updateReservation(Reservation vReservation);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Supprime une Reservation
     * @param vReservation
     */
    void deleteReservation(Reservation vReservation);
    //TODO ajouter le throws pour l'exceptions NotFoundException
}
