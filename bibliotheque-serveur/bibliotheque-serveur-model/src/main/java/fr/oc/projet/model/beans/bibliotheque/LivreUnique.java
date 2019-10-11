package fr.oc.projet.model.beans.bibliotheque;


public class LivreUnique {

    private Integer id;
    private String numeroInterne;
    private Bibliotheque bibliotheque;
    private int bibliothequeId;
    private Livre livre;
    private Boolean disponible;

    public LivreUnique() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroInterne() {
        return numeroInterne;
    }

    public void setNumeroInterne(String numeroInterne) {
        this.numeroInterne = numeroInterne;
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

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }
}
