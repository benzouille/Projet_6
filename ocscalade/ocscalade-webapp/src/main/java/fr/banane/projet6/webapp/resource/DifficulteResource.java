package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Difficulte;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

public class DifficulteResource extends AbstractResource {
    public List<Difficulte> getListDifficulte() {
        return getManagerFactory().getDifficulteManager().getListDifficulte();
    }

    public Difficulte getDifficulteById(Integer pId) throws NotFoundException {
        return getManagerFactory().getDifficulteManager().getDifficulteById(pId);
    }

    public Difficulte getDifficulte(String difficulte) {
        return getManagerFactory().getDifficulteManager().getDifficulte(difficulte);
    }
}
