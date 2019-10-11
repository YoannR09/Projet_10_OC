package fr.oc.projet.business.contract.manager.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Illustration;

import java.util.List;

public interface IllustrationManager {

    Illustration getIllustration(Integer pId);

    List<Illustration> getListIllustration();

}
