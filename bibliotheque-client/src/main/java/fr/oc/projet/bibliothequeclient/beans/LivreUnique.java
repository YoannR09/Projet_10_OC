package fr.oc.projet.bibliothequeclient.beans;


public class LivreUnique {

    private Integer id;
    private Integer numero;
    private Integer bibliothequeId;
    private Integer livreId;
    private Livre livre;
    private Bibliotheque bibliotheque;
    private Boolean disponible;
    private Boolean sousReserve;

    public LivreUnique() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(Integer bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public Integer getLivreId() {
        return livreId;
    }

    public void setLivreId(Integer livreId) {
        this.livreId = livreId;
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

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Boolean getSousReserve() {
        return sousReserve;
    }

    public void setSousReserve(Boolean sousReserve) {
        this.sousReserve = sousReserve;
    }
}
