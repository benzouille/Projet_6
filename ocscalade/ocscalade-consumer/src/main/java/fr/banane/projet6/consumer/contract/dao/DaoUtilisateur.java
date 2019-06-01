package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.User;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "User" / La table "user"
 *
 * @author Banane
 */
public interface DaoUtilisateur {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(User obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    User read(int id);
    User read(String code);
    List<User> readAll();
    List<User> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(User obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(User obj);

    /**
     * Retourne le nombre de user
     * @return Le nombre de user
     */
    int getCountUser();
}
