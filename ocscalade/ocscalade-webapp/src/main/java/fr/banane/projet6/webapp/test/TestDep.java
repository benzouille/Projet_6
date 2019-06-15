package fr.banane.projet6.webapp.test;

import fr.banane.projet6.model.bean.Departement;
import fr.banane.projet6.webapp.resource.AbstractResource;

import javax.inject.Named;
import java.util.List;

@Named
public class TestDep extends AbstractResource {

    private Departement vDepartement;
    private List<Departement> vDepartements;

    public List<Departement> getDepartements() {
        //-- On préfère récupérer une instance de ProjetManager via un ManagerFactory
        return getManagerFactory().getDepartementManager().getListDepartement();
    }
}
