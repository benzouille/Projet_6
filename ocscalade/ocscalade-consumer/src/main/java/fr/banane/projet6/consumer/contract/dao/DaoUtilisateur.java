package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.TechnicalException;

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
     * @param obj Utilisateur
     * @return boolean
     */
    boolean create(Utilisateur obj);

    /**
     * Méthode de recherche des informations
     * @param id int
     * @return T
     */
    Utilisateur read(int id) throws TechnicalException;
    Utilisateur read(String pseudo) throws TechnicalException;
    List<Utilisateur> readAll();
    List<Utilisateur> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj Utilisateur
     * @return boolean
     */
    boolean update(Utilisateur obj);

    /**
     * Méthode pour effacer
     * @param obj Utilisateur
     * @return boolean
     */
    boolean delete(Utilisateur obj);

    /**
     * Retourne le nombre de utilisateur
     * @return Le nombre de utilisateur
     */
    int getCountUtilisateur();
}
