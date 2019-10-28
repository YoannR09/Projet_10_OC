package fr.oc.projet.bibliothequeclient.mail;

import fr.oc.projet.bibliothequeclient.beans.Abonne;
import fr.oc.projet.bibliothequeclient.beans.LivreUnique;
import fr.oc.projet.bibliothequeclient.beans.Reservation;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe qui gère l'envoie de mail
 * Consulte si la réservation est toujours existante avec un repeatScheduledTask
 * Si deux jours passes ou que la réservation n'est plus existante on passe à la réservation suivante.
 */
public class MailReservation {

    private         List<Reservation>       list;
    private         Abonne                  abonne;
    private         int                     livreId;
    private         int                     bibliothequeId;
    private         int                     reservationId;
    private         LivreUnique             exemplaire;
    private         TimerTask               taskInfo;

    private         MicroServiceAbonneProxy         microServiceAbonneProxy;
    private         MicroServiceReservationProxy    microServiceReservationProxy;
    private         MicroServiceLivreUniqueProxy    microServiceLivreUniqueProxy;
    private         MicroServiceLivreProxy          microServiceLivreProxy;
    private         MicroServiceBibliothequeProxy   microServiceBibliothequeProxy;

    private static final Logger logger = LogManager.getLogger();

    public MailReservation(MicroServiceAbonneProxy vMicroAbonne,
                           MicroServiceReservationProxy vMicroResa,
                           MicroServiceLivreUniqueProxy vMicroLivreUnique,
                           MicroServiceLivreProxy vMicroLivre,
                           MicroServiceBibliothequeProxy vMicroBibliotheque){
        this.microServiceAbonneProxy = vMicroAbonne;
        this.microServiceReservationProxy = vMicroResa;
        this.microServiceLivreUniqueProxy = vMicroLivreUnique;
        this.microServiceLivreProxy = vMicroLivre;
        this.microServiceBibliothequeProxy = vMicroBibliotheque;
    }

    /**
     * Méthode pour envoyer le mail à l'abonné qui possède cette réservation
     * @param vList
     * @param livreUnique
     * @throws IOException
     */
    public void gestionMail(List<Reservation> vList, LivreUnique livreUnique) throws IOException {
        list = vList;
        exemplaire = livreUnique;
        Reservation reservation = list.get(0);
        reservation.setLivreUniqueId(exemplaire.getId());
        microServiceReservationProxy.updateReservation(reservation);
        abonne = microServiceAbonneProxy.getAbonne(reservation.getAbonneId());
        livreId = reservation.getLivreId();
        bibliothequeId = reservation.getBibliothequeId();
        reservationId = reservation.getId();

        sendMail();
        System.out.println(" Envoie du mail ");

        // Lance le timer de deux jours pour rendre disponible l'exemplaire à l'abonné.
        TimerTask task = new TimerTask() {
            public void run() {
                microServiceReservationProxy.delete(reservationId);
                System.out.println("Délai dépassé, l'ancienne réservation est supprimé.");
            }
        };
        Timer timer = new Timer("Timer");
        // timer.schedule(task,Integer.parseInt(propConfig.getProperty("timeResa")));
        timer.schedule(task, 100000); // 2 jours
        verifResa(task);
    }

    /**
     * On vérifie que la réservation de l'abonné existe toujours.
     * @param task
     */
    public void verifResa(TimerTask task){
        // Lance un timer qui vérifie si la réservation est toujours existante
        TimerTask taskVerif = new TimerTask() {
            public void run() {
                System.out.println("Vérifie que la réservation est toujours existante");
                if(microServiceReservationProxy.getReservation(reservationId) == null){
                    System.out.println(" Il n'y a plus de reservation à cet id en cours on arrête les deux jours de delai");
                    task.cancel();
                    taskInfo.cancel();
                    if(!microServiceLivreUniqueProxy.findById(exemplaire.getId()).getSousReserve() &&
                            !microServiceLivreUniqueProxy.findById(exemplaire.getId()).getDisponible()){
                        if(microServiceReservationProxy.findByBibliothequeIdAndLivreId(bibliothequeId,livreId).size() != 0) {
                            System.out.println(" Recherche de la personne suivante dans la file");
                            try {
                                gestionMail(microServiceReservationProxy.findByBibliothequeIdAndLivreId(bibliothequeId, livreId), exemplaire);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }else {
                        System.out.println(" Il n'y a plus de reservation pour ce livre, l'exemplaire est maintenant disponible");
                        exemplaire.setDisponible(true);
                        exemplaire.setSousReserve(false);
                        microServiceLivreUniqueProxy.updateDispo(exemplaire);
                    }
                }
            }
        };
        Timer timer = new Timer("Timer");
        timer.scheduleAtFixedRate(taskVerif,1000,20000);
        taskInfo = taskVerif;
    }

    public void sendMail() throws IOException {
        String contenu = " Bonjour monsieur/madame "+abonne.getNom()+"" +
                " \n Nous vous contactons suite à votre réservation du livre "
                +microServiceLivreProxy.getLivre(exemplaire.getLivreId()).getTitre()+"." +
                " \n L'exemplaire est disponible dans notre bibliotheque suivante : "
                +microServiceBibliothequeProxy.getBibliotheque(exemplaire.getBibliothequeId())+"." +
                " \n Vous avez deux jours pour récupérer votre livre dans notre bibliothèque." +
                " \n Merci de votre compréhension. Cordialement, l'équipe de la Bibliothèque";
        Properties propConfig = new Properties();
        FileInputStream propFile = new FileInputStream("C:/Users/Pierrosan/Documents/Projet_10_OC/resources/config.properties");
        propConfig.load(propFile);
        final String username = propConfig.getProperty("emailUser");
        final String password = propConfig.getProperty("emailPass");
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(abonne.getEmail())
            );
            message.setSubject("Votre livre est disponible");
            message.setText(contenu);
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }
}
