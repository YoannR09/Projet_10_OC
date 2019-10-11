package fr.oc.projet.business.impl;

import fr.oc.projet.business.contract.ManagerFactory;
import fr.oc.projet.business.contract.manager.bibliotheque.*;
import fr.oc.projet.business.contract.manager.utilisateur.*;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private RoleManager roleManager;
    @Inject
    private AbonneManager abonneManager;
    @Inject
    private CategorieManager categorieManager;
    @Inject
    private IllustrationManager illustrationManager;
    @Inject
    private LivreManager livreManager;
    @Inject
    private PretManager pretManager;
    @Inject
    private BibliothequeManager bibliothequeManager;
    @Inject
    private AdresseManager adresseManager;
    @Inject
    private LivreUniqueManager livreUniqueManager;
    @Inject
    private EmployeManager employeManager;

    @Override
    public RoleManager getRoleManager() {
        return this.roleManager;
    }

    @Override
    public AbonneManager getAbonneManager() {
        return this.abonneManager;
    }

    @Override
    public BibliothequeManager getBibliothequeManager() {
        return this.bibliothequeManager;
    }

    @Override
    public CategorieManager getCategorieManager() {
        return this.categorieManager;
    }

    @Override
    public IllustrationManager getIllustrationManager() {
        return this.illustrationManager;
    }

    @Override
    public LivreManager getLivreManager() {
        return this.livreManager;
    }

    @Override
    public PretManager getPretManager() {
        return this.pretManager;
    }

    @Override
    public AdresseManager getAdresseManager() {
        return this.adresseManager;
    }

    @Override
    public LivreUniqueManager getLivreUniqueManager() {
        return this.livreUniqueManager;
    }

    @Override
    public EmployeManager getEmployeManager() {
        return this.employeManager;
    }

}
