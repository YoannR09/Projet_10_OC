package fr.oc.projet.microserviceillustration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Illustration {

    @Id
    @GeneratedValue
    private int id;

    private String url;

    private String description;

    private String typeIllustration;

    public Illustration() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeIllustration() {
        return typeIllustration;
    }

    public void setTypeIllustration(String typeIllustration) {
        this.typeIllustration = typeIllustration;
    }
}
