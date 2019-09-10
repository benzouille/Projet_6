package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.model.exception.TechnicalException;

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

    /**
     * Retourne la liste des Spot.
     *
     * @return Une liste de Spot.
     */
    List<Spot> getListSpot();

    /**
     * Retourne une liste des 8 derniers Spots.
     *
     * @return Une liste de Spot.
     */
    List<Spot> getListSpotForIndex();

    /**
     * Retourne une liste de spot en fonction des critères entrés
     * @param departement le departement
     * @param difficulte la difficulte
     * @param nbreSecteur le nombre de secteurs
     * @param equipement si équipé
     * @param officiel si officiel
     * @return une liste de Spot
     */
    List<Spot> getListSpotByQuery(String departement, String difficulte, String nbreSecteur, boolean equipement, boolean officiel);

    /**
     * Retourne un objet Spot en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Spot
     * @return L'objet Spot correspondant à l'identifiant.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Spot getSpot(Integer pId) throws TechnicalException;

    /**
     * Retourne un objet Spot en particulier selon son 'nom'.
     *
     * @param name nom du Spot
     * @return L'objet Spot correspondant à son nom.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Spot getSpotByName(String name);

    /**
     * Met à jour un spot.
     * @param vSpot objet spot
     */
    void updateSpot(Spot vSpot);

    /**
     * Supprime un spot
     * @param vSpot objet spot
     */
    void deleteSpot(Spot vSpot);

}
