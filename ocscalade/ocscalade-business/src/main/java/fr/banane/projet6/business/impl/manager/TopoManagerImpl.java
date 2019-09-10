package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.TopoManager;
import fr.banane.projet6.model.bean.Topo;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Timestamp;
import java.util.List;

/**
 * Implémentation de l'interface manager "TopoManager".
 *
 * @author Banane
 */
@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newTopo(Topo vTopo) {
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoTopo().create(vTopo);

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
    public List<Topo> getListTopo() {
        return getDaoFactory().getDaoTopo().readAll();
    }

    @Override
    public List<Topo> getListTopoByUser(int id_user) {
        return getDaoFactory().getDaoTopo().readAllByCreateur(id_user);
    }

    @Override
    public List<Topo> getListTopoByDepartement(int id_dep) {
        return getDaoFactory().getDaoTopo().readAllByDepartementSpot(id_dep);
    }

    @Override
    public List<Topo> getListTopoByReservable() {
        return getDaoFactory().getDaoTopo().readAllByReservable();
    }

    @Override
    public Topo getTopo(Integer pId) {
        return getDaoFactory().getDaoTopo().read(pId);
    }

    @Override
    public Topo getTopoByName(String name) {
        return getDaoFactory().getDaoTopo().read(name);
    }

    @Override
    public List<Topo> getListTopoByQuery(String departement, String spot, String createur, Timestamp date, boolean disponible) {
            return getDaoFactory().getDaoTopo().getListTopoByQuery( departement, spot, createur, date, disponible);
    }

    @Override
    public void updateTopo(Topo vTopo) {
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoTopo().update(vTopo);

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
    public void deleteTopo(Topo vTopo) {

    }
}
