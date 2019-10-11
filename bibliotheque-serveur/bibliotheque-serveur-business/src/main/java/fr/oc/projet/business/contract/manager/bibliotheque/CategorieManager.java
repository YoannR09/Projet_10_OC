package fr.oc.projet.business.contract.manager.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Categorie;

import java.util.List;

public interface CategorieManager {

    Categorie getCategorie(Integer pId);
    List<Categorie> getListCategorie();

}
