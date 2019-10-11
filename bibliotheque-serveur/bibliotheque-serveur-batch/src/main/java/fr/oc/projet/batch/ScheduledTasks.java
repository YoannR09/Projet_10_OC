package fr.oc.projet.batch;
import fr.oc.projet.business.contract.ManagerFactory;

import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import fr.oc.projet.model.beans.utilisateur.Abonne;

import fr.oc.projet.model.beans.utilisateur.Pret;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;



import javax.inject.Inject;

import javax.inject.Named;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.TimerTask;


/**
 * Classe qui est lancé en répétition.
 * Consulte les abonnés qui n'ont pas rendu leurs livre.
 */
public class ScheduledTasks extends TimerTask {

    private ManagerFactory  managerFactory;
    private Logger          logger;

    public ScheduledTasks(ManagerFactory managerFactory, Logger pLogger){
        this.managerFactory = managerFactory;
        this.logger = pLogger;
    }

    /**
     * Méthode pour rechercher les abonnées qui n'ont pas rendu leurs livre
     * On consulte la liste d'abonné piur en faire une boucle
     * On récupère la liste des prêts actif pour les abonnés pour en faire une boucle
     * On récupère une liste de livre unique non rendu à la bonne date
     * pour les ajouter au contenu du mail.
     */
    @Override
    public void run() {
        logger.info("mail pour les livres non réstitués envoyé");
        List<Abonne> vList = managerFactory.getAbonneManager().getListAbonne();
        for(Abonne abonne:vList){
            List<Pret> listPret = managerFactory.getPretManager().getListPretAbonne(abonne.getId());
            List<LivreUnique> listLivreUnique = new ArrayList<>();
            for(Pret pret:listPret){
                if(pret.getDateRestitution().compareTo(new Date()) < 0){
                    listLivreUnique.add(pret.getLivreUnique());
                }
            }
            if(listLivreUnique.size() != 0){
                List<String> listLivreNonRestitue = new ArrayList<>();
                for (LivreUnique livreUnique:listLivreUnique){
                    listLivreNonRestitue.add("Titre du livre : "+livreUnique.getLivre().getTitre() + ", ISBN-13 : "+livreUnique.getLivre().getIsbn()+" , dans la bibliothèque : "+livreUnique.getBibliotheque().getNom()+ ". \n");
                }
                String objet = "Prêt de livre dans notre bibliothèque";
                String contenu = "Madame, Monsieur, suite à l'emprunt de livre que vous avez effectué chez nous, nous vous serions reconnaissant de nous retourner les produits concernés dans les plus brefs délais. \n \n " +
                        " Date d'emprunt dépassé sur les livres suivant : \n"
                        + listLivreNonRestitue+
                        " \n Merci de votre compréhension. Cordialement, l'équipe de la Bibliothèque";

                EnvoyerMail envoyerMail = new EnvoyerMail();
                try {
                    envoyerMail.sendMessage(objet,contenu,abonne,logger);
                } catch (Exception e) {
                    logger.error(e);
                    e.printStackTrace();
                }
            }
        }
    }
}