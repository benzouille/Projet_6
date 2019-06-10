package fr.banane.projet6.batch;

import fr.banane.projet6.model.exception.TechnicalException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Classe Principale de lancement des Batches.
 *
 * @author lgu / vifier-lockla
 */
public class Main {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);


    //-- Déclaration des dépendances



    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     * @throws TechnicalException sur erreur technique
     */
    public static void main(String[] pArgs) throws TechnicalException {

        //-- IoC Container de Spring avec des fichiers en XML (Spring démarre ici => Aucune injection n'est faite avant cette ligne...)
        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");
        //ManagerFactory vManagerFactory = vApplicationContext.getBean("managerFactory", ManagerFactory.class); 	    // Il est possible de récupérer un bean dans ce contexte


        // suite de l'implémentation des batches...
        try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }

            String vTraitementId = pArgs[0];
            if ("ExportTicketStatus".equals(vTraitementId)) {
                LOGGER.info("Execution du traitement : ExportTicketStatus");

                //----- ZONE DE TESTS ------
                //TestPropertiesFile1 test2 = new TestPropertiesFile1();
                //TestPropertiesFile2 test3 = new TestPropertiesFile2();
                //----- FIN ZONE DE TESTS -----

//                AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
//                ApplicationProperties appProperties = context.getBean(ApplicationProperties.class);
//
//                TicketStatutBatch ticketStatutBatch = new TicketStatutBatch();
//                ticketStatutBatch.sauverTicketStatutToFichierTexte(appProperties.getCheminFichierTicketStatut(), appProperties.getNomFichierTicketStatut());
//                context.close();

            } else {
                throw new TechnicalException("Traitement inconnu : " + vTraitementId);
            }
        } catch (Throwable vThrowable) {
            LOGGER.error(vThrowable);
            System.exit(1);
        }

    }
}
