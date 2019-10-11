package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Categorie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Classe pour récupèrer les données du MicroServiceCategorie
 */
@FeignClient(value = "microservice-categorie", url = "localhost:9090")
public interface MicroServiceCategorieProxy {

    /**
     * MLéthode pour récupérer une catégorie via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Categorie/{id}")
    Categorie getCategorie(@PathVariable("id") int id);

    /**
     * Méthode pour récupérer une catégorie via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Categorie/Nom/{nom}")
    Categorie findByNom(@PathVariable("nom") String nom);

    /**
     * Méthode pour récupérer la liste des catégories
     * @return
     */
    @GetMapping(value = "/Categorie")
    List<Categorie> getListCategorie();
}
