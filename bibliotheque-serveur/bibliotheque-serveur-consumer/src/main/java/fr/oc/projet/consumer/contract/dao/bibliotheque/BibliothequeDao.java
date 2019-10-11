package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;

import java.util.List;

public interface BibliothequeDao {

    Bibliotheque getBibliotheque(Integer pId);
    Bibliotheque getBibliothequeNom(String nom);
    List<Bibliotheque> getListBibliotheque();

}
