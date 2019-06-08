package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

public abstract class AbstractManager {

    //TODO à voir si modification total
    private DaoFactory daoFactory;

    protected  DaoFactory getDaoFactory(){
        return daoFactory;
    }

    public  void SetDaoFactory(DaoFactory vdaoFactory){
        this.daoFactory = vdaoFactory;
    }

//    @Inject
//    @Named("txManagerOcscalade")
//    private PlatformTransactionManager platformTransactionManager;
//    public PlatformTransactionManager getPlatformTransactionManager() {
//        return platformTransactionManager;
//    }
//
//    @Inject
//    private DaoFactory daoFactory;
//    protected DaoFactory getDaoFactory() {
//        return daoFactory;
//    }
}
