package fr.oc.projet.microservicebibliotheque.dao;

import fr.oc.projet.microservicebibliotheque.model.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BibliothequeDao extends JpaRepository<Bibliotheque,Integer> {
    Bibliotheque findById(int id);

    Bibliotheque findByNom(String nom);

    List<Bibliotheque> findAll();
}
