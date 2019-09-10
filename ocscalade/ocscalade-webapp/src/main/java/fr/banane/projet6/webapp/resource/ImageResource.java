package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Image;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Classe permettant de manipuler un Objet Image depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class ImageResource extends AbstractResource {

    /**
     * Crée une Image
     * @param vImage objet à envoyer en bdd
     */
    public void newImage(Image vImage){
        getManagerFactory().getImageManager().newImage(vImage);
    }

    /**
     * Retourne un objet Image en particulier selon son 'id'.
     * @param pId L'identifiant de la Image
     * @return L'objet Image correspondant à l'identifiant.
     * @throws NotFoundException Retourne un Objet Difficulte selon son id
     */
    public Image getImage(Integer pId){
        return getManagerFactory().getImageManager().getImage(pId);
    }

    /**
     * Retourne la liste des Image.
     * @return Une liste de Image.
     */
    public List<Image> getListImage(){
        return getManagerFactory().getImageManager().getListImage();
    }

    /**
     * Retourne un objet Image en particulier selon son 'nom'.
     * @param name nom du Image
     * @return L'objet Image correspondant à son nom.
     * @throws NotFoundException Retourne un Objet Difficulte selon son id
     */
    public Image getImageByName(String name){
        return getManagerFactory().getImageManager().getImageByName(name);
    }

    /**
     * Retourne la liste des Image d'un secteur.
     * @return Une liste de Image.
     */
    public List<Image> getListImageByIdSpot(int id_spot){
        return getManagerFactory().getImageManager().getListImageByIdSpot(id_spot);
    }

    /**
     * Met à jour une Image.
     * @param vImage objet Image
     */
    public void updateSpot(Image vImage){
        getManagerFactory().getImageManager().updateImage(vImage);
    }

    /**
     * Supprime une Image
     * @param vImage objet Image
     */
    public void deleteImage(Image vImage){
        getManagerFactory().getImageManager().deleteImage(vImage);
    }

    /**
     * Supprime les objets Image selon l'id du spot
     * @param id_spot int
     */
    public void deleteAllByIdSpot(int id_spot){
        getManagerFactory().getImageManager().deleteAllByIdSpot(id_spot);
    }
}
