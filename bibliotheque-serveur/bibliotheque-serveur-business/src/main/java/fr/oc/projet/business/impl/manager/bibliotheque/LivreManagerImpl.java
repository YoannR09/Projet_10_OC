package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.LivreManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.Livre;

import javax.inject.Named;
import java.util.List;

@Named
public class LivreManagerImpl extends AbstractManagerImpl implements LivreManager {
    @Override
    public Livre getLivre(Integer pId) {
        return getDaoFactory().getLivreDao().getLivre(pId);
    }

    @Override
    public Livre getLivreTitreAuteurISBN(String titre, String auteur, String isbn) {
        return getDaoFactory().getLivreDao().getLivreTitreAuteurISBN(titre,auteur,isbn);
    }

    @Override
    public Livre getLivreTitreAuteur(String titre, String auteur) {
        return getDaoFactory().getLivreDao().getLivreTitreAuteur(titre,auteur);
    }

    @Override
    public Livre getLivreAuteurISBN(String auteur, String isbn) {
        return getDaoFactory().getLivreDao().getLivreAuteurISBN(auteur,isbn);
    }

    @Override
    public Livre getLivreTitreISBN(String titre, String isbn) {
        return getDaoFactory().getLivreDao().getLivreTitreISBN(titre,isbn);
    }

    @Override
    public Livre getLivreTitre(String titre) {
        return getDaoFactory().getLivreDao().getLivreTitre(titre);
    }

    @Override
    public Livre getLivreAuteur(String auteur) {
        return getDaoFactory().getLivreDao().getLivreAuteur(auteur);
    }

    @Override
    public Livre getLivreISBN(String isbn) {
        return getDaoFactory().getLivreDao().getLivreISBN(isbn);
    }

    @Override
    public List<Livre> getListLivre() {
        return getDaoFactory().getLivreDao().getListLivre();
    }
}
