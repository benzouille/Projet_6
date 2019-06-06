package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.consumer.contract.DaoFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.inject.Named;

public abstract class AbstractManager {

    @Inject
    @Named("txManagerOcscalade")
    private PlatformTransactionManager platformTransactionManager;
    public PlatformTransactionManager getPlatformTransactionManager() {
        return platformTransactionManager;
    }

    @Inject
    private DaoFactory daoFactory;
    protected DaoFactory getDaoFactory() {
        return daoFactory;
    }
}
