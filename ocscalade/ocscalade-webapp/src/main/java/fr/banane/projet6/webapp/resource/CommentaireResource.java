package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Commentaire;
import fr.banane.projet6.model.exception.TechnicalException;

/**
 * Classe permettant de manipuler un Objet Commentaire depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class CommentaireResource extends AbstractResource {

    /**
     * Retourne un Objet Commentaire selon son id
     * @param id_commentaire int
     * @return un objet Commentaire
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    public Commentaire getCommentaire(int id_commentaire) throws TechnicalException {
        return getManagerFactory().getCommentaireManager().getCommentaire(id_commentaire);
    }

    /**
     * Envoie un objet Commentaire au module business
     * @param vCommentaire objet Commentaire
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    public void newCommentaire(Commentaire vCommentaire) throws TechnicalException {
        getManagerFactory().getCommentaireManager().newCommentaire(vCommentaire);
    }

    /**
     * Met à jour un objet Commentaire
     * @param vCommentaire objet Commentaire
     */
    public void updateCommentaire(Commentaire vCommentaire){
        getManagerFactory().getCommentaireManager().updateCommentaire(vCommentaire);
    }

    /**
     * Supprime un objet Commentaire
     * @param vCommentaire objet Commentaire
     */
    public void deleteCommentaire(Commentaire vCommentaire){
        getManagerFactory().getCommentaireManager().deleteCommentaire(vCommentaire);
    }
}
