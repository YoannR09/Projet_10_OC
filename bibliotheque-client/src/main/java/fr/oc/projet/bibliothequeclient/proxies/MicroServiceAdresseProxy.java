package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Adresse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Classe pour récupèrer les données du MicroServiceAdresse
 */
@FeignClient(value = "microservice-adresse", url = "localhost:9095")
public interface MicroServiceAdresseProxy {


    /**
     * Méthode pour récupérer une adresse via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Adresse/{id}")
    Adresse getAdresse(@PathVariable int id);

    /**
     * Méthode pour ajouter une adresse
     * @param adresse
     */
    @PostMapping(value = "/Adresse")
    void addAdresse(@RequestBody Adresse adresse);

    /**
     * Méthode pour mettre à jour une adresse
     * @param adresse
     */
    @PutMapping(value = "/Adresse")
    void updateAdresse(@RequestBody Adresse adresse);

    /**
     * Méthode pour récupérer une adresse via un code postal, numero, rue, pays et ville
     * @param codePostal
     * @param numero
     * @param rue
     * @param pays
     * @param ville
     * @return
     */
    @GetMapping(value = "/Adresse/All/{codePostal},{numero},{rue},{pays},{ville}")
    Adresse getAdresseAll(@PathVariable("codePostal") String codePostal,@PathVariable("numero") String numero,@PathVariable("rue") String rue,@PathVariable("pays") String pays,@PathVariable("ville") String ville);

}
