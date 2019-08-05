package fr.banane.projet6.batch;

import fr.banane.projet6.business.contract.ManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.inject.Inject;

/**
 * Hello world!
 *
 */
public class App 
{

    @Inject
    ManagerFactory vManagerFactory;

    public App(){
        //TODO ajouter le bootstrapContext.xml
        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        // Il est possible de récupérer un bean dans ce contexte :
        vManagerFactory = vApplicationContext.getBean("managerFactory", ManagerFactory.class);
    }


    public static void main(String[] args )
    {
       App app = new App();
    }
}
