package fr.oc.projet.business.impl.manager.bibliotheque;

import fr.oc.projet.business.contract.manager.bibliotheque.IllustrationManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.bibliotheque.Illustration;

import javax.inject.Named;
import java.util.List;

@Named
public class IllustrationManagerImpl extends AbstractManagerImpl implements IllustrationManager {
    @Override
    public Illustration getIllustration(Integer pId) {
        return getDaoFactory().getIllustrationDao().getIllustration(pId);
    }

    @Override
    public List<Illustration> getListIllustration() {
        return getDaoFactory().getIllustrationDao().getListIllustration();
    }
}
