package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

public class DepartementResource extends AbstractResource {

    public List<Departement> getListDepartement() {
        return getManagerFactory().getDepartementManager().getListDepartement();
    }

    public Departement getDepartement(Integer pId) throws NotFoundException {
        return getManagerFactory().getDepartementManager().getDepartement(pId);
    }

    public Departement getDepartementByNum(String num) {
        return getManagerFactory().getDepartementManager().getDepartementByNum(num);
    }
}
