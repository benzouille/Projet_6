package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Reservation;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Reservation" / La table "reservation"
 *
 * @author Banane
 */
public interface DaoReservation {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Reservation obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Reservation read(int id);
    Reservation read(String code);
    List<Reservation> readAll();
    List<Reservation> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Reservation obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Reservation obj);

    /**
     * Retourne le nombre de reservation
     * @return Le nombre de reservation
     */
    int getCountReservation();
}
