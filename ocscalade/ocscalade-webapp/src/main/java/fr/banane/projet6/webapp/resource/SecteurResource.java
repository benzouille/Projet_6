package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Secteur;

import java.util.List;

/**
 * Classe permettant de manipuler un Objet Secteur depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class SecteurResource extends AbstractResource {

    /**
     * Envoie un objet Secteur au module business
     * @param vSecteur objet Secteur
     */
    public void newSecteur(Secteur vSecteur){
        getManagerFactory().getSecteurManager().newSecteur(vSecteur);
    }

    /**
     * Retourne un Objet Secteur selon son id
     * @param id_secteur int
     * @return un objet Secteur
     */
    public Secteur getSecteur(int id_secteur){
        return getManagerFactory().getSecteurManager().getSecteur(id_secteur);
    }

    /**
     * Retourne un Objet Secteur selon son nom
     * @param name String nom
     * @return un objet Secteur
     */
    public Secteur getSecteurByName(String name){
        return getManagerFactory().getSecteurManager().getSecteurByName(name);
    }

    /**
     * Retourne une Liste d'objet Secteur selon leurs id_spot
     * @param id_spot int
     * @return une List d'objet Secteur
     */
    public List<Secteur> getSecteurByIdSpot(int id_spot) {
        return getManagerFactory().getSecteurManager().getListSecteurByIdSpot(id_spot);
    }
}
