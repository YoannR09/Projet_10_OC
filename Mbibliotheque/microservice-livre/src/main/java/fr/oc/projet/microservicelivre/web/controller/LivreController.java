package fr.oc.projet.microservicelivre.web.controller;

import fr.oc.projet.microservicelivre.dao.LivreDao;
import fr.oc.projet.microservicelivre.model.Livre;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private LivreDao livreDao;

    /**
     * Récupère un livre via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Livre/{id}")
    public Livre getLivre(@PathVariable int id) {
        try {
            return getLivreDao().findById(id);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via l'id d'un catégorie
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/Categorie/{categorieId}")
    public List<Livre> findLivreByCategorieId(@PathVariable int categorieId){
        try {
            return getLivreDao().findLivreByCategorieId(categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }

    }

    /**
     * Récupère une liste de livres via titre, auteur et isbn
     * @param titre
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteurISBN/{titre},{auteur},{isbn}")
    public List<Livre> findLivresByTitreAndAuteurAndIsbn(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn ){
        try {
            return getLivreDao().findLivresByTitreContainingAndAuteurContainingAndIsbnContaining(titre,auteur,isbn);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }

    }

    /**
     * Récupère une liste de livres via auteur et isbn
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/AuteurISBN/{auteur},{isbn}")
    public List<Livre> findLivresByAuteurContainingAndIsbnContaining(@PathVariable String auteur, @PathVariable String isbn){
        try {
            return getLivreDao().findLivresByAuteurContainingAndIsbnContaining(auteur,isbn);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via titre et isbn
     * @param titre
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/TitreISBN/{titre},{isbn}")
    public List<Livre> findLivresByTitreContainingAndIsbnContaining(@PathVariable String titre,@PathVariable String isbn ){
        try {
            return getLivreDao().findLivresByTitreContainingAndIsbnContaining(titre,isbn);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livre via titre et auteur
     * @param titre
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteur/{titre},{auteur}")
    public List<Livre> findLivresByTitreContainingAndAuteurContaining(@PathVariable String titre,@PathVariable String auteur){
        try {
            return getLivreDao().findLivresByTitreContainingAndAuteurContaining(titre,auteur);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }


    /**
     * Récupère une liste de livre via un titre
     * @param titre
     * @return
     */
    @GetMapping(value = "/Livre/Titre/{titre}")
    public List<Livre> findLivresByTitreContaining(@PathVariable String titre){
        try {
            return getLivreDao().findLivresByTitreContaining(titre);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livre via un auteur
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Livre/Auteur/{auteur}")
    public List<Livre> findLivresByAuteurContaining(@PathVariable String auteur){
        try {
            return getLivreDao().findLivresByAuteurContaining(auteur);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livre via un code isbn
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Livre/ISBN/{isbn}")
    public List<Livre> findLivresByIsbnContaining(@PathVariable String isbn){
        try {
            return getLivreDao().findLivresByIsbnContaining(isbn);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via titre, auteur, isbn et l'id d'une catégorie
     * @param titre
     * @param auteur
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteurISBNCategorie/{titre},{auteur},{isbn},{categorieId}")
    public List<Livre> findLivresByTitreAndAuteurAndIsbnAndCategorieId(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn,@PathVariable int categorieId){
        try {
            return getLivreDao().findLivresByTitreContainingAndAuteurContainingAndIsbnContainingAndCategorieId(titre,auteur,isbn,categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via auteur, isbn et l'id d'une catégorie
     * @param auteur
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/AuteurISBNCategorie/{auteur},{isbn},{categorieId}")
    public List<Livre> findLivresByAuteurContainingAndIsbnContainingAndCategorieId(@PathVariable String auteur, @PathVariable String isbn,@PathVariable int categorieId){
        try {
            return getLivreDao().findLivresByAuteurContainingAndIsbnContainingAndCategorieId(auteur,isbn,categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via titre, isbn et l'id d'une catégorie
     * @param titre
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreISBNCategorie/{titre},{isbn},{categorieId}")
    public List<Livre> findLivresByTitreContainingAndIsbnContainingAndCategorieId(@PathVariable String titre,@PathVariable String isbn,@PathVariable int categorieId ){
        try {
            return getLivreDao().findLivresByTitreContainingAndIsbnContainingAndCategorieId(titre,isbn,categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via titre, auteur et l'id d'une catégorie
     * @param titre
     * @param auteur
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreAuteurCategorie/{titre},{auteur},{categorieId}")
    public List<Livre> findLivresByTitreContainingAndAuteurContainingAndCategorieId(@PathVariable String titre,@PathVariable String auteur,@PathVariable int categorieId){
        try {
            return getLivreDao().findLivresByTitreContainingAndAuteurContainingAndCategorieId(titre,auteur,categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }


    /**
     * Récupère une liste de livres via un titre et l'id d'une catégorie
     * @param titre
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/TitreCategorie/{titre},{categorieId}")
    public List<Livre> findLivresByTitreContainingAndCategorieId(@PathVariable String titre,@PathVariable int categorieId){
        try {
            return getLivreDao().findLivresByTitreContainingAndCategorieId(titre,categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via un auteur et l'id d'une catégorie
     * @param auteur
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/AuteurCategorie/{auteur},{categorieId}")
    public List<Livre> findLivresByAuteurContainingAndCategorieId(@PathVariable String auteur,@PathVariable int categorieId){
        try {
            return getLivreDao().findLivresByAuteurContainingAndCategorieId(auteur,categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Récupère une liste de livres via un code isbn et l'id d'une catégorie
     * @param isbn
     * @param categorieId
     * @return
     */
    @GetMapping(value = "/Livre/ISBNCategorie/{isbn},{categorieId}")
    public List<Livre> findLivresByIsbnContainingAndCategorieId(@PathVariable String isbn,@PathVariable int categorieId){
        try {
            return getLivreDao().findLivresByIsbnContainingAndCategorieId(isbn,categorieId);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    protected LivreDao getLivreDao() {
        return livreDao;
    }

    protected Logger getLogger() {
        return logger;
    }
}
