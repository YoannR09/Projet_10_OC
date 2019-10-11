package fr.oc.projet.business.contract;

import fr.oc.projet.business.contract.manager.bibliotheque.*;
import fr.oc.projet.business.contract.manager.utilisateur.*;

public interface ManagerFactory {

    RoleManager getRoleManager();

    AbonneManager getAbonneManager();

    BibliothequeManager getBibliothequeManager();

    CategorieManager getCategorieManager();

    IllustrationManager getIllustrationManager();

    LivreManager getLivreManager();

    PretManager getPretManager();

    AdresseManager getAdresseManager();

    LivreUniqueManager getLivreUniqueManager();

    EmployeManager getEmployeManager();
}

