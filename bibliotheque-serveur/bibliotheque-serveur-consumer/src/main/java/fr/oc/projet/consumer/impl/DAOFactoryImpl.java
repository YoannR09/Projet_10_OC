package fr.oc.projet.consumer.impl;

import fr.oc.projet.consumer.contract.DAOFactory;
import fr.oc.projet.consumer.contract.dao.bibliotheque.*;
import fr.oc.projet.consumer.contract.dao.utilisateur.*;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactoryImpl")
public class DAOFactoryImpl implements DAOFactory {

    @Inject
    private RoleDao roleDao;
    @Inject
    private AbonneDao abonneDao;
    @Inject
    private BibliothequeDao bibliothequeDao;
    @Inject
    private CategorieDao categorieDao;
    @Inject
    private IllustrationDao illustrationDao;
    @Inject
    private LivreDao livreDao;
    @Inject
    private PretDao pretDao;
    @Inject
    private AdresseDao adresseDao;
    @Inject
    private LivreUniqueDao livreUniqueDao;
    @Inject
    private EmployeDao employeDao;



    @Override
    public RoleDao getRoleDao() {
        return this.roleDao;
    }

    @Override
    public AbonneDao getAbonneDao() {
        return this.abonneDao;
    }

    @Override
    public BibliothequeDao getBibliotheque() {
        return bibliothequeDao;
    }

    @Override
    public CategorieDao getCategorieDao() {
        return this.categorieDao;
    }

    @Override
    public IllustrationDao getIllustrationDao() {
        return this.illustrationDao;
    }

    @Override
    public LivreDao getLivreDao() {
        return this.livreDao;
    }

    @Override
    public PretDao getPretDao() {
        return this.pretDao;
    }

    @Override
    public AdresseDao getAdresseDao() {
        return this.adresseDao;
    }

    @Override
    public LivreUniqueDao getLivreUniqueDao() {
        return this.livreUniqueDao;
    }

    @Override
    public EmployeDao getEmployeDao() {
        return this.employeDao;
    }
}
