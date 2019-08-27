package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.SpotManager;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.exception.NotFoundException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SpotManagerImpl extends AbstractManager implements SpotManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newSpot(Spot vSpot) {
        //TODO ajouter les exceptions NotFoundException et DuplicateException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoSpot().create(vSpot);

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
    public List<Spot> getListSpot() {
        return getDaoFactory().getDaoSpot().readAll();
    }

    @Override
    public List<Spot> getListSpotByUser(int id_user) {
        return getDaoFactory().getDaoSpot().readAllByIdCreateur(id_user);
    }

    @Override
    public List<Spot> getListSpotByDepartement(int id_dep) {
        return getDaoFactory().getDaoSpot().getListSpotByDepartement(id_dep);
    }

    @Override
    public List<Spot> getListSpotByOfficiel() {
        return getDaoFactory().getDaoSpot().getListSpotByOfficiel();
    }

    @Override
    public List<Spot> getListSpotByQuery(String param1, String param2, String param3, boolean param4, boolean param5) {
        return getDaoFactory().getDaoSpot().getListSpotByQuery(param1, param2, param3, param4, param5);
    }

    @Override
    public Spot getSpot(Integer pId) {
        return getDaoFactory().getDaoSpot().read(pId);
    }

    @Override
    public Spot getSpotByName(String name) {
        return getDaoFactory().getDaoSpot().readByName(name);
    }

    @Override
    public void updateSpot(Spot vSpot) {
        //TODO ajouter le throws pour l'exceptions NotFoundException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoSpot().update(vSpot);

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
    public void deleteSpot(Spot vSpot) {

    }
}
