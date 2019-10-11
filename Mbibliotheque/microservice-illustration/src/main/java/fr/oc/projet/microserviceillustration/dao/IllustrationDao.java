package fr.oc.projet.microserviceillustration.dao;

import fr.oc.projet.microserviceillustration.model.Illustration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllustrationDao extends JpaRepository<Illustration,Integer> {
    Illustration findById(int id);
}
