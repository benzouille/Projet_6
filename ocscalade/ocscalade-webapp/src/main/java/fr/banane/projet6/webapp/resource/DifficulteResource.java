package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.model.exception.TechnicalException;

import java.util.List;

/**
 * Classe permettant de manipuler un Objet Departement depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class DifficulteResource extends AbstractResource {

    /**
     * Retourne une liste d'objet Difficulte
     * @return List Difficulte
     */
    public List<Difficulte> getListDifficulte() {
        return getManagerFactory().getDifficulteManager().getListDifficulte();
    }

    /**
     * Retourne un Objet Difficulte selon son id
     * @param pId int
     * @return objet Difficulte
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    public Difficulte getDifficulteById(Integer pId) throws TechnicalException {
        return getManagerFactory().getDifficulteManager().getDifficulteById(pId);
    }

    /**
     * Retourne un Objet Difficulte selon son nom de difficulte
     * @param difficulte String difficulte
     * @return objet Difficulte
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    public Difficulte getDifficulte(String difficulte) throws TechnicalException {
        return getManagerFactory().getDifficulteManager().getDifficulte(difficulte);
    }
}
