package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

public abstract class AbstractManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    private DaoFactory daoFactory;

    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    public DaoFactory getDaoFactory(){
        return daoFactory;
    }
    public void setDaoFactory(DaoFactory vdaoFactory){
        this.daoFactory = vdaoFactory;
    }

}
