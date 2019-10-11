package fr.oc.projet.microservicepret.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Pret {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private Date dateEmprunt;

    private Date dateRestitution;

    private Boolean prolongation;

    private int abonneId;

    private int livreUniqueId;

    public Pret() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAbonneId() {
        return abonneId;
    }

    public void setAbonneId(int abonneId) {
        this.abonneId = abonneId;
    }

    public int getLivreUniqueId() {
        return livreUniqueId;
    }

    public void setLivreUniqueId(int livreUniqueId) {
        this.livreUniqueId = livreUniqueId;
    }

    @Override
    public String toString() {
        return "Pret{" +
                "id=" + id +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRestitution=" + dateRestitution +
                ", prolongation=" + prolongation +
                ", abonneId=" + abonneId +
                ", livreUniqueId=" + livreUniqueId +
                '}';
    }
}
