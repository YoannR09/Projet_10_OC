package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.*;
import fr.oc.projet.bibliothequeclient.proxies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe qui gère le catalogue de livre.
 * Permet de faire des recherches de livres via plusieurs critères.
 */
@Component
public class GestionLivreAction extends ActionSupport {

    @Autowired
    private MicroServiceLivreProxy microServiceLivreProxy;
    @Autowired
    private MicroServiceLivreUniqueProxy microServiceLivreUniqueProxy;
    @Autowired
    private MicroServiceIllustrationProxy microServiceIllustrationProxy;
    @Autowired
    private MicroServiceCategorieProxy microServiceCategorieProxy;
    @Autowired
    private MicroServiceAbonneProxy microServiceAbonneProxy;
    @Autowired
    private MicroServiceBibliothequeProxy microServiceBibliothequeProxy;

    private             String                      titre;
    private             String                      auteur;
    private             String                      isbn;
    private             String                      recherche;
    private             String                      categorieSelect;
    private             String                      pseudo;
    private             String                      bibliotheque;
    private             Integer                     livreId;
    private             Integer                     countResultat;
    private             Integer                     categorieId;
    private             List<Livre>                 livreList;
    private             Livre                       livre;
    private             Abonne                      abonne;
    private             Illustration                illustration;
    private             Categorie                   categorie;
    private             List<Categorie>             categorieList;
    private             HashMap<Livre,Integer>      livreIntegerHashMap;

    /**
     * Méthode qui gère la recherche de livre
     * On recherche un livre en fonction des informations rentrées
     * par le visiteur.
     * @return
     */
    public String doListLivre(){

        if(!categorieSelect.equals("Toutes les catégories")){
            categorie = microServiceCategorieProxy.findByNom(categorieSelect);
        }else {
            categorie = null;
        }
        if(!titre.equals("") && !auteur.equals("") && !isbn.equals("") && categorie == null){
            livreList = microServiceLivreProxy.findLivresByTitreAndAuteurAndIsbn(titre,auteur,isbn);
        }else if (titre.equals("") && !auteur.equals("") && !isbn.equals("") && categorie == null){
            livreList = microServiceLivreProxy.findLivresByAuteurContainingAndIsbnContaining(auteur,isbn);
        }else if (!titre.equals("") && !auteur.equals("") && isbn.equals("") && categorie == null){
            livreList = microServiceLivreProxy.findLivresByTitreContainingAndAuteurContaining(titre,auteur);
        }else if (!titre.equals("") && auteur.equals("") && !isbn.equals("") && categorie == null){
            livreList = microServiceLivreProxy.findLivresByTitreContainingAndIsbnContaining(titre,isbn);
        }else if (!titre.equals("") && auteur.equals("") && isbn.equals("") && categorie == null){
            livreList = microServiceLivreProxy.findLivresByTitreContaining(titre);
        }else if (titre.equals("") && !auteur.equals("") && isbn.equals("") && categorie == null){
            livreList = microServiceLivreProxy.findLivresByAuteurContaining(auteur);
        }else if (titre.equals("") && auteur.equals("") && !isbn.equals("") && categorie == null){
            livreList = microServiceLivreProxy.findLivresByIsbnContaining(isbn);
        }else if(!titre.equals("") && !auteur.equals("") && !isbn.equals("") && categorie != null){
            livreList = microServiceLivreProxy.findLivresByTitreAndAuteurAndIsbnAndCategorieId(titre,auteur,isbn,categorie.getId());
        }else if (titre.equals("") && !auteur.equals("") && !isbn.equals("") && categorie != null){
            livreList = microServiceLivreProxy.findLivresByAuteurContainingAndIsbnContainingAndCategorieId(auteur,isbn,categorie.getId());
        }else if (!titre.equals("") && !auteur.equals("") && isbn.equals("") && categorie != null){
            livreList = microServiceLivreProxy.findLivresByTitreContainingAndAuteurContainingAndCategorieId(titre,auteur,categorie.getId());
        }else if (!titre.equals("") && auteur.equals("") && !isbn.equals("") && categorie != null){
            livreList = microServiceLivreProxy.findLivresByTitreContainingAndIsbnContainingAndCategorieId(titre,isbn,categorie.getId());
        }else if (!titre.equals("") && auteur.equals("") && isbn.equals("") && categorie != null){
            livreList = microServiceLivreProxy.findLivresByTitreContainingAndCategorieId(titre,categorie.getId());
        }else if (titre.equals("") && !auteur.equals("") && isbn.equals("") && categorie != null){
            livreList = microServiceLivreProxy.findLivresByAuteurContainingAndCategorieId(auteur,categorie.getId());
        }else if (titre.equals("") && auteur.equals("") && !isbn.equals("") && categorie != null) {
            livreList = microServiceLivreProxy.findLivresByIsbnContainingAndCategorieId(isbn, categorie.getId());
        }else if(titre.equals("") && auteur.equals("") && isbn.equals("") && categorie != null){
            livreList = microServiceLivreProxy.findLivreByCategorieId(categorie.getId());
        }
        if(livreList != null) {
            for (Livre livre : livreList) {
                if (recherche.equals("option2")) {
                    livre.setNbreDispo(microServiceLivreUniqueProxy.countLivreUniqueDisponible(livre.getId()));
                } else {
                    pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
                    abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
                    livre.setNbreDispo(microServiceLivreUniqueProxy.countLivreUniqueBibliothequeDisponible(livre.getId(), abonne.getBibliothequeId()));
                }
            }
            if (recherche.equals("option2")) {
                bibliotheque = "Toutes les bibliothèques";
            } else {
                pseudo = (String) ActionContext.getContext().getSession().get("pseudo");
                abonne = microServiceAbonneProxy.getAbonnePseudo(pseudo);
                bibliotheque = microServiceBibliothequeProxy.getBibliotheque(abonne.getBibliothequeId()).getNom();
            }
            countResultat = livreList.size();
        }else {
            this.addActionMessage(" Aucun livre trouvé");
            countResultat = 0;
        }
        categorieList = microServiceCategorieProxy.getListCategorie();

        return Action.SUCCESS;
    }

    /**
     * Méthode pour récupèrer la liste des catégories.
     * @return
     */
    public String doCatalogueLivre(){

        categorieList = microServiceCategorieProxy.getListCategorie();

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour effcetuer une recherche de livre via une catègorie
     * séléctionné depuis la page d'acceuil.
     * @return
     */
    public String doListLivreCategorie(){

        livreList = microServiceLivreProxy.findLivreByCategorieId(categorieId);
        for (Livre livre : livreList) {
                livre.setNbreDispo(microServiceLivreUniqueProxy.countLivreUniqueDisponible(livre.getId()));
        }
        categorieSelect = microServiceCategorieProxy.getCategorie(categorieId).getNom();
        bibliotheque = "Toutes les bibliothèques";
        countResultat = livreList.size();
        categorieList = microServiceCategorieProxy.getListCategorie();

        return ActionSupport.SUCCESS;
    }

    /**
     * Méthode pour afficher les détails d'un livre.
     * @return
     */
    public String doDetailLivre(){

        livre = microServiceLivreProxy.getLivre(livreId);
        categorie = microServiceCategorieProxy.getCategorie(livre.getCategorieId());
        illustration = microServiceIllustrationProxy.getIllustration(livre.getIllustrationId());

        livreList = new ArrayList<>();
        for (int i = 1; i<4 ; i++){
            livreList.add(microServiceLivreProxy.getLivre(livreId));
            livreList.get(i-1).setNbreDispo(microServiceLivreUniqueProxy.countLivreUniqueBibliothequeDisponible(livre.getId(),i));
        }

        return Action.SUCCESS;
    }


    public HashMap<Livre, Integer> getLivreIntegerHashMap() {
        return livreIntegerHashMap;
    }

    public void setLivreIntegerHashMap(HashMap<Livre, Integer> livreIntegerHashMap) {
        this.livreIntegerHashMap = livreIntegerHashMap;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Livre> getLivreList() {
        return livreList;
    }

    public void setLivreList(List<Livre> livreList) {
        this.livreList = livreList;
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

    public Illustration getIllustration() {
        return illustration;
    }

    public void setIllustration(Illustration illustration) {
        this.illustration = illustration;
    }

    public String getRecherche() {
        return recherche;
    }

    public void setRecherche(String recherche) {
        this.recherche = recherche;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getCountResultat() {
        return countResultat;
    }

    public void setCountResultat(Integer countResultat) {
        this.countResultat = countResultat;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }

    public String getCategorieSelect() {
        return categorieSelect;
    }

    public void setCategorieSelect(String categorieSelect) {
        this.categorieSelect = categorieSelect;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getBibliotheque() {
        return bibliotheque;
    }

    public void setBibliotheque(String bibliotheque) {
        this.bibliotheque = bibliotheque;
    }

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

}
