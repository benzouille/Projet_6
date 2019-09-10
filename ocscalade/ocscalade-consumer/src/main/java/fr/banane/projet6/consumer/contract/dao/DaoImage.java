package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Image;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Image" / La table "image"
 *
 * @author Banane
 */
public interface DaoImage {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Image obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Image read(int id);
    Image read(String code);
    List<Image> readAll();
    List<Image> readAllByIdSpot(int id_spot);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Image obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Image obj);
    boolean deleteAll(int id_spot);

    /**
     * Retourne le nombre d'image
     * @return Le nombre d'image
     */
    int getCountImage();
}