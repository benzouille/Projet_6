package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Sexe;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Classe permettant de manipuler un Objet Commentaire depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class SexeResource extends AbstractResource {

    /**
     * Retourne une Liste d'objet Sexe
     * @return List d'objet Sexe
     */
    public List<Sexe> getListSexe() {
        return getManagerFactory().getSexeManager().getListSexe();
    }

    /**
     * Retourne un objer Sexe selon son id
     * @param pId int
     * @return objet Sexe
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    public Sexe getSexe(Integer pId) throws NotFoundException {
        return getManagerFactory().getSexeManager().getSexe(pId);
    }

    /**
     * Retourne un objer Sexe selon son nom
     * @param sexe String
     * @return objet Sexe
     */
    public Sexe getSexeBySexe(String sexe) {
        return getManagerFactory().getSexeManager().getSexeBySexe(sexe);
    }
}
