package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Secteur;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Secteur" / La table "secteur"
 *
 * @author Banane
 */
public interface DaoSecteur {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Secteur obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Secteur read(int id);
    Secteur read(String code);
    List<Secteur> readAll();
    List<Secteur> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Secteur obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Secteur obj);

    /**
     * Méthode pour effacer
     * @param id_spot
     * @return boolean
     */
    boolean deleteAll(int id_spot);

    /**
     * Retourne le nombre de secteur
     * @return Le nombre de secteur
     */
    int getCountSecteur();
}