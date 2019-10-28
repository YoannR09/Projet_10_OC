package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.*;
import fr.oc.projet.bibliothequeclient.mail.MailReservation;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe qui gère la restitution d'un prêt en cours
 */
@Component
public class RestituerAction extends ActionSupport {

    private         Pret                pret;
    private         int                 pretId;
    private         int                 bibliothequeId;
    private         int                 livreUniqueId;
    private         int                 livreId;
    private         int                 reservationId;
    private         List<Pret>          pretList;
    private         List<Categorie>     categorieList;
    private         List<Reservation>   list;
    private         String              bibliotheque;
    private         String              numero;
    private         String              isbn;
    private Abonne abonne;

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    MicroServiceBibliothequeProxy microServiceBibliothequeProxy;
    @Autowired
    MicroServicePretProxy microServicePretProxy;
    @Autowired
    MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;
    @Autowired
    MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    MicroServiceCategorieProxy microServiceCategorieProxy;
    @Autowired
    MicroServiceReservationProxy microServiceReservationProxy;


    /**
     * Méthode pour rechercher des prêt en cours
     * en fonction du texte entré dans le formulaire.
     * @return
     */
    public String doRechercheRestituerPret(){
        Boolean isNumber = null;
        if (!numero.equals("")) {
            try {
                 int y = (int) Integer.valueOf(numero);
                 isNumber = true;
            } catch (NumberFormatException e) {
                isNumber = false;
            }
        }
        if (isNumber == null){
            isNumber = true;
        }
        if (isNumber != false) {
            if (!bibliotheque.equals("Toutes les bibliothèques")) {
                bibliothequeId = microServiceBibliothequeProxy.findByNom(bibliotheque).getId();
                if (!isbn.equals("") && !numero.equals("")) {
                    pretList = microServicePretProxy.getListPretLivreISBNNumInterneBibliotheque(isbn,numero,bibliothequeId);
                } else if (!isbn.equals("") && numero.equals("")) {
                    pretList = microServicePretProxy.getListPretLivreISBNBibliotheque(isbn,bibliothequeId);
                } else if (isbn.equals("") && !numero.equals("")) {
                    pretList = microServicePretProxy.getListPretLivreNumInterneBibliotheque(numero,bibliothequeId);
                }
            } else {
                if (!isbn.equals("") && !numero.equals("")) {
                    pretList = microServicePretProxy.getListPretLivreISBNNumInterne(isbn,numero);
                } else if (!isbn.equals("") && numero.equals("")) {
                    pretList = microServicePretProxy.getListPretLivreISBN(isbn);
                } else if (isbn.equals("") && !numero.equals("")) {
                    pretList = microServicePretProxy.getListPretLivreNumInterne(numero);
                }
            }
            if (pretList != null) {
                if (pretList.size() == 0){
                    this.addActionMessage("Aucun prêt trouvé");
                }
                for(Pret pret : pretList){
                    pret.setAbonne(microServiceAbonneProxy.getAbonne(pret.getAbonneId()));
                    pret.setLivreUnique(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()));
                    pret.getLivreUnique().setLivre(microServiceLivreProxy.getLivre(pret.getLivreUnique().getLivreId()));
                    pret.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(pret.getLivreUnique().getBibliothequeId()));
                }
            } else {
                this.addActionMessage("Aucun prêt trouvé");
            }
        }else {
            this.addActionMessage("Le numéro interne doit être un nombre");
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode qui gère la restition d'un prêt en cours.
     * @return
     */
    public String doRestitutionPret(){
        String vResult;
        try {
        pret = microServicePretProxy.getPret(pretId);
        microServicePretProxy.delete(pretId);
        this.addActionMessage("Livre restitué, ce livre est maintenant disponible pour un nouveau prêt.");
        logger.info("Livre restitué à l'inventaire");
        categorieList = microServiceCategorieProxy.getListCategorie();
        infoReservation();
        vResult = ActionSupport.SUCCESS;
        }catch (Exception e){
            vResult = ActionSupport.ERROR;
            this.addActionMessage("Erreur");
            logger.error(e);
        }
        return vResult;
    }

    public void infoReservation() throws IOException {
        pret.setLivreUnique(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()));
        pret.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(pret.getLivreUnique().getBibliothequeId()));
        pret.setLivre(microServiceLivreProxy.getLivre(pret.getLivreUnique().getLivreId()));
        LivreUnique livreUnique = pret.getLivreUnique();
        List<Reservation> vList = microServiceReservationProxy
                .findByBibliothequeIdAndLivreId(pret.getBibliotheque().getId(),pret.getLivre().getId());
        if(vList.size() != 0){
            livreUnique.setSousReserve(true);
            microServiceLivreUniqueProxy.updateDispo(livreUnique);
            MailReservation mailReservation = new MailReservation(microServiceAbonneProxy,
                    microServiceReservationProxy,microServiceLivreUniqueProxy,microServiceLivreProxy,microServiceBibliothequeProxy);
            mailReservation.gestionMail(vList,livreUnique);
        }else {
            pret.getLivreUnique().setDisponible(true);
            pret.getLivreUnique().setSousReserve(false);
            microServiceLivreUniqueProxy.updateDispo(pret.getLivreUnique());
        }
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    public int getPretId() {
        return pretId;
    }

    public void setPretId(int pretId) {
        this.pretId = pretId;
    }

    public int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public List<Pret> getPretList() {
        return pretList;
    }

    public void setPretList(List<Pret> pretList) {
        this.pretList = pretList;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(int livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }
}
