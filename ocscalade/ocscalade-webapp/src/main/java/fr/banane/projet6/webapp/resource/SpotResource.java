package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.exception.TechnicalException;

import java.util.List;

/**
 * Classe permettant de manipuler un Objet Spot depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class SpotResource extends AbstractResource {

    /**
     * Envoie un objet Secteur au module business
     * @param spot objet spot
     */
    public void newSpot (Spot spot) {
        getManagerFactory().getSpotManager().newSpot(spot);
    }

    /**
     * Retourne une Liste d'objet Spot
     * @return List d'objet Spot
     */
    public List<Spot> getListSpot() {
        return getManagerFactory().getSpotManager().getListSpot();
    }

    /**
     * Retourne une Liste d'objet Spot pour la servlet index
     * @return List d'objet Spot
     */
    public List<Spot> getListSpotForIndex() {return getManagerFactory().getSpotManager().getListSpotForIndex();}

    /**
     * Retourne un objet Spot selon son id
     * @param pId int
     * @return objet Spot
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    public Spot getSpot(Integer pId) throws TechnicalException {
        return getManagerFactory().getSpotManager().getSpot(pId);
    }

    /**
     * Retourne un objet Spot selon son nom
     * @param name string
     * @return objet Spot
     */
    public Spot getSpotByName(String name) {
        return getManagerFactory().getSpotManager().getSpotByName(name);
    }

    /**
     * Met à jour un objet Spot
     * @param spot objet Spot
     */
    public void updateSpot (Spot spot) {getManagerFactory().getSpotManager().updateSpot(spot);}

    /**
     * Retour une liste d'objet Spot en fonction des critères envoyé en parametre
     * @param departement String id_departement
     * @param difficulte String id_difficulte
     * @param nbreSecteur int
     * @param equipement boolean
     * @param officiel boolean
     * @return List d'objet Spot
     */
    public List<Spot> getListSpotByQuery(String departement, String difficulte, String nbreSecteur, boolean equipement, boolean officiel) {
        return getManagerFactory().getSpotManager().getListSpotByQuery(departement, difficulte, nbreSecteur, equipement, officiel);
    }
}
