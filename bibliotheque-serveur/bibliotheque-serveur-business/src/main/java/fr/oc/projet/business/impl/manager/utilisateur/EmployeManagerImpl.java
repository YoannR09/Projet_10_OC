package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.EmployeManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Employe;

import javax.inject.Named;
import java.util.List;

@Named
public class EmployeManagerImpl extends AbstractManagerImpl implements EmployeManager {
    @Override
    public Employe getEmploye(Integer pId) {
        return getDaoFactory().getEmployeDao().getEmploye(pId);
    }

    @Override
    public Employe getEmployeEmail(String email) {
        return getDaoFactory().getEmployeDao().getEmployeEmail(email);
    }

    @Override
    public List<Employe> getListEmploye() {
        return getDaoFactory().getEmployeDao().getListEmploye();
    }
}
