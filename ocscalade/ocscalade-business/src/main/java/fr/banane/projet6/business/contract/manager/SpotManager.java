package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération, création, mise à jour et suppression d'un spot ou recuperation de la liste complète des spots.
 *
 * @author Banane
 *
 */
public interface SpotManager {

    /**
     * Crée un spot.
     *
     * @param vSpot objet à envoyer en bdd
     */
    void newSpot(Spot vSpot);
    //TODO ajouter les exceptions NotFoundException et DuplicateException

    /**
     * Retourne la liste des Spot.
     *
     * @return Une liste de Spot.
     */
    List<Spot> getListSpot();

    /**
     * Retourne la liste des Spot crée par un utilisateur.
     *
     * @return Une liste de Spot.
     */
    List<Spot> getListSpotByUser(int id_user);

    /**
     * Retourne la liste des Spot d'un département.
     *
     * @return Une liste de Spot.
     */
    List<Spot> getListSpotByDepartement(int id_dep);

    /**
     * Retourne la liste des Spot officiel.
     *
     * @return Une liste de Spot.
     */
    List<Spot> getListSpotByOfficiel();

    /**
     * Retourne un objet Spot en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Spot
     * @return L'objet Spot correspondant à l'identifiant.
     * @throws NotFoundException
     */
    Spot getSpot(Integer pId);

    /**
     * Retourne un objet Spot en particulier selon son 'nom'.
     *
     * @param name nom du Spot
     * @return L'objet Spot correspondant à son nom.
     * @throws NotFoundException
     */
    Spot getSpotByName(String name);

    /**
     * Met à jour un spot.
     * @param vSpot
     */
    public void updateSpot(Spot vSpot);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Supprime un spot
     * @param vSpot
     */
    public void deleteSpot(Spot vSpot);
    //TODO ajouter le throws pour l'exceptions NotFoundException

}
