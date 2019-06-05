package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Longueur;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Longueur" / La table "longueur"
 *
 * @author Banane
 */
public interface DaoLongueur {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Longueur obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Longueur read(int id);
    Longueur read(String code);
    List<Longueur> readAll();
    List<Longueur> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Longueur obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Longueur obj);

    /**
     * Méthode pour effacer
     * @param id_voie
     * @return boolean
     */
    boolean deleteAll(int id_voie);

    /**
     * Retourne le nombre de Longueur
     * @return Le nombre de Longueur
     */
    int getCountLongueur();
}
