package fr.banane.projet6.batch;

import fr.banane.projet6.business.contract.ManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    //TODO ajouter le bootstrapContext.xml
    ApplicationContext vApplicationContext
            = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

    // Il est possible de récupérer un bean dans ce contexte :
    ManagerFactory vManagerFactory
            = vApplicationContext.getBean("managerFactory", ManagerFactory.class);
}
