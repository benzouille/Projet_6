package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

public abstract class AbstractManager {


    private PlatformTransactionManager platformTransactionManager;

    private DaoFactory daoFactory;

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public DaoFactory getDaoFactory(){
        return daoFactory;
    }
    public void SetDaoFactory(DaoFactory vdaoFactory){
        this.daoFactory = vdaoFactory;
    }

}
