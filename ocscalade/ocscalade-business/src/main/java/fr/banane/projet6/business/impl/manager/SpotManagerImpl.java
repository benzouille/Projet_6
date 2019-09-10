package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.SpotManager;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.model.exception.TechnicalException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Implémentation de l'interface manager "SpotManager".
 *
 * @author Banane
 */
@Named
public class SpotManagerImpl extends AbstractManager implements SpotManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newSpot(Spot vSpot) {
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
    public List<Spot> getListSpotForIndex() {
        return getDaoFactory().getDaoSpot().readAllForIndex();
    }

    @Override
    public List<Spot> getListSpotByQuery(String departement, String difficulte, String nbreSecteur, boolean equipement, boolean officiel) {
        return getDaoFactory().getDaoSpot().getListSpotByQuery(departement, difficulte, nbreSecteur, equipement, officiel);
    }

    @Override
    public Spot getSpot(Integer pId) throws TechnicalException {
        return getDaoFactory().getDaoSpot().read(pId);
    }

    @Override
    public Spot getSpotByName(String name) {
        return getDaoFactory().getDaoSpot().readByName(name);
    }

    @Override
    public void updateSpot(Spot vSpot) {
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
