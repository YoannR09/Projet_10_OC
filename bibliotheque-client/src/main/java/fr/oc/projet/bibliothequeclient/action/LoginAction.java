package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.*;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * Classe pour gérer les comptes des abonnées.
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    private MicroServiceCategorieProxy microServiceCategorieProxy;
    @Autowired
    private MicroServiceAdresseProxy microServiceAdresseProxy;
    @Autowired
    private MicroServiceBibliothequeProxy microServiceBibliothequeProxy;
    @Autowired
    private MicroServiceEmployeProxy microServiceEmployeProxy;

    private         Categorie           categorie;
    private         List<Categorie>     categorieList;
    private         List<Bibliotheque>  bibliothequeList;
    private         String              bibliotheque;
    private         String              email;
    private         String              identifiant;
    private         String              motDePasse;
    private         String              newMdp;
    private         String              newMdpVerif;
    private         String              codePostal;
    private         String              numero;
    private         String              nom;
    private         String              prenom;
    private         String              pays;
    private         String              rue;
    private         String              ville;
    private         String              newEmail;
    private         String              newEmailVerif;
    private         String              pseudo;
    private         Abonne              abonne;
    private         Employe             employe;

    /**
     * Méthode pour connecter l'abonné.
     * @return
     */
    public String doLogin() throws Exception {

        String vResult = ActionSupport.ERROR;

        if (identifiant != null) {
            abonne = microServiceAbonneProxy.getAbonnePseudo(identifiant);
            if (abonne == null) {
                abonne = microServiceAbonneProxy.getAbonneEmail(identifiant);
                if(abonne == null){
                    employe = microServiceEmployeProxy.findByEmail(identifiant);
                }
            }
        }
        if (abonne == null && employe == null) {
            this.addActionMessage("Identifiant invalide");
            vResult = ActionSupport.ERROR;
        } else {
            if (employe != null){
                if (motDePasse.equals(employe.getMotDePasse())) {
                    this.session.put("admin", employe);
                    this.session.put("pseudo", employe.getEmail());
                    this.session.put("role", employe.getRole());
                    categorieList = microServiceCategorieProxy.getListCategorie();
                    vResult = ActionSupport.SUCCESS;
                }else {
                    this.addActionMessage("Mot de passe invalide");
                    vResult = ActionSupport.ERROR;
                }
            }else if(abonne != null) {
                if (motDePasse.equals(abonne.getMotDePasse())) {
                    this.session.put("user", abonne);
                    this.session.put("pseudo", abonne.getPseudo());
                    this.session.put("role", abonne.getRole());
                    categorieList = microServiceCategorieProxy.getListCategorie();
                    vResult = ActionSupport.SUCCESS;
                } else {
                    this.addActionMessage("Mot de passe invalide");
                    vResult = ActionSupport.ERROR;
                }
            }
        }

        return vResult ;
    }

    /**
     * Méthode pour déconnecter l'abonné.
     * @return
     */
    public String doLogout(){

        this.session.remove("admin");
        this.session.remove("user");
        this.session.remove("pseudo");
        this.session.remove("role");
        categorieList = microServiceCategorieProxy.getListCategorie();

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour afficher le profil de l'abonné
     * @return
     */
    public String doProfil(){

        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        profilInfo(abonne);

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour changer le mot de passe de l'abonné.
     * @return
     */
    public String doChangeMdp() throws Exception {

        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        if(newMdp.equals(newMdpVerif)){
            abonne.setMotDePasse(newMdp);
            microServiceAbonneProxy.updateAbonne(abonne);
            this.addActionMessage("Mot de passe modifié");
            logger.info("Mot de passe de l'abonné : "+abonne.getPseudo()+" modifié");
        }
        profilInfo(abonne);

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour changer l'adresse de l'abonné
     * Si aucune adresse pour cet abonné alors on créé un nouvelle adresse.
     * Si l'abonné possédait déjà une adresse on modifie celle-ci.
     * @return
     */
    public String doChangeAdresse(){

        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        Adresse adresse = new Adresse();
        if(abonne.getAdresseId() == null){
            adresse.setCodePostal(codePostal);
            adresse.setNumero(numero);
            adresse.setPays(pays);
            adresse.setRue(rue);
            adresse.setVille(ville);
            microServiceAdresseProxy.addAdresse(adresse);
            logger.info("Adresse pour l'abonné : "+abonne.getPseudo()+" ajoutée à la bdd");
        }else {
            adresse = microServiceAdresseProxy.getAdresse(abonne.getAdresseId());
            adresse.setRue(rue);
            adresse.setVille(ville);
            adresse.setCodePostal(codePostal);
            adresse.setNumero(numero);
            adresse.setPays(pays);
            microServiceAdresseProxy.updateAdresse(adresse);
            logger.info("Adresse de l'abonné : "+abonne.getPseudo()+" modifié");
        }
        adresse = microServiceAdresseProxy.getAdresseAll(codePostal,numero,rue,pays,ville);
        abonne.setAdresseId(adresse.getId());
        abonne.setAdresse(microServiceAdresseProxy.getAdresse(abonne.getAdresseId()));
        microServiceAbonneProxy.updateAbonne(abonne);
        this.addActionMessage("Adresse modifié");

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour changer l'adresse électronique de l'abonné.
     * @return
     */
    public String doChangeEmail(){

        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        if (newEmail.equals(newEmailVerif)){
            if (microServiceAbonneProxy.getAbonneEmail(newEmail) == null) {
                abonne.setEmail(newEmail);
                microServiceAbonneProxy.updateAbonne(abonne);
                this.addActionMessage("Adresse électronique modifié");
                logger.info("Adresse électronique de l'abonné : "+abonne.getPseudo()+" modifié");
            }else {
                this.addActionMessage("Adresse électronique déjà utilisée");
            }
        }
        profilInfo(abonne);

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour modifié l'adresse favorite de l'abonné
     * @return
     */
    public String doChangeBibliothequeFavorite(){

        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        if(bibliotheque != null) {
            Integer bibliothequeId = Integer.parseInt(bibliotheque);
            abonne.setBibliothequeId(bibliothequeId);
            microServiceAbonneProxy.updateAbonne(abonne);
            this.addActionMessage("Bibliothèque favorite modifié");
            logger.info("Bibliothèque favorite de l'abonné : "+abonne.getPseudo()+" modifié");
        }
        profilInfo(abonne);

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour retoruner à la page les informations de l'abonne
     * @param abonne
     */
    public void profilInfo(Abonne abonne){
        if (abonne.getAdresseId() != null) {
            abonne.setAdresse(microServiceAdresseProxy.getAdresse(abonne.getAdresseId()));
        }
        abonne.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(abonne.getBibliothequeId()));
        bibliothequeList = microServiceBibliothequeProxy.findAll();
        for(Bibliotheque bibliotheque:bibliothequeList){
            if(bibliotheque.getAdresseId() != null) {
                bibliotheque.setAdresse(microServiceAdresseProxy.getAdresse(bibliotheque.getAdresseId()));
            }
        }
    }

    /**
     * Méthode pour afficher le formulaire d'inscription
     * @return
     */
    public String pageIncription(){

        bibliothequeList = microServiceBibliothequeProxy.findAll();

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode qui gère l'inscription de l'utilsateur
     * Si la vérification du mot de passe est bonne
     * Ainsi que si le pseudo et l'adresse mail ne sont pas utilisés
     * Le compte est crée dans la bdd
     * @return
     */
    public String doInscription() throws Exception {

        String vResult;

        if(newMdp.equals(newMdpVerif)){
            if (microServiceAbonneProxy.getAbonneEmail(newEmail) == null && microServiceEmployeProxy.findByEmail(newEmail) == null) {
                if (microServiceAbonneProxy.getAbonnePseudo(pseudo) == null) {
                    Abonne abonne = new Abonne();
                    abonne.setPseudo(pseudo);
                    abonne.setMotDePasse(newMdp);
                    abonne.setMotDePasse(newMdp);
                    abonne.setEmail(newEmail);
                    abonne.setNom(nom);
                    abonne.setPrenom(prenom);
                    abonne.setNumeroTelephone(numero);
                    abonne.setBibliothequeId(Integer.parseInt(bibliotheque));
                    abonne.setRoleId(1);
                    microServiceAbonneProxy.addAbonne(abonne);
                    categorieList = microServiceCategorieProxy.getListCategorie();
                    logger.info("Nouveau compte abonné : : "+abonne.getPseudo()+" ajouté à la bdd");
                    vResult = ActionSupport.SUCCESS;
                }else {
                    vResult = ActionSupport.ERROR;
                    bibliothequeList = microServiceBibliothequeProxy.findAll();
                    this.addActionMessage("Pseudo déjà utilisé");
                }
            }else {
                vResult = ActionSupport.ERROR;
                bibliothequeList = microServiceBibliothequeProxy.findAll();
                this.addActionMessage("Adresse électronique déjà utilisée");
            }
        }else {
            vResult = ActionSupport.ERROR;
            bibliothequeList = microServiceBibliothequeProxy.findAll();
            this.addActionMessage("Mot de passe non identique");
        }
        return vResult;
    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Bibliotheque> getBibliothequeList() {
        return bibliothequeList;
    }

    public void setBibliothequeList(List<Bibliotheque> bibliothequeList) {
        this.bibliothequeList = bibliothequeList;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNewMdp() {
        return newMdp;
    }

    public void setNewMdp(String newMdp) {
        this.newMdp = newMdp;
    }

    public String getNewMdpVerif() {
        return newMdpVerif;
    }

    public void setNewMdpVerif(String newMdpVerif) {
        this.newMdpVerif = newMdpVerif;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewEmailVerif() {
        return newEmailVerif;
    }

    public void setNewEmailVerif(String newEmailVerif) {
        this.newEmailVerif = newEmailVerif;
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

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
