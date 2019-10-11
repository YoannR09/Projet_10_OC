package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Abonne;

import java.util.List;

public interface AbonneDao {

    Abonne getAbonne(Integer pId);

    Abonne getAbonnePseudo(String pseudo);

    Abonne getAbonneEmail(String email);

    Abonne getAbonneNom(String nom);

    Abonne getAbonnePrenom(String prenom);

    Abonne getAbonnePseudoEmailNomPrenom(String pseudo,String email,String nom,String prenom);

    Abonne getAbonnePseudoEmailNom(String pseudo,String email,String nom);

    Abonne getAbonnePseudoEmailPrenom(String pseudo,String email,String prenom);

    Abonne getAbonnePseudoNomPrenom(String pseudo,String nom,String prenom);

    Abonne getAbonneEmailNomPrenom(String email,String nom,String prenom);

    Abonne getAbonnePseudoEmail(String pseudo,String email);

    Abonne getAbonneNomPrenom(String nom, String prenom);

    Abonne getAbonnePseudoPrenom(String pseudo,String prenom);

    Abonne getAbonneEmailNom(String email,String nom);

    Abonne getAbonneEmailPrenom(String email,String prenom);

    Abonne getAbonnePseudoNom(String pseudo,String nom);

    void addAbonne(Abonne abonne);

    void updateMpd(Abonne abonne);

    void updateMail(Abonne abonne);

    List<Abonne> getListAbonne();
}
