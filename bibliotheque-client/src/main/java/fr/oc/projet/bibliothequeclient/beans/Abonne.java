package fr.oc.projet.bibliothequeclient.beans;

public class Abonne {

    private         Integer             id;
    private         String              pseudo;
    private         String              nom;
    private         String              prenom;
    private         String              email;
    private         String              numeroTelephone;
    private         String              motDePasse;
    private         Integer             adresseId;
    private         Integer             roleId;
    private         Integer             bibliothequeId;
    private         Adresse             adresse;
    private         Role                role;
    private         Bibliotheque        bibliotheque;

    public Abonne() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Bibliotheque getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Integer getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Integer adresseId) {
        this.adresseId = adresseId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getBibliothequeId() {
        return bibliothequeId;
    }

    public void setBibliothequeId(Integer bibliothequeId) {
        this.bibliothequeId = bibliothequeId;
    }
}
