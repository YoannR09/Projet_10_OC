package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.CategorieManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.Categorie;

import javax.inject.Named;
import java.util.List;

@Named
public class CategorieManagerImpl extends AbstractManagerImpl implements CategorieManager {
    @Override
    public Categorie getCategorie(Integer pId) {
        return getDaoFactory().getCategorieDao().getCategorie(pId);
    }

    @Override
    public List<Categorie> getListCategorie() {
        return getDaoFactory().getCategorieDao().getListCategorie();
    }
}
