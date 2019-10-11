package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Categorie;

import java.util.List;

public interface CategorieDao {

    Categorie getCategorie(Integer pId);

    List<Categorie> getListCategorie();
}
