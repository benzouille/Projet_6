package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.UtilisateurManager;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.DuplicateException;
import fr.banane.projet6.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newUtilisateur(Utilisateur vUtilisateur) {
        //TODO ajouter les exceptions NotFoundException et DuplicateException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoUtilisateur().create(vUtilisateur);

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
    public List<Utilisateur> getListUtilisateur() {
        return getDaoFactory().getDaoUtilisateur().readAll();
    }

    @Override
    public Utilisateur getUtilisateur(Integer pId) {
        //TODO ajouter le throws pour l'exceptions NotFoundException
        return getDaoFactory().getDaoUtilisateur().read(pId);
    }

    @Override
    public Utilisateur getUtilisateur(String pseudo) throws NotFoundException{

        return getDaoFactory().getDaoUtilisateur().read(pseudo);

    }

    @Override
    public void updateUtilisateur(Utilisateur vUtilisateur) {
        //TODO ajouter le throws pour l'exceptions NotFoundException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoUtilisateur().update(vUtilisateur);

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
    public void deleteUtilisateur(Utilisateur vUtilisateur) {
        //TODO ajouter le throws pour l'exceptions NotFoundException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoUtilisateur().delete(vUtilisateur);

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
    public Integer getNbUtilisateur() {
        return getDaoFactory().getDaoUtilisateur().getCountUtilisateur();
    }
}
