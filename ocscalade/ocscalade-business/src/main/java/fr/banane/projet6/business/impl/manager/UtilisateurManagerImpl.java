package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.UtilisateurManager;
import fr.banane.projet6.model.bean.Privilege;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.NotFoundException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Override
    public void newUtilisateur() {

    }

    @Override
    public List<Utilisateur> getListUtilisateur() {
        return getDaoFactory().getDaoUtilisateur().readAll();
    }

    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        return getDaoFactory().getDaoUtilisateur().read(pId);
    }

    @Override
    public void updateUtilisateur(Utilisateur vUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                getDaoFactory().getDaoUtilisateur().update(vUtilisateur);
            }
        });
    }


    @Override
    public void deleteUtilisateur(Integer vId) {

    }

    @Override
    public Integer getNbUtilisateur() {
        return getDaoFactory().getDaoUtilisateur().getCountUtilisateur();
    }
}
