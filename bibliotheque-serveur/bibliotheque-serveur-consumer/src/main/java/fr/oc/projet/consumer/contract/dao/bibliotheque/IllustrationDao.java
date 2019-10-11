package fr.oc.projet.consumer.contract.dao.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Illustration;

import java.util.List;

public interface IllustrationDao {

    Illustration getIllustration(Integer pId);

    List<Illustration> getListIllustration();

}
