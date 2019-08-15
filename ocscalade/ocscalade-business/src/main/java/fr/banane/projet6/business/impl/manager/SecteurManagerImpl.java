package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.SecteurManager;
import fr.banane.projet6.model.bean.Secteur;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newSecteur(Secteur vSecteur) {
        //TODO ajouter les exceptions NotFoundException et DuplicateException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoSecteur().create(vSecteur);

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
    public List<Secteur> getListSecteur() {
        return getDaoFactory().getDaoSecteur().readAll();
    }

    @Override
    public List<Secteur> getListSecteurByIdSpot(int id_spot) {
        return getDaoFactory().getDaoSecteur().readAllByIdSpot(id_spot);
    }

    @Override
    public Secteur getSecteur(Integer pId) {
        return getDaoFactory().getDaoSecteur().read(pId);
    }

    @Override
    public Secteur getSecteurByName(String name) {
        return getDaoFactory().getDaoSecteur().read(name);
    }

    @Override
    public void updateSecteur(Secteur vSecteur) {

    }

    @Override
    public void deleteSecteur(Secteur vSecteur) {

    }
}
