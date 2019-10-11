package fr.oc.projet.model.beans.bibliotheque;

public class Illustration {

    private String description;
    private String url;
    private String typeIllustration;
    private Integer id;

    public Illustration() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeIllustration() {
        return typeIllustration;
    }

    public void setTypeIllustration(String typeIllustration) {
        this.typeIllustration = typeIllustration;
    }
}
