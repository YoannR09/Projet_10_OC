package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.LivreUnique;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


/**
 * Classe pour récupèrer les données du MicroServiceLivreUnique
 */
@FeignClient(name = "microservice-livre-unique", url = "localhost:9098")
public interface MicroServiceLivreUniqueProxy {

    @GetMapping(value = "/LivreUnique/{id}")
    LivreUnique findById(@PathVariable int id);

    @GetMapping(value = "/CountLivreUniqueBibliotheque/{livreId},{bibliothequeId}")
    Integer countLivreUniqueBibliothequeDisponible(@PathVariable("livreId") int livreId, @PathVariable("bibliothequeId") int bibliothequeId);


    @GetMapping(value = "/CountLivreUnique/{livreId}")
    Integer countLivreUniqueDisponible(@PathVariable("livreId") int livreId);

    /**
     * Méthode pour récupèrer un livre unique via l'id d'un livre et l'id d'une bibliothèque
     * @param livreId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/CountLivreUniqueBibliotheque/{livreId},{bibliothequeId}")
    Integer countLivreUniqueBibliotheque(@PathVariable("livreId") int livreId, @PathVariable("bibliothequeId") int bibliothequeId);

    /**
     * Méthode pour compter le nombre de livre unique disponible via l'id d'un livre
     * @param livreId
     * @return
     */
    @GetMapping(value = "/CountLivreUnique/{livreId}")
    Integer countLivreUnique(@PathVariable("livreId") int livreId);

    /**
     * Méthode pour récupèrer une liste d'exemplaire via un titre, auteur et code isbn
     * @param titre
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteurISBN/{titre},{auteur},{isbn}")
    List<LivreUnique> getListLivreUniqueTitreAuteurISBN(@PathVariable("titre") String titre, @PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn);

    /**
     * Méthodepour récupèrer une liste d'exemplaire via un titre et auteur
     * @param titre
     * @param auteur
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteur/{titre},{auteur}")
    List<LivreUnique> getListLivreUniqueTitreAuteur(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur et un code isbn
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/LivreUnique/AuteurISBN/{auteur},{isbn}")
    List<LivreUnique> getListLivreUniqueAuteurISBN(@PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupèrer une liste d'exemplaire avec un titre et un code isbn
     * @param titre
     * @param isbn
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreISBN/{titre},{isbn}")
    List<LivreUnique> getListLivreUniqueTitreISBN(@PathVariable("titre") String titre, @PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre
     * @param titre
     * @return
     */
    @GetMapping(value = "/LivreUnique/Titre/{titre}")
    List<LivreUnique> getListLivreUniqueTitre(@PathVariable("titre") String titre);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur
     * @param auteur
     * @return
     */
    @GetMapping(value = "/LivreUnique/Auteur/{auteur}")
    List<LivreUnique> getListLivreUniqueAuteur(@PathVariable("auteur") String auteur);

    @GetMapping(value = "/LivreUnique/ISBN/{isbn}")
    List<LivreUnique> getListLivreUniqueISBN(@PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre, auteur ,code isbn et id d'une bibiliothèque
     * @param titre
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteurISBNBibliotheque/{titre},{auteur},{isbn},{bibliothequeId}")
    List<LivreUnique> getListLivreUniqueTitreAuteurISBNBibliotheque(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre, auteur et l'id d'une bibliothèque
     * @param titre
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteurBibliotheque/{titre},{auteur},{bibliothequeId}")
    List<LivreUnique> getListLivreUniqueTitreAuteurBibliotheque(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur, code isbn et l'id d'une bibliothèque
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/AuteurISBNBibliotheque/{auteur},{isbn},{bibliothequeId}")
    List<LivreUnique> getListLivreUniqueAuteurISBNBibliotheque(@PathVariable("auteur") String auteur, @PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre, code isbn et l'id d'une bibliothèque
     * @param titre
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreISBNBibliotheque/{titre],{isbn},{bibilithequeId}")
    List<LivreUnique> getListLivreUniqueTitreISBNBibliotheque(@PathVariable("titre") String titre, @PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste d'exemplaire via un titre et l'id d'une bibliothèque
     * @param titre
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreBibliotheque/{titre},{bibliothequeId}")
    List<LivreUnique> getListLivreUniqueTitreBibliotheque(@PathVariable("titre") String titre,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur et l'id d'une bibliothèque
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/AuteurBibliotheque/{auteur},{bibliothequeId}")
    List<LivreUnique> getListLivreUniqueAuteurBibliotheque(@PathVariable("auteur") String auteur,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un code isbn et l'id d'une bibliothèque
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/ISBNBibliotheque/{isbn},{bibliothequeId}")
    List<LivreUnique> getListLivreUniqueISBNBibliotheque(@PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer la liste de chaque les exemplaires.
     * @return
     */
    @GetMapping(value = "/LivreUnique")
    List<LivreUnique> getListLivreUnique();

    /**
     * Méthode pour mettre à jour la disponibilité du livre.
     * @param livreUnique
     */
    @PutMapping(value = "/LivreUnique")
    void updateDispo(@RequestBody LivreUnique livreUnique);
}
