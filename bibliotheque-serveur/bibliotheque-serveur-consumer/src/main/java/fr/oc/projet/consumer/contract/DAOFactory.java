package fr.oc.projet.consumer.contract;

import fr.oc.projet.consumer.contract.dao.bibliotheque.*;
import fr.oc.projet.consumer.contract.dao.utilisateur.*;

public interface DAOFactory {

    RoleDao getRoleDao();

    AbonneDao getAbonneDao();

    BibliothequeDao getBibliotheque();

    CategorieDao getCategorieDao();

    IllustrationDao getIllustrationDao();

    LivreDao getLivreDao();

    PretDao getPretDao();

    AdresseDao getAdresseDao();

    LivreUniqueDao getLivreUniqueDao();

    EmployeDao getEmployeDao();

}
