package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.model.exception.NotFoundException;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface proposant des méthodes de récupération, création, mise à jour et suppression d'un topo ou recuperation de la liste complète des topos.
 *
 * @author Banane
 *
 */
public interface TopoManager {

    /**
     * Crée un topo.
     *
     * @param vTopo objet à envoyer en bdd
     */
    void newTopo(Topo vTopo);

    /**
     * Retourne la liste des Topo.
     *
     * @return Une liste de Topo.
     */
    List<Topo> getListTopo();

    /**
     * Retourne la liste des Topo crée par un utilisateur.
     *
     * @return Une liste de Topo.
     */
    List<Topo> getListTopoByUser(int id_user);

    /**
     * Retourne la liste des Topo d'un département.
     *
     * @return Une liste de Topo.
     */
    List<Topo> getListTopoByDepartement(int id_dep);

    /**
     * Retourne la liste des Topo reservable.
     *
     * @return Une liste de Topo.
     */
    List<Topo> getListTopoByReservable();

    /**
     * Retourne un objet Topo en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Topo
     * @return L'objet Topo correspondant à l'identifiant.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Topo getTopo(Integer pId);

    /**
     * Retourne un objet Topo en particulier selon son 'nom'.
     *
     * @param name nom du Topo
     * @return L'objet Topo correspondant à son nom.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Topo getTopoByName(String name);

    /**
     * Retourne une liste d'objet Topo en fonction de multiple critere
     * @param departement String id_departement
     * @param spot String id_spot
     * @param createur String id_utilisateur
     * @param date Timestamp date
     * @param disponible boolean
     * @return vListTopoRecherche
     */
    List<Topo> getListTopoByQuery(String departement, String spot, String createur, Timestamp date, boolean disponible);

    /**
     * Met à jour un Topo.
     * @param vTopo objet topo
     */
    void updateTopo(Topo vTopo);

    /**
     * Supprime un Topo
     * @param vTopo objet Topo
     */
    void deleteTopo(Topo vTopo);

}
