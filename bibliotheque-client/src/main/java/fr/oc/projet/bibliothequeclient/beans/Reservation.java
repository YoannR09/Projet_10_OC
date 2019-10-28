package fr.oc.projet.bibliothequeclient.beans;


public class Reservation {

    private int id;
    private int abonneId;
    private int livreId;
    private int bibliothequeId;
    private Integer livreUniqueId;
    private Abonne abonne;
    private Livre livre;
    private Bibliotheque bibliotheque;
    private String retour;
    private String dureeEstime;
    private int position;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(int abonneId) {
        this.abonneId = abonneId;
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

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Integer getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(Integer livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
    }

    public String getRetour() {
        return retour;
    }

    public void setRetour(String retour) {
        this.retour = retour;
    }

    public String getDureeEstime() {
        return dureeEstime;
    }

    public void setDureeEstime(String dureeEstime) {
        this.dureeEstime = dureeEstime;
    }
}
