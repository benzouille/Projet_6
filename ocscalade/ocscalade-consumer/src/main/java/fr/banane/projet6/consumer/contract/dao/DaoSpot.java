package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Spot;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Spot" / La table "spot"
 *
 * @author Banane
 */
public interface DaoSpot {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Spot obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Spot read(int id);
    Spot read(String code);
    List<Spot> readAll();
    List<Spot> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Spot obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Spot obj);

    /**
     * Retourne le nombre de spot
     * @return Le nombre de spot
     */
    int getCountSpot();
}
