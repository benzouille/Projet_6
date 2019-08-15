package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.VoieManager;
import fr.banane.projet6.model.bean.Voie;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newVoie(Voie vVoie) {
        //TODO ajouter les exceptions NotFoundException et DuplicateException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoVoie().create(vVoie);

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
    public Voie getVoie(Integer pId) {
        return getDaoFactory().getDaoVoie().read(pId);
    }

    @Override
    public List<Voie> getListVoie() {
        return getDaoFactory().getDaoVoie().readAll();
    }

    @Override
    public Voie getVoieByName(String name) {
        return null;
    }

    @Override
    public List<Voie> getListVoieByIdSecteur(int id_secteur) {
        return getDaoFactory().getDaoVoie().readAllByIdSecteur(id_secteur);
    }

    @Override
    public void updateSpot(Voie vVoie) {
        //TODO ajouter les exceptions NotFoundException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
        getDaoFactory().getDaoVoie().update(vVoie);

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
    public void deleteVoie(Voie vVoie) {
        //TODO ajouter les exceptions NotFoundException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
        getDaoFactory().getDaoVoie().delete(vVoie);

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
    public void deleteAllByIdSecteur(int id_secteur) {

    }

    @Override
    public int getCountVoie() {
        return 0;
    }
}
