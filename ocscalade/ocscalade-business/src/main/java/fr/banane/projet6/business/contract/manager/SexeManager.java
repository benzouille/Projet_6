package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Sexe;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération d'un sexe ou de la liste complète des sexes.
 *
 * @author Banane
 *
 */
public interface SexeManager {
    /**
     * Retourne la liste des Sexe.
     *
     * @return Une liste de Sexe.
     */
    List<Sexe> getListSexe();

    /**
     * Retourne un objet Sexe en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Sexe
     * @return L'objet Sexe correspondant à l'identifiant.
     * @throws NotFoundException
     */
    Sexe getSexe(Integer pId) throws NotFoundException;

    /**
     * Retourne un objet Sexe en particulier selon son 'sexe'.
     *
     * @param sexe nom du Sexe
     * @return L'objet Sexe correspondant à son sexe.
     * @throws NotFoundException
     */
    Sexe getSexeBySexe(String sexe);
}

