package fr.banane.projet6.batch;

import fr.banane.projet6.business.contract.ManagerFactory;

/**
 * Classe abstraite en charge de récupérer L'objet ManagerFactory.
 *
 * @author Banane
 *
 */
public abstract class AbstractResource {

        //-- Variable d'instances initialisé dans l'IoC Container (cf batchContext.xml)
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

