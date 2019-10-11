package fr.oc.projet.batch;

import fr.oc.projet.business.contract.ManagerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Timer;


/**
 * Classe main du batch
 * On lance la classe SheduledTasks via sheduledAtFixedRate
 * Le délai de répétition est définit dans le config.properties
 */
@ComponentScan
public class App 
{
    public static void main( String[] args ) throws IOException {
        ApplicationContext vApplicationContext
                = new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");

        ManagerFactory managerFactory = vApplicationContext.getBean("managerFactoryImpl", ManagerFactory.class);

        final Logger logger = LogManager.getLogger();

        Properties propConfig = new Properties();
        FileInputStream propFile = new FileInputStream("C:\\Users\\El-ra\\Documents\\Projet_7_OC\\resources\\config.properties");
        propConfig.load(propFile);

        Timer timer;
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduledTasks(managerFactory,logger), 1000, Integer.parseInt(propConfig.getProperty("timeMail")));
    }
}
