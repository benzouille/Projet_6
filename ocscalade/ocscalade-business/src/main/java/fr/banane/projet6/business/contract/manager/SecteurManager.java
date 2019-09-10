package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Secteur;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération, création, mise à jour et suppression d'un secteur ou recuperation de la liste complète de secteur.
 *
 * @author Banane
 *
 */
public interface SecteurManager {
    /**
     * Crée un Secteur.
     *
     * @param vSecteur objet à envoyer en bdd
     */
    void newSecteur(Secteur vSecteur);

    /**
     * Retourne la liste des Secteur.
     *
     * @return Une liste de Secteur.
     */
    List<Secteur> getListSecteur();

    /**
     * Retourne la liste des Secteur d'un spot.
     *
     * @return Une liste de Secteur.
     */
    List<Secteur> getListSecteurByIdSpot(int id_spot);

    /**
     * Retourne un objet Secteur en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Secteur
     * @return L'objet Secteur correspondant à l'identifiant.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Secteur getSecteur(Integer pId);

    /**
     * Retourne un objet Secteur en particulier selon son 'nom'.
     *
     * @param name nom du Secteur
     * @return L'objet Secteur correspondant à son nom.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Secteur getSecteurByName(String name);

    /**
     * Met à jour un Secteur.
     * @param vSecteur objet Secteur
     */
    void updateSecteur(Secteur vSecteur);

    /**
     * Supprime un Secteur
     * @param vSecteur objet Secteur
     */
    void deleteSecteur(Secteur vSecteur);

}
