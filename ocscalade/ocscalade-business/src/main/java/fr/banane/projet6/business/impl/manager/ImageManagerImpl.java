package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.ImageManager;
import fr.banane.projet6.model.bean.Image;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Implémentation de l'interface manager "ImageManager".
 *
 * @author Banane
 */
@Named
public class ImageManagerImpl extends AbstractManager implements ImageManager {

    @Inject
    @Named("txManager")
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void newImage(Image vImage) {
        //TODO ajouter les exceptions NotFoundException et DuplicateException
        TransactionStatus vTransactionStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
        try{
            getDaoFactory().getDaoImage().create(vImage);

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
    public Image getImage(Integer pId) {
        return getDaoFactory().getDaoImage().read(pId);
    }

    @Override
    public List<Image> getListImage() {
        return getDaoFactory().getDaoImage().readAll();
    }

    @Override
    public Image getImageByName(String name) {
        return getDaoFactory().getDaoImage().read(name);
    }

    @Override
    public List<Image> getListImageByIdSpot(int id_spot) {
        return getDaoFactory().getDaoImage().readAllByIdSpot(id_spot);
    }

    @Override
    public void updateImage(Image vImage) {

    }

    @Override
    public void deleteImage(Image vImage) {

    }

    @Override
    public void deleteAllByIdSpot(int id_spot) {

    }
}
