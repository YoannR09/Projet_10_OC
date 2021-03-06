package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Livre;

import java.util.List;

public interface LivreDao {

    Livre getLivre(Integer pId);

    Livre getLivreTitreAuteurISBN(String titre,String auteur,String isbn);

    Livre getLivreTitreAuteur(String titre,String auteur);

    Livre getLivreAuteurISBN(String auteur,String isbn);

    Livre getLivreTitreISBN(String titre,String isbn);

    Livre getLivreTitre(String titre);

    Livre getLivreAuteur(String auteur);

    Livre getLivreISBN(String isbn);

    List<Livre> getListLivre();

}
