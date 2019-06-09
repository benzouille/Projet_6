package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération d'une departement ou de la liste complète des departement.
 *
 * @author Banane
 *
 */
public interface DepartementManager {

    /**
     * Retourne la liste des Departement.
     *
     * @return Une liste de Departement.
     */
    public List<Departement> getListDepartement();

    /**
     * Retourne un objet Departement en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Departement
     * @return L'objet Departement correspondant à l'identifiant.
     * @throws NotFoundException
     */
    public Departement getDepartement(Integer pId) throws NotFoundException;

    /**
     * Retourne un objet Departement en particulier selon son 'num'.
     *
     * @param num numéro du Departement
     * @return L'objet Departement correspondant à son numéro.
     * @throws NotFoundException
     */
    public Departement getDepartementByNum(Integer num);
}