package fr.oc.projet.microserviceemploye.dao;

import fr.oc.projet.microserviceemploye.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe,Integer> {

    Employe findById(int id);

    Employe findByEmail(String email);
}
