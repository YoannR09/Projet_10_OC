package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.BibliothequeManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;

import javax.inject.Named;
import java.util.List;

@Named
public class BibliothequeManagerImpl extends AbstractManagerImpl implements BibliothequeManager {


    @Override
    public Bibliotheque getBibliotheque(Integer pId) {
        return getDaoFactory().getBibliotheque().getBibliotheque(pId);
    }

    @Override
    public Bibliotheque getBibliothequeNom(String nom) {
        return getDaoFactory().getBibliotheque().getBibliothequeNom(nom);
    }

    @Override
    public List<Bibliotheque> getListBibliotheque() {
        return getDaoFactory().getBibliotheque().getListBibliotheque();
    }
}
