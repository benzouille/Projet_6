package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Topo;

import java.sql.Timestamp;
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
    Topo read(String name);
    List<Topo> readAll();
    List<Topo> readAllByCreateur(int id_utilisateur);
    List<Topo> readAllByDepartementSpot(int id_dep);
    List<Topo> readAllByReservable();

    /**
     * Methode de recherche par criteres multiples
     * @param departement
     * @param spot
     * @param createur
     * @param date
     * @param disponible
     * @return vListTopoRecherche
     */
    List<Topo> getListTopoByQuery(String departement, String spot, String createur, Timestamp date, boolean disponible);

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
