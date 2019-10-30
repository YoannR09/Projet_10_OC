package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.*;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Classe qui gère l'ajout d'une réservation et la consultation de réservation en cours de l'abonné.
 */
public class ReservationAction extends ActionSupport {

    @Autowired
    MicroServiceReservationProxy microServiceReservationProxy;
    @Autowired
    MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    MicroServiceBibliothequeProxy microServiceBibliothequeProxy;
    @Autowired
    MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;
    @Autowired
    MicroServicePretProxy microServicePretProxy;
    @Autowired
    MicroServiceCategorieProxy microServiceCategorieProxy;

    private         float                   diffDate;
    private         int                     livreId;
    private         int                     bibliothequeId;
    private         int                     abonneId;
    private         int                     livreUniqueId;
    private         int                     reservationId;
    private         int                     nbreFile;
    private         String                  duree;
    private         String                  pseudo;
    private         String                  email;
    private         String                  prenom;
    private         String                  nom;
    private         Abonne                  abonne;
    private         List<Reservation>       listResa;
    private         List<Reservation>       listResaDispo;
    private         List<Reservation>       listResaNonDispo;
    private         List<LivreUnique>       listLivreUnique;
    private         List<Abonne>            abonneList;
    private         List<Categorie>         categorieList;
    private         List<Pret>              pretList;

    private Properties propConfig = new Properties();
    private FileInputStream propFile ;


    /**
     * Méthode pour ajouter une réservation dans la bdd.
     * @return
     */
    public String doReservation(){
        String result = ActionSupport.SUCCESS;
        try {
            Reservation resa = new Reservation();
            pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
            abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
            resa.setAbonneId(abonne.getId());
            resa.setLivreId(livreId);
            resa.setBibliothequeId(bibliothequeId);
            microServiceReservationProxy.addReservation(resa);
            getListResaByAbonneId(abonne);
        }catch (Exception e){
            result = ActionSupport.ERROR;
        }
        return result;
    }

    /**
     * Méthode pour afficher la liste des réservation en cours de l'abonné.
     * @return
     */
    public String doListResa(){
        pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
        abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
        getListResaByAbonneId(abonne);
        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour suppimer une réservation depuis la liste d'un abonné.
     * @return
     */
    public String doDeleteResa(){
        String result = ActionSupport.SUCCESS;
        try {
            Reservation resa = microServiceReservationProxy.getReservation(reservationId);
            if(resa.getLivreUniqueId() != null){
                LivreUnique lu = microServiceLivreUniqueProxy.findById(resa.getLivreUniqueId());
                lu.setSousReserve(false);
                lu.setDisponible(true);
                microServiceLivreUniqueProxy.updateDispo(lu);
            }
            microServiceReservationProxy.delete(reservationId);
            pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
            abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
            getListResaByAbonneId(abonne);
        }catch (Exception e){
            result = ActionSupport.ERROR;
        }
        return result;
    }

    /**
     * Méthode pour générer la liste des réservation de l'abonne via son id.
     * La position dans la file est fixé à partir de la position récupérer
     * dans une de réservation trié par l'id le plus petit en premier.
     * @param abonne
     */
    private void getListResaByAbonneId(Abonne abonne) {
        listResa = microServiceReservationProxy.findByAbonneId(abonne.getId());
        int posi = 0;
        for(Reservation res : listResa){
            List<Reservation> listPosi = microServiceReservationProxy
                    .findByBibliothequeIdAndLivreId(res.getBibliothequeId(),res.getLivreId());
            for(Reservation resaPosi : listPosi){
                posi++;
                if (resaPosi.getAbonneId() == res.getAbonneId()){
                    res.setPosition(posi);
                }
            }
            HashMap<Float,Integer> listDiff = new HashMap<>();
            List<Float> listDiffOrdre = new ArrayList<>();
            pretList = microServicePretProxy.getListPretLivreBibliotheque(res.getLivreId(),res.getBibliothequeId());
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            for(Pret pret: pretList){
                try{
                    Date newDate = sdf.parse(sdf.format(new Date()));
                    long diff = pret.getDateRestitution().getTime() - newDate.getTime();
                    float resTemps = (diff / (1000*60*60*26));
                    listDiffOrdre.add(resTemps);
                    listDiff.put(resTemps,pret.getId());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            Collections.sort(listDiffOrdre);
            ValueComparator comparator = new ValueComparator(listDiff);
            TreeMap<Float,Integer> mapTriee = new TreeMap<>(comparator);
            mapTriee.putAll(listDiff);
            Pret pretFirst = microServicePretProxy.getPret(mapTriee.lastEntry().getValue());
            String prochainRetour = sdf.format(pretFirst.getDateRestitution());
            res.setRetour(prochainRetour);
            if(res.getPosition() > pretList.size()){
                res.setDureeEstime("plus de 3 mois");
            }else {
                res.setDureeEstime(String.format("%.0f",listDiffOrdre.get(res.getPosition()-1))+" jour(s)");
            }
            res.setBibliotheque(microServiceBibliothequeProxy.getBibliotheque(res.getBibliothequeId()));
            res.setLivre(microServiceLivreProxy.getLivre(res.getLivreId()));
        }
    }

    /**
     *
     * @return
     */
    public String doListReservationDispo(){
        String result = ActionSupport.SUCCESS;
        getListResaByAbonneId(microServiceAbonneProxy.getAbonne(abonneId));
        listResaDispo = new ArrayList<>();
        listResaNonDispo = new ArrayList<>();
        for (Reservation res : listResa) {
            if (res.getLivreUniqueId() != null){
                listResaDispo.add(res);
            }else {
                listResaNonDispo.add(res);
            }
        }
        return result;
    }

    public String doResaToPret() throws IOException {
        String result = ActionSupport.SUCCESS;
        propFile = new FileInputStream("C:/Users/El-ra/Documents/Projet_10_OC/resources/config.properties");
        propConfig.load(propFile);
        Pret pret = new Pret();
        Calendar cal = Calendar.getInstance();
        pret.setDateEmprunt(new Date());
        cal.setTime(pret.getDateEmprunt());
        cal.add(Calendar.DATE,Integer.parseInt(propConfig.getProperty("prolongation")));
        pret.setProlongation(false);
        pret.setDateRestitution(cal.getTime());
        pret.setAbonneId(abonneId);
        pret.setLivreUniqueId(livreUniqueId);
        LivreUnique livreUnique = microServiceLivreUniqueProxy.findById(livreUniqueId);
        livreUnique.setDisponible(false);
        livreUnique.setSousReserve(false);
        microServiceLivreUniqueProxy.updateDispo(livreUnique);
        microServicePretProxy.addPret(pret);
        microServiceReservationProxy.delete(reservationId);
        this.addActionMessage(" La prêt de la réservation pour le livre : "+
                microServiceLivreProxy.getLivre(livreUnique.getLivreId())+
                ", pour l'abonne : "+microServiceAbonneProxy.getAbonne(abonneId).getPseudo()+
                " à commencé");
        categorieList = microServiceCategorieProxy.getListCategorie();
        return result;
    }

    public String editResa(){
        String result =  ActionSupport.SUCCESS;
        HashMap<Float,Integer> listDiff = new HashMap<>();
        List<Float> listDiffOrdre = new ArrayList<>();
        pretList = microServicePretProxy.getListPretLivreBibliotheque(livreId,bibliothequeId);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        for(Pret pret: pretList){
            pret.setLivreUnique(microServiceLivreUniqueProxy.findById(pret.getLivreUniqueId()));
            try{
                Date newDate = sdf.parse(sdf.format(new Date()));
                long diff = pret.getDateRestitution().getTime() - newDate.getTime();
                float res = (diff / (1000*60*60*26));
                listDiff.put(res,pret.getId());
                listDiffOrdre.add(res);
            }catch (Exception e){
                e.printStackTrace();
                result = ActionSupport.ERROR;
            }
        }
        nbreFile = microServiceReservationProxy.countReservationsByLivreIdAndBibliothequeId(livreId,bibliothequeId);
        ValueComparator comparator = new ValueComparator(listDiff);
        TreeMap<Float,Integer> mapTriee = new TreeMap<>(comparator);
        Collections.sort(listDiffOrdre);
        mapTriee.putAll(listDiff);
        if(nbreFile >= pretList.size()){
            duree = "plus de 3 mois";
        }else {
            duree = String.format("%.0f",listDiffOrdre.get(nbreFile))+" jour(s)";
        }
        try {
            Pret pretFirst = microServicePretProxy.getPret(mapTriee.lastEntry().getValue());

        for (Pret pret:pretList){
            if (pret.getId()==pretFirst.getId()){
                pret.setPlusTot(true);
            }
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public int getLivreId() {
        return livreId;
    }

    public void setLivreId(int livreId) {
        this.livreId = livreId;
    }

    public int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
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

    public List<Reservation> getListResa() {
        return listResa;
    }

    public void setListResa(List<Reservation> listResa) {
        this.listResa = listResa;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }



    public int getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(int abonneId) {
        this.abonneId = abonneId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<LivreUnique> getListLivreUnique() {
        return listLivreUnique;
    }

    public void setListLivreUnique(List<LivreUnique> listLivreUnique) {
        this.listLivreUnique = listLivreUnique;
    }

    public List<Abonne> getAbonneList() {
        return abonneList;
    }

    public void setAbonneList(List<Abonne> abonneList) {
        this.abonneList = abonneList;
    }

    public int getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(int livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
    }

    public List<Reservation> getListResaDispo() {
        return listResaDispo;
    }

    public void setListResaDispo(List<Reservation> listResaDispo) {
        this.listResaDispo = listResaDispo;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    public List<Reservation> getListResaNonDispo() {
        return listResaNonDispo;
    }

    public void setListResaNonDispo(List<Reservation> listResaNonDispo) {
        this.listResaNonDispo = listResaNonDispo;
    }

    public float getDiffDate() {
        return diffDate;
    }

    public void setDiffDate(float diffDate) {
        this.diffDate = diffDate;
    }

    public int getNbreFile() {
        return nbreFile;
    }

    public void setNbreFile(int nbreFile) {
        this.nbreFile = nbreFile;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public List<Pret> getPretList() {
        return pretList;
    }

    public void setPretList(List<Pret> pretList) {
        this.pretList = pretList;
    }

    class ValueComparator implements Comparator<Float> {
        Map<Float,Integer> base;

        public ValueComparator(Map<Float,Integer> base){
            this.base = base;
        }

        public int compare(Float a,Float b){
            if (base.get(a) >= base.get(b)){
                return -1;
            }else return 1;
        }
    }
}

