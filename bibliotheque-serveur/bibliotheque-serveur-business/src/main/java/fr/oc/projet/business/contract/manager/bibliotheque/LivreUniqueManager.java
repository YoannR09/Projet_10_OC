package fr.oc.projet.business.contract.manager.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import java.util.List;


public interface LivreUniqueManager {
    LivreUnique getLivreUnique(Integer pId);

    List<LivreUnique> getListLivreUniqueTitreAuteurISBN(String titre, String auteur, String isbn);

    List<LivreUnique> getListLivreUniqueTitreAuteur(String titre,String auteur);

    List<LivreUnique> getListLivreUniqueAuteurISBN(String auteur,String isbn);

    List<LivreUnique> getListLivreUniqueTitreISBN(String titre,String isbn);

    List<LivreUnique> getListLivreUniqueTitre(String titre);

    List<LivreUnique> getListLivreUniqueAuteur(String auteur);

    List<LivreUnique> getListLivreUniqueISBN(String isbn);

    List<LivreUnique> getListLivreUniqueTitreAuteurISBNBibliotheque(String titre, String auteur, String isbn, Integer bibliothequeId);

    List<LivreUnique> getListLivreUniqueTitreAuteurBibliotheque(String titre,String auteur, Integer bibliothequeId);

    List<LivreUnique> getListLivreUniqueAuteurISBNBibliotheque(String auteur,String isbn, Integer bibliothequeId);

    List<LivreUnique> getListLivreUniqueTitreISBNBibliotheque(String titre,String isbn, Integer bibliothequeId);

    List<LivreUnique> getListLivreUniqueTitreBibliotheque(String titre, Integer bibliothequeId);

    List<LivreUnique> getListLivreUniqueAuteurBibliotheque(String auteur, Integer bibliothequeId);

    List<LivreUnique> getListLivreUniqueISBNBibliotheque(String isbn, Integer bibliothequeId);

    List<LivreUnique> getListLivreUnique();

    void updateDispo(LivreUnique livreUnique);
}
