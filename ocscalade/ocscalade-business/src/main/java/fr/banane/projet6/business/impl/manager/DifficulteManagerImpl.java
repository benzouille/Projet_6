package fr.banane.projet6.business.impl.manager;

import fr.banane.projet6.business.contract.manager.DifficulteManager;
import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.exception.NotFoundException;

import javax.inject.Named;
import java.util.List;

/**
 * Implémentation de l'interface manager "DifficulteManager".
 *
 * @author Banane
 */
@Named
public class DifficulteManagerImpl extends AbstractManager implements DifficulteManager  {
    @Override
    public List<Difficulte> getListDifficulte() {
        return getDaoFactory().getDaoDifficulte().readAll();
    }

    @Override
    public Difficulte getDifficulteById(Integer pId) throws NotFoundException {
        return getDaoFactory().getDaoDifficulte().read(pId);
    }

    @Override
    public Difficulte getDifficulte(String difficulte) {
        return getDaoFactory().getDaoDifficulte().readByDifficulte(difficulte);
    }
}
