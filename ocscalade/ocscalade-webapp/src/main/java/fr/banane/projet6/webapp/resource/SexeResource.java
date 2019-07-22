package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Sexe;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

public class SexeResource extends AbstractResource {
    public List<Sexe> getListSexe() {
        return getManagerFactory().getSexeManager().getListSexe();
    }

    public Sexe getSexe(Integer pId) throws NotFoundException {
        return getManagerFactory().getSexeManager().getSexe(pId);
    }

    public Sexe getSexeBySexe(String sexe) {
        return getManagerFactory().getSexeManager().getSexeBySexe(sexe);
    }
}
