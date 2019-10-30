package fr.oc.projet.microservicereservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Integer abonneId;
    private Integer livreId;
    private Integer bibliothequeId;
    private Integer livreUniqueId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(Integer abonneId) {
        this.abonneId = abonneId;
    }

    public Integer getLivreId() {
        return livreId;
    }

    public void setLivreId(Integer livreId) {
        this.livreId = livreId;
    }

    public Integer getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(Integer bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }

    public Integer getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(Integer livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
    }
}
