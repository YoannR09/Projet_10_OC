package fr.oc.projet.business.impl.manager;

import fr.oc.projet.consumer.contract.DAOFactory;

public class AbstractManagerImpl {

    private static DAOFactory daoFactory;

    public static DAOFactory getDaoFactory() {
        return daoFactory;
    }

    public static  void setDaoFactory(DAOFactory pDAOFactory){
        daoFactory = pDAOFactory;
    }

}
