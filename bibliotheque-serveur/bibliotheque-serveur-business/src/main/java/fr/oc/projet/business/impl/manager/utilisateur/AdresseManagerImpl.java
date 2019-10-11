package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.AdresseManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Adresse;

import javax.inject.Named;

@Named
public class AdresseManagerImpl extends AbstractManagerImpl implements AdresseManager {
    @Override
    public Adresse getAdresse(Integer pId) {
        return getDaoFactory().getAdresseDao().getAdresse(pId);
    }
}
