package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.PretManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Pret;

import javax.inject.Named;
import java.util.List;

@Named
public class PretManagerImpl extends AbstractManagerImpl implements PretManager {


    @Override
    public Pret getPret(Integer pId) {
        return getDaoFactory().getPretDao().getPret(pId);
    }

    @Override
    public List<Pret> getListPret() {
        return getDaoFactory().getPretDao().getListPret();
    }

    @Override
    public List<Pret> getListPretLivre(Integer livreId) {
        return getDaoFactory().getPretDao().getListPretLivre(livreId);
    }

    @Override
    public List<Pret> getListPretAbonne(Integer abonneId) {
        return getDaoFactory().getPretDao().getListPretAbonne(abonneId);
    }

    @Override
    public List<Pret> getListPretLivreBibliotheque(Integer livreId, Integer bibliothequeId) {
        return getDaoFactory().getPretDao().getListPretLivreBibliotheque(livreId,bibliothequeId);
    }

    @Override
    public List<Pret> getListPretAbonneBibliotheque(Integer abonneId, Integer bibliothequeId) {
        return getDaoFactory().getPretDao().getListPretAbonneBibliotheque(abonneId,bibliothequeId);
    }

    @Override
    public List<Pret> getListPretLivreISBNNumInterne(String isbn, String numInterne) {
        return getDaoFactory().getPretDao().getListPretLivreISBNNumInterne(isbn,numInterne);
    }

    @Override
    public List<Pret> getListPretLivreISBNNumInterneBibliotheque(String isbn, String numInterne, Integer bibliothequeId) {
        return getDaoFactory().getPretDao().getListPretLivreISBNNumInterneBibliotheque(isbn,numInterne,bibliothequeId);
    }

    @Override
    public List<Pret> getListPretLivreISBN(String isbn) {
        return getDaoFactory().getPretDao().getListPretLivreISBN(isbn);
    }

    @Override
    public List<Pret> getListPretLivreNumInterne(String numInterne) {
        return getDaoFactory().getPretDao().getListPretLivreNumInterne(numInterne);
    }

    @Override
    public List<Pret> getListPretLivreISBNBibliotheque(String isbn, Integer bibliothequeId) {
        return getDaoFactory().getPretDao().getListPretLivreISBNBibliotheque(isbn,bibliothequeId);
    }

    @Override
    public List<Pret> getListPretLivreNumInterneBibliotheque(String numInterne, Integer bibliothequeId) {
        return getDaoFactory().getPretDao().getListPretLivreNumInterneBibliotheque(numInterne,bibliothequeId);
    }

    @Override
    public void updateProlongation(Pret pret) {
        getDaoFactory().getPretDao().updateProlongation(pret);
    }

    @Override
    public void updateDateRestitution(Pret pret) {
        getDaoFactory().getPretDao().updateDateRestitution(pret);
    }

    @Override
    public void deletePret(Integer idPret) {
        getDaoFactory().getPretDao().deletePret(idPret);
    }

    @Override
    public void addPret(Pret pret) {
        getDaoFactory().getPretDao().addPret(pret);
    }
}
