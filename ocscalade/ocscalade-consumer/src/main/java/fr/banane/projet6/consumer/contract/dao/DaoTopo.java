package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Topo;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Topo" / La table "topo"
 *
 * @author Banane
 */
public interface DaoTopo {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    boolean create(Topo obj);

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    Topo read(int id);
    Topo read(String code);
    List<Topo> readAll();
    List<Topo> readAll(int id);

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    boolean update(Topo obj);

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    boolean delete(Topo obj);
    boolean deleteAll(int id_utilisateur);

    /**
     * Retourne le nombre de topo
     * @return Le nombre de topo
     */
    int getCountTopo();
}
