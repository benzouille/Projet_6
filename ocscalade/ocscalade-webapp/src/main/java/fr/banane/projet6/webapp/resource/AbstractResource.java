package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.business.contract.ManagerFactory;

/**
 * Classe abstraite en charge de récupérer L'objet ManagerFactory.
 *
 * @author Banane
 *
 */
public abstract class AbstractResource {

    //-- Variable d'instances
    private static ManagerFactory managerFactory;

    //-- GETTER
    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    //-- SETTER
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}