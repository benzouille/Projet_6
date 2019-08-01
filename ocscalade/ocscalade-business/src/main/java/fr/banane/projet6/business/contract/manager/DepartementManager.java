package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération d'un departement ou de la liste complète des departements.
 *
 * @author Banane
 *
 */
public interface DepartementManager {

    /**
     * Retourne la liste des Departements.
     *
     * @return Une liste de Departements.
     */
    List<Departement> getListDepartement();

    /**
     * Retourne un objet Departement en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Departement
     * @return L'objet Departement correspondant à l'identifiant.
     * @throws NotFoundException
     */
    Departement getDepartement(Integer pId);

    /**
     * Retourne un objet Departement en particulier selon son 'num'.
     *
     * @param num numéro du Departement
     * @return L'objet Departement correspondant à son numéro.
     * @throws NotFoundException
     */
    Departement getDepartementByNum(String num);
}