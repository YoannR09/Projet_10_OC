package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Employe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Classe pour récupèrer les données du MicroServiceEmploye
 */
@FeignClient(value = "microservice-employe", url = "192.168.1.61:9087")
public interface MicroServiceEmployeProxy {

    /**
     * Méthode pour récupérer un employé via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Employe/Id/{id}")
    Employe findById(@PathVariable int id);

    /**
     * Méthode pour récupérer un employé via une adresse électronnique
     * @param email
     * @return
     */
    @GetMapping(value = "/Employe/Email/{email}")
    Employe findByEmail(@PathVariable("email") String email);
}
