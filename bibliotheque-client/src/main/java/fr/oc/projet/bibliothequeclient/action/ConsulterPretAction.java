package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.Abonne;
import fr.oc.projet.bibliothequeclient.beans.Livre;
import fr.oc.projet.bibliothequeclient.beans.Pret;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Classe qui gère la page pour consulter les prêts des abonnées.
 */
public class ConsulterPretAction extends ActionSupport {

    private         String          isbn;
    private         String          auteur;
    private         String          titre;
    private         String          email;
    private         String          pseudo;
    private         String          nom;
    private         String          prenom;
    private         String          bibliotheque;
    private         List<Pret>      pretList;
    private         Abonne          abonne;
    private         Livre           livre;
    private         Integer         pretId;
    private         Integer         bibliothequeId;
    private         Integer         countResultat;
    private         Pret            pret;
    private         String          recherche;

    private static final Logger logger = LogManager.getLogger(ConsulterPretAction.class);

    private Properties propConfig = new Properties();
    private FileInputStream propFile ;

    @Autowired
    MicroServicePretProxy microServicePretProxy;
    @Autowired
    MicroServiceBibliothequeProxy microServiceBibliothequeProxy;
    @Autowired
    MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;

    /**
     * Méthode pour la recherche de prêts en cours
     * On peut rechercher via abonnées ou par livres
     * @return
     */
    public String doListPretRecherche(){
        if(!isbn.equals("") || !auteur.equals("") || !titre.equals("")){
            if(bibliotheque.equals("Toutes les bibliothèques")){
                if(!isbn.equals("") &&  !auteur.equals("") &&  !titre.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitreAuteurISBN(titre,auteur,isbn);
                }else if (!isbn.equals("") &&  !auteur.equals("")  && titre.equals("")){
                    pretList = microServicePretProxy.getListPretLivreAuteurISBN(auteur,isbn);
                }else if (!auteur.equals("") &&  !titre.equals("") && isbn.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitreAuteur(titre,auteur);
                }else if(!isbn.equals("") &&  !titre.equals("") && auteur.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitreISBN(titre,isbn);
                }else if (!isbn.equals("") && titre.equals("") && auteur.equals("")){
                    pretList = microServicePretProxy.getListPretLivreISBN(isbn);
                } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")){
                    pretList = microServicePretProxy.getListPretLivreAuteur(auteur);
                }else if (!titre.equals("") && auteur.equals("") && isbn.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitre(titre);
                }
            }else {
                bibliothequeId = microServiceBibliothequeProxy.findByNom(bibliotheque).getId();
                if(!isbn.equals("") &&  !auteur.equals("") &&  !titre.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitreAuteurISBNBibliotheque(titre,auteur,isbn,bibliothequeId);
                }else if (!isbn.equals("") &&  !auteur.equals("")  && titre.equals("")){
                    pretList = microServicePretProxy.getListPretLivreAuteurISBNBibliotheque(auteur,isbn,bibliothequeId);
                }else if (!auteur.equals("") &&  !titre.equals("") && isbn.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitreAuteurBibliotheque(titre,auteur,bibliothequeId);
                }else if(!isbn.equals("") &&  !titre.equals("") && auteur.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitreISBNBibliotheque(titre,isbn,bibliothequeId);
                }else if (!isbn.equals("") && titre.equals("") && auteur.equals("")){
                    pretList = microServicePretProxy.getListPretLivreISBNBibliotheque(isbn,bibliothequeId);
                } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")){
                    pretList = microServicePretProxy.getListPretLivreAuteurBibliotheque(auteur,bibliothequeId);
                }else if (!titre.equals("") && auteur.equals("") && isbn.equals("")){
                    pretList = microServicePretProxy.getListPretLivreTitreBibliotheque(titre,bibliothequeId);
                }
            }
            recherche = "livre";
        }
        if(!pseudo.equals("") || !email.equals("") || !nom.equals("") || !prenom.equals("")){
            if(bibliotheque.equals("Toutes les bibliothèques")) {
                if (!pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmailNomPrenom(pseudo,email,nom,prenom);
                } else if (!pseudo.equals("") && !email.equals("") && !nom.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmailNom(pseudo,email,nom);
                } else if (!pseudo.equals("") && !email.equals("") && !prenom.equals("") && nom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmailPrenom(pseudo,email,prenom);
                } else if (!pseudo.equals("") && !nom.equals("") && !prenom.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoNomPrenom(pseudo,nom,prenom);
                } else if (pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmailNomPrenom(email,nom,prenom);
                } else if (!pseudo.equals("") && !email.equals("") && prenom.equals("") && nom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmail(pseudo,email);
                } else if (!nom.equals("") && !prenom.equals("") && pseudo.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneNomPrenom(nom,prenom);
                } else if (!pseudo.equals("") && !prenom.equals("") && email.equals("") && nom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoPrenom(pseudo,prenom);
                } else if (!email.equals("") && !nom.equals("") && pseudo.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmailNom(email,nom);
                } else if (!email.equals("") && !prenom.equals("") && nom.equals("") && pseudo.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmailPrenom(email,prenom);
                } else if (!pseudo.equals("") && !nom.equals("") && email.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoNom(pseudo,nom);
                } else if (!pseudo.equals("") && nom.equals("") && email.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudo(pseudo);
                } else if (!email.equals("") && nom.equals("") && pseudo.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmail(email);
                } else if (!nom.equals("") && pseudo.equals("") && prenom.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneNom(nom);
                } else if (!prenom.equals("") && pseudo.equals("") && nom.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePrenom(prenom);
                }
            }else {
                if (!pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")) {
                    bibliothequeId = microServiceBibliothequeProxy.findByNom(bibliotheque).getId();
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmailNomPrenomBibliotheque(pseudo,email,nom,prenom,bibliothequeId);
                } else if (!pseudo.equals("") && !email.equals("") && !nom.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmailNomBibliotheque(pseudo,email,nom,bibliothequeId);
                } else if (!pseudo.equals("") && !email.equals("") && !prenom.equals("") && nom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmailPrenomBibliotheque(pseudo,email,prenom,bibliothequeId);
                } else if (!pseudo.equals("") && !nom.equals("") && !prenom.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoNomPrenomBibliotheque(pseudo,nom,prenom,bibliothequeId);
                } else if (pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmailNomPrenomBibliotheque(email,nom,prenom,bibliothequeId);
                } else if (!pseudo.equals("") && !email.equals("") && prenom.equals("") && nom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoEmailBibliotheque(pseudo,email,bibliothequeId);
                } else if (!nom.equals("") && !prenom.equals("") && pseudo.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneNomPrenomBibliotheque(nom,prenom,bibliothequeId);
                } else if (!pseudo.equals("") && !prenom.equals("") && email.equals("") && nom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoPrenomBibliotheque(pseudo,prenom,bibliothequeId);
                } else if (!email.equals("") && !nom.equals("") && pseudo.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmailNomBibliotheque(email,nom,bibliothequeId);
                } else if (!email.equals("") && !prenom.equals("") && nom.equals("") && pseudo.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmailPrenomBibliotheque(email,prenom,bibliothequeId);
                } else if (!pseudo.equals("") && !nom.equals("") && email.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoNomBibliotheque(pseudo,nom,bibliothequeId);
                } else if (!pseudo.equals("") && nom.equals("") && email.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePseudoBibliotheque(pseudo,bibliothequeId);
                } else if (!email.equals("") && nom.equals("") && pseudo.equals("") && prenom.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneEmailBibliotheque(email,bibliothequeId);
                } else if (!nom.equals("") && pseudo.equals("") && prenom.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonneNomBibliotheque(nom,bibliothequeId);
                } else if (!prenom.equals("") && pseudo.equals("") && nom.equals("") && email.equals("")) {
                    pretList = microServicePretProxy.getListPretAbonnePrenomBibliotheque(prenom,bibliothequeId);
                }
            }
            recherche = "abonne";
        }
        if (pretList != null) {
            for(Pret pret : pretList){
                pret.setAbonne(microServiceAbonneProxy.getAbonne(pret.getAbonneId()));
                pret.setLivreUnique(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()));
                pret.getLivreUnique().setLivre(microServiceLivreProxy.getLivre(pret.getLivreUnique().getLivreId()));
                pret.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(pret.getLivreUnique().getBibliothequeId()));
                if(pret.getDateRestitution().compareTo(new Date()) > 0) {
                    pret.setExpire(false);
                }else {
                    pret.setExpire(true);
                }
            }
            countResultat = pretList.size();
        }else {
            this.addActionMessage("Aucun prêt trouvé");
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour prolonger la date de resitution du prêt en cours
     * On ajoute 28 jours à la période d'emprunt
     * Ce prêt ne pourra plus être prolongé.
     * @return
     */
    public String doProlongationPret() throws IOException {
        propFile = new FileInputStream("C:/Users/El-ra/Documents/Projet_10_OC/resources/config.properties");
        propConfig.load(propFile);
        pret = microServicePretProxy.getPret(pretId);
        Calendar cal = Calendar.getInstance();
        cal.setTime(pret.getDateRestitution());
        cal.add(Calendar.DATE,Integer.parseInt(propConfig.getProperty("prolongation")));
        pret.setDateRestitution(cal.getTime());
        pret.setProlongation(true);
        microServicePretProxy.updatePret(pret);
        this.addActionMessage("Le prêt a été prolongé");
        logger.info("Le prêt à était prolongé");
        return ActionSupport.SUCCESS;
    }



    public String doConsulterPret(){
        return  ActionSupport.SUCCESS;
    }

    public Integer getCountResultat() {
        return countResultat;
    }

    public void setCountResultat(Integer countResultat) {
        this.countResultat = countResultat;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public List<Pret> getPretList() {
        return pretList;
    }

    public void setPretList(List<Pret> pretList) {
        this.pretList = pretList;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Integer getPretId() {
        return pretId;
    }

    public void setPretId(Integer pretId) {
        this.pretId = pretId;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    public String getRecherche() {
        return recherche;
    }

    public void setRecherche(String recherche) {
        this.recherche = recherche;
    }

    public Integer getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(Integer bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }


}
