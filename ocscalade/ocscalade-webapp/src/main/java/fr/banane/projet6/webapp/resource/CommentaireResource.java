package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Commentaire;

public class CommentaireResource extends AbstractResource {

    public Commentaire getCommentaire(int id_commentaire){
        return getManagerFactory().getCommentaireManager().getCommentaire(id_commentaire);
    }

    public void newCommentaire(Commentaire vCommentaire){
        getManagerFactory().getCommentaireManager().newCommentaire(vCommentaire);
    }

    public void updateCommentaire(Commentaire vCommentaire){
        getManagerFactory().getCommentaireManager().updateCommentaire(vCommentaire);
    }

    public void deleteCommentaire(Commentaire vCommentaire){
        getManagerFactory().getCommentaireManager().deleteCommentaire(vCommentaire);
    }
}
