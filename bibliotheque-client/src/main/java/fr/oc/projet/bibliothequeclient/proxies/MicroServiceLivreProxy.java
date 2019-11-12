package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Livre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/**
 * Classe pour récupèrer les données du MicroServiceLivre
 */
@FeignClient(name = "microservice-livre", url = "localhost:9094")
public interface MicroServiceLivreProxy {

    /**
     * Méthode pour récupérer un livre via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Livre/{id}")
    Livre getLivre(@PathVariable("id") int id);

    /**
     * Méthode pour récupérer une liste de livre via l'id d'une catégorie
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/Categorie/{categorieId}")
    List<Livre> findLivreByCategorieId(@PathVariable("categorieId") int categorieId);

    /**
     * Méthode pour récupérer une liste via un titre, auteur et code isbn
     * @param titre
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteurISBN/{titre},{auteur},{isbn}")
    List<Livre> findLivresByTitreAndAuteurAndIsbn(@PathVariable("titre") String titre, @PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn );


    /**
     * Méthode pour récupérer une liste de livre via auteur et code isbn
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/AuteurISBN/{auteur},{isbn}")
    List<Livre> findLivresByAuteurContainingAndIsbnContaining(@PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn);


    /**
     * Méthode pour récupérer une liste de livre via un titre et un code isbn
     * @param titre
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/TitreISBN/{titre},{isbn}")
    List<Livre> findLivresByTitreContainingAndIsbnContaining(@PathVariable("titre") String titre,@PathVariable("isbn") String isbn );

    /**
     * Méthode pour récupèrer une liste de livre via un titre et auteur
     * @param titre
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteur/{titre},{auteur}")
    List<Livre> findLivresByTitreContainingAndAuteurContaining(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur);

    /**
     * Méthode pour récupérer une liste de livre via un titre
     * @param titre
     * @return
     */
    @GetMapping(value = "/Livre/Titre/{titre}")
     List<Livre> findLivresByTitreContaining(@PathVariable("titre") String titre);

    /**
     * Méthode pour récupérer une liste de livre via un auteur
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Livre/Auteur/{auteur}")
    List<Livre> findLivresByAuteurContaining(@PathVariable("auteur") String auteur);

    /**
     * Méthode pour récupérer une liste de livre via un code isbn
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/ISBN/{isbn}")
    List<Livre> findLivresByIsbnContaining(@PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupérer une liste de titre via un titre, auteur, isbn et l'id d'une catégorie
     * @param titre
     * @param auteur
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteurISBNCategorie/{titre},{auteur},{isbn},{categorieId}")
    List<Livre> findLivresByTitreAndAuteurAndIsbnAndCategorieId(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId);

    /**
     * Méthode pour récupérer une liste de livre via un auter, code isbn et l'id d'une catégorie
     * @param auteur
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/AuteurISBNCategorie/{auteur},{isbn},{categorieId}")
    List<Livre> findLivresByAuteurContainingAndIsbnContainingAndCategorieId(@PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId);

    /**
     * Méthode pour récupérer une liste de livre via un titre, code isbn et l'id d'une categorie
     * @param titre
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreISBNCategorie/{titre},{isbn},{categorieId}")
    List<Livre> findLivresByTitreContainingAndIsbnContainingAndCategorieId(@PathVariable("titre") String titre,@PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId );


    /**
     * Méthode pour récupérer une liste de livre avec un titre, auteur et l'id d'une catégorie
     * @param titre
     * @param auteur
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteurCategorie/{titre},{auteur},{categorieId}")
    List<Livre> findLivresByTitreContainingAndAuteurContainingAndCategorieId(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("categorieId") int categorieId);


    /**
     * Méthode pour récupérer une liste de livre via un titre et l'id d'un catégorie
     * @param titre
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreCategorie/{titre},{categorieId}")
    List<Livre> findLivresByTitreContainingAndCategorieId(@PathVariable("titre") String titre,@PathVariable("categorieId") int categorieId);


    /**
     * Méthode pour récupérer une liste de livre via un auteur et l'id d'une catégorie
     * @param auteur
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/AuteurCategorie/{auteur},{categorieId}")
     List<Livre> findLivresByAuteurContainingAndCategorieId(@PathVariable("auteur") String auteur,@PathVariable("categorieId") int categorieId);


    /**
     * Méthode pour récupérer une liste de livre via un code isbn et l'id d'une catégorie
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/ISBNCategorie/{isbn},{categorieId}")
    List<Livre> findLivresByIsbnContainingAndCategorieId(@PathVariable("isbn") String isbn,@PathVariable("categorieId") int categorieId);

}
