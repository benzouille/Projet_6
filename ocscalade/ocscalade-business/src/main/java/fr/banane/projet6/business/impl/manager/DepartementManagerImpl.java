package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.DepartementManager;
import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.List;

/**
 * Implémentation de l'interface manager "DifficulteManager".
 *
 * @author Banane
 */
@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager {
    @Override
    public List<Departement> getListDepartement() {
        return getDaoFactory().getDaoDepartement().readAll();
    }

    @Override
    public Departement getDepartement(Integer pId) throws NotFoundException {
        return getDaoFactory().getDaoDepartement().read(pId);
    }

    @Override
    public Departement getDepartementByNum(Integer num) {
        return getDaoFactory().getDaoDepartement().readNum(num);
    }
}
