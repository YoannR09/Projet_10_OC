package fr.oc.projet.consumer.contract.dao.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Role;

import java.util.List;

public interface RoleDao {

    Role getRole(Integer pId);

    List<Role> getListRole();
}
