package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.CommentaireManager;
import fr.banane.projet6.model.bean.Commentaire;
import fr.banane.projet6.model.exception.TechnicalException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

        @Inject
        @Named("txManager")
        private PlatformTransactionManager platformTransactionManager;


    @Override
    public void newCommentaire(Commentaire vCommentaire) throws TechnicalException {
        //NotFoundException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            getDaoFactory().getDaoCommentaire().create(vCommentaire);

            TransactionStatus vTScommit = vTransactionStatus;
            vTransactionStatus = null;
            platformTransactionManager.commit(vTScommit);
        }catch (Exception e){
            e.printStackTrace();
            throw new TechnicalException("Service indisponible pour le moment veuillez réessyer plus tard");
        }finally {
            if(vTransactionStatus != null) {
                platformTransactionManager.rollback(vTransactionStatus);
            }
        }
    }

    @Override
    public Commentaire getCommentaire(Integer pId) throws TechnicalException {
        return getDaoFactory().getDaoCommentaire().read(pId);
    }

    @Override
    public List<Commentaire> getListCommentaire() throws TechnicalException {
        return getDaoFactory().getDaoCommentaire().readAll();
    }

    @Override
    public List<Commentaire> getCommentaireByUser(int id_utilisateur) {
        return getDaoFactory().getDaoCommentaire().readAllByUser(id_utilisateur);
    }

    @Override
    public List<Commentaire> getListCommentaireByIdSpot(int id_spot) {
        return getDaoFactory().getDaoCommentaire().readAllBySpot(id_spot);
    }

    @Override
    public void updateCommentaire(Commentaire vCommentaire) {
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoCommentaire().update(vCommentaire);

            TransactionStatus vTScommit = vTransactionStatus;
            vTransactionStatus = null;
            platformTransactionManager.commit(vTScommit);
        }finally {
            if(vTransactionStatus != null) {
                platformTransactionManager.rollback(vTransactionStatus);
            }
        }
    }

    @Override
    public void deleteCommentaire(Commentaire vCommentaire) {
        getDaoFactory().getDaoCommentaire().delete(vCommentaire);
    }

    @Override
    public void deleteAllByIdSpot(int id_spot) {
        getDaoFactory().getDaoCommentaire().deleteAllBySpot(id_spot);
    }
}
