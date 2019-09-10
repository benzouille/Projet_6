package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Classe permettant de manipuler un Objet Departement depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class DepartementResource extends AbstractResource {

    /**
     * Retourne une liste d'objet departement
     * @return List departement
     */
    public List<Departement> getListDepartement() {
        return getManagerFactory().getDepartementManager().getListDepartement();
    }

    /**
     * Retourne un Objet Departement selon son id
     * @param pId int
     * @return objet Departement
     */
    public Departement getDepartement(Integer pId) {
        return getManagerFactory().getDepartementManager().getDepartement(pId);
    }

    /**
     * Retourne un Objet Departement selon son numero
     * @param num String numéro de département
     * @return objet Departement
     */
    public Departement getDepartementByNum(String num) {
        return getManagerFactory().getDepartementManager().getDepartementByNum(num);
    }
}
