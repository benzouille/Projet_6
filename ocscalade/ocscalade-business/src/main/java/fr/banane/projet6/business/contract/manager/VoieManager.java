package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Voie;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération, création, mise à jour et suppression d'une voie ou recuperation de la liste complète de voie.
 *
 * @author Banane
 *
 */
public interface VoieManager {

    /**
     * Crée une voie
     * @param vVoie objet à envoyer en bdd
     *
     */
    void newVoie(Voie vVoie);

    /**
     * Retourne un objet Voie en particulier selon son 'id'.
     *
     * @param pId L'identifiant de la Voie
     * @return L'objet Voie correspondant à l'identifiant.
     * @throws NotFoundException
     */
    Voie getVoie(Integer pId);

    /**
     * Retourne la liste des Voie.
     *
     * @return Une liste de Voie.
     */
    List<Voie> getListVoie();

    /**
     * Retourne un objet Voie en particulier selon son 'nom'.
     *
     * @param name nom du Voie
     * @return L'objet Voie correspondant à son nom.
     * @throws NotFoundException
     */
    Voie getVoieByName(String name);

    /**
     * Retourne la liste des Voie d'un secteur.
     *
     * @return Une liste de Voie.
     */
    List<Voie> getListVoieByIdSecteur(int id_secteur);

    /**
     * Met à jour un Voie.
     * @param vVoie
     */
    void updateSpot(Voie vVoie);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Supprime une Voie
     * @param vVoie
     */
    void deleteVoie(Voie vVoie);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Supprime les objets Voie selon l'id du secteur
     * @param id_secteur
     */
    void deleteAllByIdSecteur(int id_secteur);

    int getCountVoie();
}

