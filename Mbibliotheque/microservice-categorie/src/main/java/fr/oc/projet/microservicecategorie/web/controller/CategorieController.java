package fr.oc.projet.microservicecategorie.web.controller;

import fr.oc.projet.microservicecategorie.dao.CategorieDao;
import fr.oc.projet.microservicecategorie.model.Categorie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    private CategorieDao categorieDao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour récupèrer une catégorie via un id.
     * @param id
     * @return
     */
    @GetMapping(value = "/Categorie/{id}")
    public Categorie getCategorie(@PathVariable int id){
        try {
            return getCategorieDao().findById(id);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une catégorie via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Categorie/Nom/{nom}")
    public Categorie findByNom(@PathVariable String nom){
        try {
            return getCategorieDao().findByNom(nom);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer la liste des catégories
     * @return
     */
    @GetMapping(value = "/Categorie")
    public List<Categorie> getListCategorie(){
        try {
            return getCategorieDao().findAll();
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    protected Logger getLogger() {
        return logger;
    }

    protected CategorieDao getCategorieDao() {
        return categorieDao;
    }
}
