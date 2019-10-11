package fr.oc.projet.batch;

import fr.oc.projet.model.beans.utilisateur.Abonne;
import org.apache.logging.log4j.Logger;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.util.Properties;


/**
 * Classe qui gère l'envoie du mail
 */
public class EnvoyerMail {

    /**
     * Méthode pour envoyer un mail
     * L'adresse électronique de l'envoyeur et son mot de passe
     * son définit dans le fichier config.properties
     * @param objet
     * @param contenu
     * @param abonne
     * @param logger
     * @throws Exception
     */
    public void sendMessage(String objet, String contenu, Abonne abonne, Logger logger) throws Exception{

        Properties propConfig = new Properties();
        FileInputStream propFile = new FileInputStream("C:\\Users\\El-ra\\Documents\\Projet_7_OC\\resources\\config.properties");
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
            message.setSubject(objet);
            message.setText(contenu);
            Transport.send(message);
        } catch (MessagingException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }
}