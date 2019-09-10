package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Commentaire;
import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.model.exception.TechnicalException;

import java.util.List;

/**
 * Interface proposant des méthodes de récupération, création, mise à jour et suppression d'un commentaire ou recuperation de la liste complète de commentaire.
 *
 * @author Banane
 *
 */
public interface CommentaireManager {

    /**
     * Crée une Commentaire
     * @param vCommentaire objet à envoyer en bdd
     *
     */
    void newCommentaire(Commentaire vCommentaire) throws TechnicalException;

    /**
     * Retourne un objet Commentaire en particulier selon son 'id'.
     *
     * @param pId L'identifiant de la Commentaire
     * @return L'objet Commentaire correspondant à l'identifiant.
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    Commentaire getCommentaire(Integer pId) throws TechnicalException;

    /**
     * Retourne la liste des Commentaire.
     *
     * @return Une liste de Commentaire.
     */
    List<Commentaire> getListCommentaire() throws TechnicalException;

    /**
     * Retourne Une liste de Commentaire selon son 'utilisateur'.
     *
     * @param id_utilisateur id de l'utilisateur
     * @return Une liste de Commentaire correspondant à l'utilisateur.
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    List<Commentaire> getCommentaireByUser(int id_utilisateur) throws TechnicalException;

    /**
     * Retourne la liste des Commentaire d'un spot.
     *
     * @param id_spot id du spot lié
     * @return Une liste de Commentaire.
     */
    List<Commentaire> getListCommentaireByIdSpot(int id_spot);

    /**
     * Met à jour un Commentaire.
     * @param vCommentaire
     */
    void updateCommentaire(Commentaire vCommentaire);

    /**
     * Supprime un Commentaire
     * @param vCommentaire
     */
    void deleteCommentaire(Commentaire vCommentaire);

    /**
     * Supprime les objets Commentaire selon l'id du spot
     * @param id_spot
     */
    void deleteAllByIdSpot(int id_spot);
}