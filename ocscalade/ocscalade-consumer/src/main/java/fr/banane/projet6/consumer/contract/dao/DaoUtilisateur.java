package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Utilisateur;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Utilisateur" / La table "utilisateur"
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
    boolean create(Utilisateur obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Utilisateur read(int id);
    Utilisateur read(String pseudo);
    List<Utilisateur> readAll();
    List<Utilisateur> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Utilisateur obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Utilisateur obj);

    /**
     * Retourne le nombre de utilisateur
     * @return Le nombre de utilisateur
     */
    int getCountUtilisateur();
}
