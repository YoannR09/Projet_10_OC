package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Bibliotheque;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Classe pour récupèrer les données du MicroServiceBibliotheque
 */
@FeignClient(value = "microservice-bibliotheque", url = "192.168.1.61:9096")
public interface MicroServiceBibliothequeProxy {

    /**
     * Méthode pour récupérer une bibliotheque via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Bibliotheque/Id/{id}")
    Bibliotheque getBibliotheque(@PathVariable("id") int id);

    /**
     * Méthode pour récupérer une bibliotheque via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Bibliotheque/Nom/{nom}")
    Bibliotheque findByNom(@PathVariable("nom") String nom);

    /**
     * Méthode pour récupérer une liste de bibliotheque
     * @return
     */
    @GetMapping(value = "/Bibliotheque")
    List<Bibliotheque> findAll();


}
