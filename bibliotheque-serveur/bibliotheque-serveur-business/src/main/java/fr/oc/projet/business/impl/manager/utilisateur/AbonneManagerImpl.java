package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.AbonneManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Abonne;

import javax.inject.Named;
import java.util.List;

@Named
public class AbonneManagerImpl extends AbstractManagerImpl implements AbonneManager {

    @Override
    public Abonne getAbonne(Integer pId) {
        return getDaoFactory().getAbonneDao().getAbonne(pId);
    }

    @Override
    public Abonne getAbonnePseudo(String pseudo) {
        return getDaoFactory().getAbonneDao().getAbonnePseudo(pseudo);
    }

    @Override
    public Abonne getAbonneEmail(String email) {
        return getDaoFactory().getAbonneDao().getAbonneEmail(email);
    }

    @Override
    public Abonne getAbonneNom(String nom) {
        return getDaoFactory().getAbonneDao().getAbonneNom(nom);
    }

    @Override
    public Abonne getAbonnePrenom(String prenom) {
        return getDaoFactory().getAbonneDao().getAbonnePrenom(prenom);
    }

    @Override
    public Abonne getAbonnePseudoEmailNomPrenom(String pseudo, String email, String nom, String prenom) {
        return getDaoFactory().getAbonneDao().getAbonnePseudoEmailNomPrenom(pseudo,email,nom,prenom);
    }

    @Override
    public Abonne getAbonnePseudoEmailNom(String pseudo, String email, String nom) {
        return getDaoFactory().getAbonneDao().getAbonnePseudoEmailNom(pseudo,email,nom);
    }

    @Override
    public Abonne getAbonnePseudoEmailPrenom(String pseudo, String email, String prenom) {
        return getDaoFactory().getAbonneDao().getAbonnePseudoEmailPrenom(pseudo,email,prenom);
    }

    @Override
    public Abonne getAbonnePseudoNomPrenom(String pseudo, String nom, String prenom) {
        return getDaoFactory().getAbonneDao().getAbonnePseudoNomPrenom(pseudo,nom,prenom);
    }

    @Override
    public Abonne getAbonneEmailNomPrenom(String email, String nom, String prenom) {
        return getDaoFactory().getAbonneDao().getAbonneEmailNomPrenom(email,nom,prenom);
    }

    @Override
    public Abonne getAbonnePseudoEmail(String pseudo, String email) {
        return getDaoFactory().getAbonneDao().getAbonnePseudoEmail(pseudo,email);
    }

    @Override
    public Abonne getAbonneNomPrenom(String nom, String prenom) {
        return getDaoFactory().getAbonneDao().getAbonneNomPrenom(nom,prenom);
    }

    @Override
    public Abonne getAbonnePseudoPrenom(String pseudo, String prenom) {
        return getDaoFactory().getAbonneDao().getAbonnePseudoPrenom(pseudo,prenom);
    }

    @Override
    public Abonne getAbonneEmailNom(String email, String nom) {
        return getDaoFactory().getAbonneDao().getAbonneEmailNom(email,nom);
    }

    @Override
    public Abonne getAbonneEmailPrenom(String email, String prenom) {
        return getDaoFactory().getAbonneDao().getAbonneEmailPrenom(email,prenom);
    }

    @Override
    public Abonne getAbonnePseudoNom(String pseudo, String nom) {
        return getDaoFactory().getAbonneDao().getAbonnePseudoNom(pseudo,nom);
    }

    @Override
    public List<Abonne> getListAbonne() {
        return getDaoFactory().getAbonneDao().getListAbonne();
    }

    @Override
    public void addAbonne(Abonne abonne) {
        getDaoFactory().getAbonneDao().addAbonne(abonne);
    }

    @Override
    public void updateMpd(Abonne abonne) {
        getDaoFactory().getAbonneDao().updateMpd(abonne);
    }

    @Override
    public void updateMail(Abonne abonne) {
        getDaoFactory().getAbonneDao().updateMail(abonne);
    }
}
