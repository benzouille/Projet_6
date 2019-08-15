package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Commentaire;
import fr.banane.projet6.model.exception.NotFoundException;

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
    void newCommentaire(Commentaire vCommentaire);

    /**
     * Retourne un objet Commentaire en particulier selon son 'id'.
     *
     * @param pId L'identifiant de la Commentaire
     * @return L'objet Commentaire correspondant à l'identifiant.
     * @throws NotFoundException
     */
    Commentaire getCommentaire(Integer pId);

    /**
     * Retourne la liste des Commentaire.
     *
     * @return Une liste de Commentaire.
     */
    List<Commentaire> getListCommentaire();

    /**
     * Retourne Une liste de Commentaire selon son 'utilisateur'.
     *
     * @param id_utilisateur id de l'utilisateur
     * @return Une liste de Commentaire correspondant à l'utilisateur.
     * @throws NotFoundException
     */
    List<Commentaire> getCommentaireByUser(int id_utilisateur);

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
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Supprime un Commentaire
     * @param vCommentaire
     */
    void deleteCommentaire(Commentaire vCommentaire);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Supprime les objets Commentaire selon l'id du spot
     * @param id_spot
     */
    void deleteAllByIdSpot(int id_spot);

    int getCountCommentaire();
}