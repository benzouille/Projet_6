package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Image;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération, création, mise à jour et suppression d'une Image ou recuperation de la liste complète d'une Image.
 *
 * @author Banane
 *
 */
public interface ImageManager {
    /**
     * Crée une Image
     * @param vImage objet à envoyer en bdd
     *
     */
    void newImage(Image vImage);

    /**
     * Retourne un objet Image en particulier selon son 'id'.
     *
     * @param pId L'identifiant de la Image
     * @return L'objet Image correspondant à l'identifiant.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Image getImage(Integer pId);

    /**
     * Retourne la liste des Image.
     *
     * @return Une liste de Image.
     */
    List<Image> getListImage();

    /**
     * Retourne un objet Image en particulier selon son 'nom'.
     *
     * @param name nom du Image
     * @return L'objet Image correspondant à son nom.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    Image getImageByName(String name);

    /**
     * Retourne la liste des Image d'un secteur.
     *
     * @return Une liste de Image.
     */
    List<Image> getListImageByIdSpot(int id_spot);

    /**
     * Met à jour un Image.
     * @param vImage objet Image
     */
    void updateImage(Image vImage);

    /**
     * Supprime une Image
     * @param vImage objet Image
     */
    void deleteImage(Image vImage);

    /**
     * Supprime les objets Image selon l'id du secteur
     * @param id_spot objet Image
     */
    void deleteAllByIdSpot(int id_spot);
}
