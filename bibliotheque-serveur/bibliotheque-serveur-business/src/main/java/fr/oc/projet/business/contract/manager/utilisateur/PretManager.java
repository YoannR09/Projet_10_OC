package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Pret;

import java.util.List;

public interface PretManager {

    Pret getPret(Integer pId);

    List<Pret> getListPret();

    List<Pret> getListPretLivre(Integer livreId);

    List<Pret> getListPretAbonne(Integer abonneId);

    List<Pret> getListPretLivreBibliotheque(Integer livreId,Integer bibliothequeId);

    List<Pret> getListPretAbonneBibliotheque(Integer abonneId,Integer bibliothequeId);

    List<Pret> getListPretLivreISBNNumInterne(String isbn,String numInterne);

    List<Pret> getListPretLivreISBNNumInterneBibliotheque(String isbn,String numInterne,Integer bibliothequeId);

    List<Pret> getListPretLivreISBN(String isbn);

    List<Pret> getListPretLivreNumInterne(String numInterne);

    List<Pret> getListPretLivreISBNBibliotheque(String isbn,Integer bibliothequeId);

    List<Pret> getListPretLivreNumInterneBibliotheque(String numInterne,Integer bibliothequeId);

    void updateProlongation(Pret pret);

    void updateDateRestitution(Pret pret);

    void deletePret(Integer idPret);

    void addPret(Pret pret);
}
