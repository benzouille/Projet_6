package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Topo;

import java.sql.Timestamp;
import java.util.List;


/**
 * Classe du module webapp proposant des méthodes de récupération, création, mise à jour et suppression d'un topo ou recuperation de la liste complète des topos.
 *
 * @author Banane
 *
 */
public class TopoResource extends AbstractResource {

    /**
     * Crée un topo.
     *
     * @param vTopo objet à envoyer en bdd
     */
    public void newTopo(Topo vTopo){
        getManagerFactory().getTopoManager().newTopo(vTopo);
    }

    /**
     * Retourne la liste des Topo.
     *
     * @return Une liste de Topo.
     */
    public List<Topo> getListTopo(){
        return getManagerFactory().getTopoManager().getListTopo();
    }

    /**
     * Retourne la liste des Topo crée par un utilisateur.
     *
     * @return Une liste de Topo.
     */
    public List<Topo> getListTopoByUser(int id_user){
        return getManagerFactory().getTopoManager().getListTopoByUser(id_user);
    }

    /**
     * Retourne la liste des Topo d'un département.
     *
     * @return Une liste de Topo.
     */
    public List<Topo> getListTopoByDepartement(int id_dep){
        return getManagerFactory().getTopoManager().getListTopoByDepartement(id_dep);
    }

    /**
     * Retourne la liste des Topo reservable.
     *
     * @return Une liste de Topo.
     */
    public List<Topo> getListTopoByReservable(){
        return getManagerFactory().getTopoManager().getListTopoByReservable();
    }

    /**
     * Retourne un objet Topo en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Topo
     * @return L'objet Topo correspondant à l'identifiant.
     */
    public Topo getTopo(Integer pId){
        return getManagerFactory().getTopoManager().getTopo(pId);
    }

    /**
     * Retourne un objet Topo en particulier selon son 'nom'.
     *
     * @param name nom du Topo
     * @return L'objet Topo correspondant à son nom.
     */
    public Topo getTopoByName(String name){
        return getManagerFactory().getTopoManager().getTopoByName(name);
    }

    /**
     * Retourne une list d'objet Topo selon une recherche multicritère
     * @param departement string id_departement
     * @param spot String id_spot
     * @param createur String id_utilisateur
     * @param date Timestamp
     * @param disponible boolean
     * @return vListTopoRecherche
     */
    public List<Topo> getListTopoByQuery(String departement, String spot, String createur, Timestamp date, boolean disponible) {
        return getManagerFactory().getTopoManager().getListTopoByQuery( departement, spot, createur, date, disponible);
    }

    /**
     * Met à jour un Topo.
     * @param vTopo objet Topo
     */
    public void updateTopo(Topo vTopo){
        getManagerFactory().getTopoManager().updateTopo(vTopo);
    }

    /**
     * Supprime un Topo
     * @param vTopo objet Topo
     */
    public void deleteTopo(Topo vTopo){
        getManagerFactory().getTopoManager().deleteTopo(vTopo);
    }
}
