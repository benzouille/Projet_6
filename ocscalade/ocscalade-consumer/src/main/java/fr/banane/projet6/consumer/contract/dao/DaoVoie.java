package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Voie;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Voie" / La table "voie"
 *
 * @author Banane
 */
public interface DaoVoie {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Voie obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Voie read(int id);
    Voie read(String code);
    List<Voie> readAll();
    List<Voie> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Voie obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Voie obj);

    /**
     * Méthode pour effacer
     * @param id_secteur
     * @return boolean
     */
    boolean deleteAll(int id_secteur);

    /**
     * Retourne le nombre de voie
     * @return Le nombre de voie
     */
    int getCountVoie();
}
