package fr.oc.projet.bibliothequeclient.beans;

import java.util.Date;

public class Pret {

    private         Integer         id;
    private         Date            dateEmprunt;
    private         Date            dateRestitution;
    private         Boolean         prolongation;
    private         Bibliotheque    bibliotheque;
    private         LivreUnique     livreUnique;
    private         Abonne          abonne;
    private         Integer         abonneId;
    private         Livre           livre;
    private         Integer         livreUniqueId;
    private         Boolean         expire;
    private         Boolean         plusTot;

    public Pret() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(Date dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    public Boolean getProlongation() {
        return prolongation;
    }

    public void setProlongation(Boolean prolongation) {
        this.prolongation = prolongation;
    }

    public LivreUnique getLivreUnique() {
        return livreUnique;
    }

    public void setLivreUnique(LivreUnique livreUnique) {
        this.livreUnique = livreUnique;
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

    public Integer getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(Integer livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
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

    public Boolean getExpire() {
        return expire;
    }

    public void setExpire(Boolean expire) {
        this.expire = expire;
    }

    public Boolean getPlusTot() {
        return plusTot;
    }

    public void setPlusTot(Boolean plusTot) {
        this.plusTot = plusTot;
    }
}
