package fr.oc.projet.business.contract.manager.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Role;

import java.util.List;

public interface RoleManager {

    Role getRole(Integer pId);

    List<Role> getListRole();
}
