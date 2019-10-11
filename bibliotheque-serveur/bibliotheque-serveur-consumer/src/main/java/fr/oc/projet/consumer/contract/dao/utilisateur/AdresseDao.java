package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Adresse;

public interface AdresseDao {
    Adresse getAdresse(Integer pId);
}
