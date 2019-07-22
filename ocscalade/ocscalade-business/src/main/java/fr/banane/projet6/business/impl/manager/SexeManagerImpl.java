package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.SexeManager;
import fr.banane.projet6.model.bean.Sexe;
import fr.banane.projet6.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.List;

/**
 * Implémentation de l'interface manager "SexeManager".
 *
 * @author Banane
 */
@Named
public class SexeManagerImpl extends AbstractManager implements SexeManager {
    @Override
    public List<Sexe> getListSexe() {
        return getDaoFactory().getDaoSexe().readAll();
    }

    @Override
    public Sexe getSexe(Integer pId) throws NotFoundException {
        return getDaoFactory().getDaoSexe().read(pId);
    }

    @Override
    public Sexe getSexeBySexe(String sexe) {
        return getDaoFactory().getDaoSexe().read(sexe);
    }
}
