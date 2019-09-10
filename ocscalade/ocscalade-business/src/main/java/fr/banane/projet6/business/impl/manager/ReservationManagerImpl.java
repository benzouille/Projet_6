package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.ReservationManager;
import fr.banane.projet6.model.bean.Reservation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Implémentation de l'interface manager "ReservationManager".
 *
 * @author Banane
 */
@Named
public class ReservationManagerImpl extends AbstractManager implements ReservationManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newReservation(Reservation vReservation) {
        //TODO ajouter les exceptions NotFoundException et DuplicateException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoReservation().create(vReservation);

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
    public Reservation getReservation(Integer pId) {
        return getDaoFactory().getDaoReservation().read(pId);
    }

    @Override
    public List<Reservation> getListReservation() {
        return getDaoFactory().getDaoReservation().readAll();
    }

    @Override
    public List<Reservation> getListReservationByLocataire(int id_locataire) {
        return getDaoFactory().getDaoReservation().readAllByLocataire(id_locataire);
    }

    @Override
    public List<Reservation> getListReservationByProprietaireTopo(int id_proprietaire) {
        return getDaoFactory().getDaoReservation().readAllByProprietaireTopo(id_proprietaire);
    }

    @Override
    public List<Reservation> getListReservationByTopo(int id_topo) {
        return getDaoFactory().getDaoReservation().readAllByTopo(id_topo);
    }

    @Override
    public void updateReservation(Reservation vReservation) {
        //TODO ajouter les exceptions NotFoundException et DuplicateException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoReservation().update(vReservation);

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
    public void deleteReservation(Reservation vReservation) {
        getDaoFactory().getDaoReservation().delete(vReservation);
    }
}
