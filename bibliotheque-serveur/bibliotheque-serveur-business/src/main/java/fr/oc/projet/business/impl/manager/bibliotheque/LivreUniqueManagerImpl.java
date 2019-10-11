package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.LivreUniqueManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import javax.inject.Named;
import java.util.List;

@Named
public class LivreUniqueManagerImpl extends AbstractManagerImpl implements LivreUniqueManager {

    @Override
    public LivreUnique getLivreUnique(Integer pId) {
        return getDaoFactory().getLivreUniqueDao().getLivreUnique(pId);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteurISBN(String titre, String auteur, String isbn) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitreAuteurISBN(titre,auteur,isbn);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteur(String titre, String auteur) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitreAuteur(titre,auteur);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteurISBN(String auteur, String isbn) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueAuteurISBN(auteur,isbn);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreISBN(String titre, String isbn) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitreISBN(titre,isbn);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitre(String titre) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitre(titre);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteur(String auteur) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueAuteur(auteur);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueISBN(String isbn) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueISBN(isbn);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteurISBNBibliotheque(String titre, String auteur, String isbn, Integer bibliothequeId) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitreAuteurISBNBibliotheque(titre,auteur,isbn,bibliothequeId);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreAuteurBibliotheque(String titre, String auteur, Integer bibliothequeId) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitreAuteurBibliotheque(titre,auteur,bibliothequeId);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteurISBNBibliotheque(String auteur, String isbn, Integer bibliothequeId) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueAuteurISBNBibliotheque(auteur,isbn,bibliothequeId);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreISBNBibliotheque(String titre, String isbn, Integer bibliothequeId) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitreISBNBibliotheque(titre,isbn,bibliothequeId);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueTitreBibliotheque(String titre, Integer bibliothequeId) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueTitreBibliotheque(titre,bibliothequeId);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueAuteurBibliotheque(String auteur, Integer bibliothequeId) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueAuteurBibliotheque(auteur,bibliothequeId);
    }

    @Override
    public List<LivreUnique> getListLivreUniqueISBNBibliotheque(String isbn, Integer bibliothequeId) {
        return getDaoFactory().getLivreUniqueDao().getListLivreUniqueISBNBibliotheque(isbn,bibliothequeId);
    }

    @Override
    public List<LivreUnique> getListLivreUnique() {
        return getDaoFactory().getLivreUniqueDao().getListLivreUnique();
    }

    @Override
    public void updateDispo(LivreUnique livreUnique) {
        getDaoFactory().getLivreUniqueDao().updateDispo(livreUnique);
    }
}
