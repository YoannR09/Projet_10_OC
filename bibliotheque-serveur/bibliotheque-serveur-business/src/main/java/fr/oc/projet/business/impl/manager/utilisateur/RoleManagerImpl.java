package fr.oc.projet.business.impl.manager.utilisateur;

import fr.oc.projet.business.contract.manager.utilisateur.RoleManager;
import fr.oc.projet.business.impl.manager.AbstractManagerImpl;
import fr.oc.projet.model.beans.utilisateur.Role;

import javax.inject.Named;
import java.util.List;

@Named
public class RoleManagerImpl extends AbstractManagerImpl implements RoleManager {

    @Override
    public Role getRole(Integer pId) {
        return getDaoFactory().getRoleDao().getRole(pId);
    }

    @Override
    public List<Role> getListRole() {
        return getDaoFactory().getRoleDao().getListRole();
    }
}
