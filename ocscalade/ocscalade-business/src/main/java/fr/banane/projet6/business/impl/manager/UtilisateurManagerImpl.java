package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.UtilisateurManager;
import fr.banane.projet6.model.bean.Privilege;
import fr.banane.projet6.model.bean.Utilisateur;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.inject.Named;

@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    public void modifierProfil(Utilisateur vUtilisateur, Privilege vpPrivilege){
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                vUtilisateur.setPrivilege(vpPrivilege);
                //getDaoFactory().getDaoUtilisateur.update(vUtilisateur);
            }
        });
    }
}
