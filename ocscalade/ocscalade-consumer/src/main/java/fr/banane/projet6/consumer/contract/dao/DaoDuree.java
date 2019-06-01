package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Duree;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Duree" / La table "duree"
 * 
 * @author Banane
 */
public interface DaoDuree {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Duree obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Duree read(int id);
    Duree read(String code);
    List<Duree> readAll();
    List<Duree> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Duree obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Duree obj);

    /**
     * Retourne le nombre de Duree
     * @return Le nombre de Duree
     */
    int getCountDuree();
}
