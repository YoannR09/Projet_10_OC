package fr.oc.projet.bibliothequeclient.action;

import com.opensymphony.xwork2.ActionSupport;
import fr.oc.projet.bibliothequeclient.beans.Categorie;
import fr.oc.projet.bibliothequeclient.proxies.MicroServiceCategorieProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Classe qui gère la page d'acceuil.
 */
@Component
public class GestionIndexAction extends ActionSupport {

    private Categorie categorie;
    private List<Categorie> categorieList;

    @Autowired
    private MicroServiceCategorieProxy microServiceCategorieProxy;

    /**
     * Affichage de la page d'acceuil
     * La liste des catégories s'affiche.
     * @return
     */
    public String execute(){

        categorieList = microServiceCategorieProxy.getListCategorie();

        return ActionSupport.SUCCESS;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Categorie> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Categorie> categorieList) {
        this.categorieList = categorieList;
    }
}
