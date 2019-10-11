package fr.oc.projet.microservicebibliotheque.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bibliotheque {

    @Id
    @GeneratedValue
    private int id;

    private String nom;

    private String numeroSiret;

    private int adresseId;

    public Bibliotheque() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumeroSiret() {
        return numeroSiret;
    }

    public void setNumeroSiret(String numeroSiret) {
        this.numeroSiret = numeroSiret;
    }

    public int getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(int adresseId) {
        this.adresseId = adresseId;
    }

}
