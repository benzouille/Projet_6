package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.exception.TechnicalException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération d'une difficulte ou de la liste complète des difficultes.
 *
 * @author Banane
 *
 */
public interface DifficulteManager {
    /**
     * Retourne la liste des Difficultes.
     *
     * @return Une liste de Difficulte.
     */
    List<Difficulte> getListDifficulte();

    /**
     * Retourne un objet Difficulte en particulier selon son 'id'.
     *
     * @param pId L'identifiant de la Difficulte
     * @return L'objet Difficulte correspondant à l'identifiant.
     * @throws TechnicalException  ne trouve pas la ressource demandée
     */
    Difficulte getDifficulteById(Integer pId) throws TechnicalException;

    /**
     * Retourne un objet Difficulte en particulier selon sa 'difficulte'.
     *
     * @param difficulte L'identifiant de la Difficulte
     * @return L'objet Difficulte correspondant à la difficulte.
     * @throws TechnicalException  ne trouve pas la ressource demandée
     */
    Difficulte getDifficulte(String difficulte) throws TechnicalException;
}
