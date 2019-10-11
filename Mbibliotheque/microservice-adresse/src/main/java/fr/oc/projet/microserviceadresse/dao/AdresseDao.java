package fr.oc.projet.microserviceadresse.dao;

import fr.oc.projet.microserviceadresse.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseDao extends JpaRepository<Adresse,Integer> {

    Adresse findById(int id);

    Adresse findByCodePostalAndNumeroAndRueAndPaysAndVille(String codePostal, String numero, String rue, String pays, String ville);
}
