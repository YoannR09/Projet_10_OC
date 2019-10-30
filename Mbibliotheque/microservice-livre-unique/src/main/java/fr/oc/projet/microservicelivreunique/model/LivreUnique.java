package fr.oc.projet.microservicelivreunique.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LivreUnique {

    @Id
    @GeneratedValue
    private int id;

    private int numero;

    private int bibliothequeId;

    private int livreId;

    private Boolean disponible;

    private Boolean sousReserve;

    public LivreUnique() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(int bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public int getLivreId() {
        return livreId;
    }

    public void setLivreId(int livreId) {
        this.livreId = livreId;
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
