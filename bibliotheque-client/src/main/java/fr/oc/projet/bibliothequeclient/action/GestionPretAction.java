package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.Abonne;
import fr.oc.projet.bibliothequeclient.beans.Pret;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Classe qui permet la consultation de ses prêts à un abonné.
 * Il peut consulter ses prêts en cours et les prolonger si possible.
 */
@Component
public class GestionPretAction extends ActionSupport {

    @Autowired
    MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    MicroServicePretProxy microServicePretProxy;
    @Autowired
    MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;
    @Autowired
    MicroServiceBibliothequeProxy microServiceBibliothequeProxy;

    private static final Logger logger = LogManager.getLogger();

    private         String          pseudo;
    private         Abonne          abonne;
    private         List<Pret>      pretList;
    private         Integer         countResultat;
    private         Integer         pretId;
    private         Pret            pret;

    private Properties propConfig = new Properties();
    private FileInputStream propFile ;

    /**
     * Méthode pour afficher les prêts en cours de l'abonné
     * @return
     */
    public String doListPret(){
        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        recupListPret();
        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour prolongé un prêt si possible
     * Le délai de restitution ne doit pas être dépassé,
     * La prolongation est disponible une seule fois.
     * @return
     */
    public String doProlongationPret() {
        try {
           propFile = new FileInputStream("C:\\Users\\Pierrosan\\Documents\\Projet_7_OC\\resources\\config.properties");
            propConfig.load(propFile);
            pret = microServicePretProxy.getPret(pretId);
            Calendar cal = Calendar.getInstance();
            cal.setTime(pret.getDateRestitution());
            cal.add(Calendar.DATE, Integer.parseInt(propConfig.getProperty("prolongation")));
            pret.setDateRestitution(cal.getTime());
            pret.setProlongation(true);
            microServicePretProxy.updatePret(pret);
            pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
            abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
            recupListPret();
            this.addActionMessage("Prêt prolongé jusqu'au : " + pret.getDateRestitution());
            logger.info("Prêt prolongé. Pret id : " + pret.getId());
        }catch (Exception e){
            logger.error(e);
            this.addActionMessage("Porblème survenu pendant la prolongation du prêt");
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour récupèrer la liste de prêt d'un abonné.
     */
    public void recupListPret(){
        pretList = microServicePretProxy.getListPretAbonne(abonne.getId());
        for(Pret pret: pretList){
            pret.setLivreUnique(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()));
            pret.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()).getBibliothequeId()));
            pret.getLivreUnique().setLivre(microServiceLivreProxy.getLivre(pret.getLivreUnique().getLivreId()));
            if(pret.getDateRestitution().compareTo(new Date()) > 0) {
                pret.setExpire(false);
            }else {
                pret.setExpire(true);
            }
        }
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public List<Pret> getPretList() {
        return pretList;
    }

    public void setPretList(List<Pret> pretList) {
        this.pretList = pretList;
    }

    public Integer getCountResultat() {
        return countResultat;
    }

    public void setCountResultat(Integer countResultat) {
        this.countResultat = countResultat;
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
}
