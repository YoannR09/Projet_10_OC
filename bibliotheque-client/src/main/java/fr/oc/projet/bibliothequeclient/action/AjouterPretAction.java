package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.*;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Classe qui gère l'ajout d'un prêt par un employé
 */
public class AjouterPretAction extends ActionSupport {

    private         String              isbn;
    private         String              auteur;
    private         String              titre;
    private         String              bibliotheque;
    private         String              email;
    private         String              pseudo;
    private         String              nom;
    private         String              prenom;
    private         Integer             bibliothequeId;
    private         Integer             livreUniqueId;
    private         Integer             abonneId;
    private         Integer             countResultat;
    private         Livre               livre;
    private         Abonne              abonne;
    private         List<LivreUnique>   livreUniqueList;
    private         List<Abonne>        abonneList;
    private         List<Categorie>     categorieList;

    private         Properties propConfig = new Properties();
    private         FileInputStream propFile ;

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;
    @Autowired
    MicroServiceBibliothequeProxy microServiceBibliothequeProxy;
    @Autowired
    MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    MicroServicePretProxy microServicePretProxy;
    @Autowired
    MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    MicroServiceCategorieProxy microServiceCategorieProxy;



    /**
     * Méthode qui affiche une liste de livre unique
     * en fonction du texte entré dans le formulaire.
     * @return
     */
    public String doListLivre() {
        String vResult;
            if (bibliotheque.equals("Toutes les bibliothèques")) {
                if (!isbn.equals("") && !auteur.equals("") && !titre.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitreAuteurISBN(titre,auteur,isbn);
                } else if (!isbn.equals("") && !auteur.equals("") && titre.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueAuteurISBN(auteur,isbn);
                } else if (!auteur.equals("") && !titre.equals("") && isbn.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitreAuteur(titre,auteur);
                } else if (!isbn.equals("") && !titre.equals("") && auteur.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitreISBN(titre,isbn);
                } else if (!isbn.equals("") && titre.equals("") && auteur.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueISBN(isbn);
                } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueAuteur(auteur);
                } else if (!titre.equals("") && auteur.equals("") && isbn.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitre(titre);
                }
            } else {
                bibliothequeId = microServiceBibliothequeProxy.findByNom(bibliotheque).getId();
                if (!isbn.equals("") && !auteur.equals("") && !titre.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitreAuteurISBNBibliotheque(titre,auteur,isbn,bibliothequeId);
                } else if (!isbn.equals("") && !auteur.equals("") && titre.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueAuteurISBNBibliotheque(auteur,isbn,bibliothequeId);
                } else if (!auteur.equals("") && !titre.equals("") && isbn.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitreAuteurBibliotheque(titre,auteur,bibliothequeId);
                } else if (!isbn.equals("") && !titre.equals("") && auteur.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitreISBNBibliotheque(titre,isbn,bibliothequeId);
                } else if (!isbn.equals("") && titre.equals("") && auteur.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueISBNBibliotheque(isbn,bibliothequeId);
                } else if (!auteur.equals("") && titre.equals("") && isbn.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueAuteurBibliotheque(auteur,bibliothequeId);
                } else if (!titre.equals("") && auteur.equals("") && isbn.equals("")) {
                    livreUniqueList = microServiceLivreUniqueProxy.getListLivreUniqueTitreBibliotheque(titre,bibliothequeId);
                }
            }
            if(livreUniqueList != null){
                if (livreUniqueList.size() == 0){
                    this.addActionMessage("Aucun livre trouvé");
                }
                for (LivreUnique livreUnique:livreUniqueList){
                    livreUnique.setLivre(microServiceLivreProxy.getLivre(livreUnique.getLivreId()));
                    livreUnique.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(livreUnique.getBibliothequeId()));
                }
                vResult = ActionSupport.SUCCESS;
                countResultat = livreUniqueList.size();
            }else {
                this.addActionMessage("Aucun livre trouvé");
                vResult = ActionSupport.SUCCESS;
            }
            return vResult;
        }

    /**
     * Méthode pour afficher le formulaire de sélection d'abonné
     * @return
     */
    public String doSelectionAbonne(){
        return ActionSupport.SUCCESS;
        }

    /**
     * Méthode qui affiche une liste d'abonne
     * en fonction du texte entré dans le formulaire
     * @return
     */
    public String doAbonne(){
        String vResult;
            if(!pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")){
                abonneList = microServiceAbonneProxy.findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(pseudo,email,nom,prenom);
            }else if (!prenom.equals("") && pseudo.equals("") && nom.equals("") && email.equals("")){
                abonneList = microServiceAbonneProxy.findByPrenom(prenom);
            }else if (!pseudo.equals("") && !email.equals("") && !nom.equals("") && prenom.equals("")){
                abonneList = microServiceAbonneProxy.findByPseudoContainingAndEmailContainingAndNomContaining(pseudo,email,nom);
            }else if (!pseudo.equals("") && !email.equals("") && !prenom.equals("") && nom.equals("")){
                abonneList = microServiceAbonneProxy.findByPseudoContainingAndEmailContainingAndPrenomContaining(pseudo,email,prenom);
            }else if (!pseudo.equals("") && !nom.equals("") && !prenom.equals("") && email.equals("")){
                abonneList = microServiceAbonneProxy.findByPseudoContainingAndNomContainingAndPrenomContaining(pseudo,nom,prenom);
            }else if (pseudo.equals("") && !email.equals("") && !nom.equals("") && !prenom.equals("")){
                abonneList = microServiceAbonneProxy.findByEmailContainingAndNomContainingAndPrenomContaining(email,nom,prenom);
            }else if (!pseudo.equals("") && !email.equals("") && prenom.equals("") && nom.equals("") ){
                abonneList = microServiceAbonneProxy.findByPseudoContainingAndEmailContaining(pseudo,email);
            }else if (!nom.equals("") && !prenom.equals("") && pseudo.equals("") && email.equals("")){
                abonneList = microServiceAbonneProxy.findByNomContainingAndPrenomContaining(nom,prenom);
            }else if(!email.equals("") && !nom.equals("") && pseudo.equals("") && prenom.equals("")){
                abonneList = microServiceAbonneProxy.findByEmailContainingAndNomContaining(email,nom);
            }else if(!email.equals("") && !prenom.equals("") && nom.equals("") && pseudo.equals("")){
                abonneList = microServiceAbonneProxy.findByEmailContainingAndPrenomContaining(email,prenom);
            }else if(!pseudo.equals("") && !nom.equals("") && email.equals("") && prenom.equals("")){
                abonneList = microServiceAbonneProxy.findByPseudoContainingAndNomContaining(pseudo,nom);
            }else if(!pseudo.equals("") && nom.equals("") && email.equals("") && prenom.equals("")){
                abonneList = microServiceAbonneProxy.getListByPseudo(pseudo);
            }else if(!email.equals("") && nom.equals("") && pseudo.equals("") && prenom.equals("")){
                abonneList = microServiceAbonneProxy.getListByEmail(email);
            }else if (!pseudo.equals("") && !prenom.equals("") && email.equals("") && nom.equals("")){
                abonneList = microServiceAbonneProxy.findByPrenom(prenom);
            }else if (!nom.equals("") && pseudo.equals("") && prenom.equals("") && email.equals("")){
                abonneList = microServiceAbonneProxy.findByNom(nom);
            }
            if (abonneList != null){
                vResult = ActionSupport.SUCCESS;
            }else {
                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("Aucun abonné trouvé");
            }
        return vResult;
        }

    /**
     * Méthode pour ajouter un prêt pour un abonné
     * @return
     */
    public String doAjouterPret(){
        String vResult;
        try {
        propFile = new FileInputStream("C:/Users/Pierrosan/Documents/Projet_7_OC/resources/config.properties");
        propConfig.load(propFile);
        Pret pret = new Pret();
        pret.setDateEmprunt(new Date());
        Calendar cal = Calendar.getInstance();
        cal.setTime(pret.getDateEmprunt());
        cal.add(Calendar.DATE,Integer.parseInt(propConfig.getProperty("prolongation")));
        pret.setDateRestitution(cal.getTime());
        pret.setProlongation(false);
        pret.setLivreUniqueId(livreUniqueId);
        pret.setAbonneId(abonneId);
        LivreUnique livreUnique = microServiceLivreUniqueProxy.findById(livreUniqueId);
        livreUnique.setDisponible(false);
        microServiceLivreUniqueProxy.updateDispo(livreUnique);
        microServicePretProxy.addPret(pret);
        categorieList = microServiceCategorieProxy.getListCategorie();

        this.addActionMessage("Nouveau prêt ajouté ");
        logger.info("Prêt bien ajouté à la bdd");
        vResult = ActionSupport.SUCCESS;
        }catch (Exception e){
            logger. error(e);
            this.addActionMessage(" Problème survenu pendant l'ajout du prêt");
            vResult = ActionSupport.ERROR;
        }
        return vResult;
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

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Integer getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(Integer bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public List<LivreUnique> getLivreUniqueList() {
        return livreUniqueList;
    }

    public void setLivreUniqueList(List<LivreUnique> livreUniqueList) {
        this.livreUniqueList = livreUniqueList;
    }

    public Integer getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(Integer livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
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

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Integer getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(Integer abonneId) {
        this.abonneId = abonneId;
    }

    public Integer getCountResultat() {
        return countResultat;
    }

    public void setCountResultat(Integer countResultat) {
        this.countResultat = countResultat;
    }

    public List<Abonne> getAbonneList() {
        return abonneList;
    }

    public void setAbonneList(List<Abonne> abonneList) {
        this.abonneList = abonneList;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }
}

