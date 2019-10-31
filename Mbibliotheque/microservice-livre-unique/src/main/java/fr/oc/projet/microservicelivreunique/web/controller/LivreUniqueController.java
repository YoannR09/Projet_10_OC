package fr.oc.projet.microservicelivreunique.web.controller;

import fr.oc.projet.microservicelivreunique.dao.LivreUniqueDao;
import fr.oc.projet.microservicelivreunique.model.LivreUnique;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreUniqueController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private LivreUniqueDao livreUniqueDao;

    /**
     * Méthode pour récupèrer un livre unique via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/LivreUnique/{id}")
    public LivreUnique findById(@PathVariable int id){
        try {
            return getLivreUniqueDao().findById(id);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer un livre unique via l'id d'un livre et l'id d'une bibliothèque
     * @param livreId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/CountLivreUniqueBibliotheque/{livreId},{bibliothequeId}")
    public Integer countLivreUniqueBibliotheque(@PathVariable int livreId, @PathVariable int bibliothequeId){
        try {
            return getLivreUniqueDao().countLivreUniqueByLivreIdAndBibliothequeIdAndDisponibleIsTrue(livreId,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer un livre unique via l'id d'un livre et l'id d'une bibliothèque
     * @param livreId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/CountLivreUniqueBibliothequeTotal/{livreId},{bibliothequeId}")
    public Integer countLivreUniqueBibliothequeTotal(@PathVariable int livreId, @PathVariable int bibliothequeId){
        try {
            return getLivreUniqueDao().countLivreUniqueByLivreIdAndBibliothequeId(livreId,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour compter le nombre de livre unique disponible via l'id d'un livre
     * @param livreId
     * @return
     */
    @GetMapping(value = "/CountLivreUnique/{livreId}")
    public Integer countLivreUnique(@PathVariable int livreId){
        try {
            return getLivreUniqueDao().countLivreUniqueByLivreIdAndDisponibleIsTrue(livreId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaire via un titre, auteur et code isbn
     * @param titre
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteurISBN/{titre},{auteur},{isbn}")
    public List<LivreUnique> getListLivreUniqueTitreAuteurISBN(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitreAuteurISBN(titre,auteur,isbn);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreAuteurISBN() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste d'exemplaires via l'id d'un livre et l'id d'une bibliotheque
     * @param livreId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/LivreBibliotheque/{livreId},{bibliothequeId}")
    public List<LivreUnique> getListLivreUniqueLivreBibliotheque(@PathVariable Integer livreId, @PathVariable Integer bibliothequeId){
        return livreUniqueDao.getListLivreUniqueLivreBibliotheque(livreId,bibliothequeId);
    }


    /**
     * Méthodepour récupèrer une liste d'exemplaire via un titre et auteur
     * @param titre
     * @param auteur
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteur/{titre},{auteur}")
    public List<LivreUnique> getListLivreUniqueTitreAuteur(@PathVariable String titre,@PathVariable String auteur){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitreAuteur(titre,auteur);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreAuteur() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur et un code isbn
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/LivreUnique/AuteurISBN/{auteur},{isbn}")
    public List<LivreUnique> getListLivreUniqueAuteurISBN(@PathVariable String auteur, @PathVariable String isbn){
        try {
            return getLivreUniqueDao().getListLivreUniqueAuteurISBN(auteur,isbn);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueAuteurISBN() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaire avec un titre et un code isbn
     * @param titre
     * @param isbn
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreISBN/{titre},{isbn}")
    public List<LivreUnique> getListLivreUniqueTitreISBN(@PathVariable String titre, @PathVariable String isbn){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitreISBN(titre,isbn);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreISBN() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre
     * @param titre
     * @return
     */
    @GetMapping(value = "/LivreUnique/Titre/{titre}")
    public List<LivreUnique> getListLivreUniqueTitre(@PathVariable String titre){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitre(titre);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitre() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur
     * @param auteur
     * @return
     */
    @GetMapping(value = "/LivreUnique/Auteur/{auteur}")
    public List<LivreUnique> getListLivreUniqueAuteur(@PathVariable String auteur){
        try {
            return getLivreUniqueDao().getListLivreUniqueAuteur(auteur);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitre() erreur : "+e);
            return null;
        }
    }

    @GetMapping(value = "/LivreUnique/ISBN/{isbn}")
    public List<LivreUnique> getListLivreUniqueISBN(@PathVariable String isbn){
        try {
            return getLivreUniqueDao().getListLivreUniqueISBN(isbn);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreAuteur() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre, auteur ,code isbn et id d'une bibiliothèque
     * @param titre
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteurISBNBibliotheque/{titre},{auteur},{isbn},{bibliothequeId}")
    public List<LivreUnique> getListLivreUniqueTitreAuteurISBNBibliotheque(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitreAuteurISBNBibliotheque(titre,auteur,isbn,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreAuteurISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre, auteur et l'id d'une bibliothèque
     * @param titre
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreAuteurBibliotheque/{titre},{auteur},{bibliothequeId}")
    public List<LivreUnique> getListLivreUniqueTitreAuteurBibliotheque(@PathVariable String titre,@PathVariable String auteur,@PathVariable Integer bibliothequeId){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitreAuteurBibliotheque(titre,auteur,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreAuteurBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur, code isbn et l'id d'une bibliothèque
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/AuteurISBNBibliotheque/{auteur},{isbn},{bibliothequeId}")
    public List<LivreUnique> getListLivreUniqueAuteurISBNBibliotheque(@PathVariable String auteur, @PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return getLivreUniqueDao().getListLivreUniqueAuteurISBNBibliotheque(auteur,isbn,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueAuteurISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un titre, code isbn et l'id d'une bibliothèque
     * @param titre
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreISBNBibliotheque/{titre],{isbn},{bibilithequeId}")
    public List<LivreUnique> getListLivreUniqueTitreISBNBibliotheque(@PathVariable String titre, @PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitreISBNBibliotheque(titre,isbn,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaire via un titre et l'id d'une bibliothèque
     * @param titre
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/TitreBibliotheque/{titre},{bibliothequeId}")
    public List<LivreUnique> getListLivreUniqueTitreBibliotheque(@PathVariable String titre,@PathVariable Integer bibliothequeId){
        try {
            return getLivreUniqueDao().getListLivreUniqueTitreBibliotheque(titre,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueTitreBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un auteur et l'id d'une bibliothèque
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/AuteurBibliotheque/{auteur},{bibliothequeId}")
    public List<LivreUnique> getListLivreUniqueAuteurBibliotheque(@PathVariable String auteur,@PathVariable Integer bibliothequeId){
        try {
            return getLivreUniqueDao().getListLivreUniqueAuteurBibliotheque(auteur,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueAuteurBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'exemplaires via un code isbn et l'id d'une bibliothèque
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/LivreUnique/ISBNBibliotheque/{isbn},{bibliothequeId}")
    public List<LivreUnique> getListLivreUniqueISBNBibliotheque(@PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return getLivreUniqueDao().getListLivreUniqueISBNBibliotheque(isbn,bibliothequeId);
        }catch (Exception e){
            getLogger().error("Methode getListLivreUniqueISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer la liste de chaque les exemplaires.
     * @return
     */
    @GetMapping(value = "/LivreUnique")
    public List<LivreUnique> getListLivreUnique(){
        try {
            return getLivreUniqueDao().findAll();
        }catch (Exception e){
            getLogger().error("Methode getListLivreUnique() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour mettre à jour la disponibilité du livre.
     * @param livreUnique
     */
    @PutMapping(value = "/LivreUnique")
    public void updateDispo(@RequestBody LivreUnique livreUnique){
        try {
            getLivreUniqueDao().save(livreUnique);
        }catch (Exception e){
            getLogger().error("Methode updateDispo() erreur : "+e);
        }
    }

    /**
     * Méthode pour supprimer un exemplaire
     * @param id
     */
    @DeleteMapping(value = "/LivreUnique/{id}")
    public void delete(@PathVariable Integer id){
        try {
            getLivreUniqueDao().deleteById(id);
        }catch (Exception e){
            getLogger().error("Methode delete() erreur : "+e);
        }
    }

    protected LivreUniqueDao getLivreUniqueDao() {
        return livreUniqueDao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
