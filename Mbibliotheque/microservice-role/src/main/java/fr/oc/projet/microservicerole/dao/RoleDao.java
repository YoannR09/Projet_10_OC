package fr.oc.projet.microservicerole.dao;

import fr.oc.projet.microservicerole.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {

    Role findById(int id);

}
