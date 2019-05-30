package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Commentaire;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Commentaire" / La table "commentaire"
 *
 * @author Banane
 *
 */
public interface DaoCommentaire {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Commentaire obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Commentaire read(int id);
    Commentaire read(String code);
    List<Commentaire> readAll();
    List<Commentaire> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Commentaire obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Commentaire obj);

    /**
     * Retourne le nombre de ticket
     * @return Le nombre de ticket
     */
    int getCountCommentaire();
}
