package fr.oc.projet.microserviceabonne.web.controller;

import fr.oc.projet.microserviceabonne.dao.AbonneDao;
import fr.oc.projet.microserviceabonne.model.Abonne;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbonneController {

    @Autowired
    private AbonneDao abonneDao;

    private static Logger logger = LogManager.getLogger();

    public AbonneController(){}

    /**
     * Méthode pour récupèrer un abonné via son id
     * @param id
     * @return
     */
    @GetMapping(value = "/Abonne/{id}")
    public Abonne getAbonne(@PathVariable int id){
        try {
        return getAbonneDao().findById(id);
        }catch (Exception e){
            getLogger().warn("Methode getAbonne() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Abonne/Pseudo/{pseudo}")
    public Abonne getAbonnePseudo(@PathVariable String pseudo){
        try {
            return getAbonneDao().findByPseudo(pseudo);
        }catch (Exception e){
            getLogger().error("Methode getAbonnePseudo() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/Email/{email}")
    public Abonne getAbonneEmail(@PathVariable String email){
        try {
            return getAbonneDao().findByEmail(email);
        }catch (Exception e){
            getLogger().error("Methode getAbonneEmail() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pou récuprer une liste d'abonnés via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Abonne/ListPseudo/{pseudo}")
    public List<Abonne> getListByPseudo(@PathVariable String pseudo){
        try {
            return getAbonneDao().getListByPseudo(pseudo);
        }catch (Exception e){
            getLogger().error("Methode getListByPseudo() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/ListEmail/{email}")
    public List<Abonne> getListByEmail(@PathVariable String email){
        try {
            return getAbonneDao().getListByEmail(email);
        }catch (Exception e){
            getLogger().error("Methode getListByEmail() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/Nom/{nom}")
    public List<Abonne> findByNom(@PathVariable String nom){
        try {
            return getAbonneDao().findByNom(nom);
        }catch (Exception e){
            getLogger().error("Methode getAbonneNom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via son prénom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/Prenom/{prenom}")
    public List<Abonne> findByPrenom(@PathVariable String prenom){
        try {
            return getAbonneDao().findByPrenom(prenom);
        }catch (Exception e){
            getLogger().error("Methode getAbonnePrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, email, nom et prénom
     * @param pseudo
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailNomPrenom/{pseudo},{email},{nom},{prenom}")
    public List<Abonne> findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom,@PathVariable String prenom){
        try {
            return getAbonneDao().findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(pseudo,email,nom,prenom);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, email et nom
     * @param pseudo
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailNom/{pseudo},{email},{nom}")
    public List<Abonne> findByPseudoContainingAndEmailContainingAndNomContaining(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom){
        try {
            return getAbonneDao().findByPseudoContainingAndEmailContainingAndNomContaining(pseudo,email,nom);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndEmailContainingAndNomContaining erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, email et prenom
     * @param pseudo
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailPrenom/{pseudo},{email},{prenom}")
    public List<Abonne> findByPseudoContainingAndEmailContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String email,@PathVariable String prenom){
        try {
            return getAbonneDao().findByPseudoContainingAndEmailContainingAndPrenomContaining(pseudo,email,prenom);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndEmailContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo, nom et prenom
     * @param pseudo
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoNomPrenom/{pseudo},{nom},{prenom}")
    public List<Abonne> findByPseudoContainingAndNomContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String nom,@PathVariable String prenom){
        try {
            return getAbonneDao().findByPseudoContainingAndNomContainingAndPrenomContaining(pseudo,nom,prenom);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndNomContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonné via un email, nom et prenom
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailNomPrenom/{email},{nom},{prenom}")
    public List<Abonne> findByEmailContainingAndNomContainingAndPrenomContaining(@PathVariable String email,@PathVariable String nom,@PathVariable String prenom){
        try {
            return getAbonneDao().findByEmailContainingAndNomContainingAndPrenomContaining(email,nom,prenom);
        }catch (Exception e){
            getLogger().error("Methode findByEmailContainingAndNomContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo et email
     * @param pseudo
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmail/{pseudo},{email}")
    public List<Abonne> findByPseudoContainingAndEmailContaining(@PathVariable String pseudo,@PathVariable String email){
        try {
            return getAbonneDao().findByPseudoContainingAndEmailContaining(pseudo,email);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndEmailContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un nom et prenom
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/NomPrenom/{nom},{prenom}")
    public List<Abonne> findByNomContainingAndPrenomContaining(@PathVariable String nom,@PathVariable String prenom){
        try {
            return getAbonneDao().findByNomContainingAndPrenomContaining(nom,prenom);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndEmailContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo et prenom
     * @param pseudo
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoPrenom/{pseudo},{prenom}")
    public List<Abonne> findByPseudoContainingAndPrenomContaining(@PathVariable String pseudo,@PathVariable String prenom){
        try {
            return getAbonneDao().findByPseudoContainingAndPrenomContaining(pseudo,prenom);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email et nom
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailNom/{email},{nom}")
    public List<Abonne> findByEmailContainingAndNomContaining(@PathVariable String email,@PathVariable String nom){
        try {
            return getAbonneDao().findByEmailContainingAndNomContaining(email,nom);
        }catch (Exception e){
            getLogger().error("Methode findByEmailContainingAndNomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un email et prenom
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailPrenom/{email},{prenom}")
    public List<Abonne> findByEmailContainingAndPrenomContaining(@PathVariable String email,@PathVariable String prenom){
        try {
            return getAbonneDao().findByEmailContainingAndPrenomContaining(email,prenom);
        }catch (Exception e){
            getLogger().error("Methode findByEmailContainingAndPrenomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo et nom
     * @param pseudo
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoNom/{pseudo},{nom}")
    public List<Abonne> findByPseudoContainingAndNomContaining(@PathVariable String pseudo,@PathVariable String nom){
        try {
            return getAbonneDao().findByPseudoContainingAndNomContaining(pseudo,nom);
        }catch (Exception e){
            getLogger().error("Methode findByPseudoContainingAndNomContaining() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour ajouter un abonné à la base de données.
     * @param abonne
     */
    @PostMapping(value = "/Abonne")
    public void addAbonne(@RequestBody Abonne abonne) {
        try {
            getAbonneDao().save(abonne);
        }catch (Exception e){
            getLogger().error("Methode addAbonne() erreur : "+e);
        }
    }

    /**
     * Méthode pour mettre à jour un abonné.
     * @param abonne
     */
    @PutMapping(value = "/Abonne")
    public void updateAbonne(@RequestBody Abonne abonne) {
        try {
            getAbonneDao().save(abonne);
        }catch (Exception e){
            getLogger().error("Methode updateAbonne() erreur : "+e);
        }
    }

    /**
     * Méthode pour récupèrer la liste des abonnées.
     */
    @GetMapping(value = "/Abonne")
    public List<Abonne> findALL(){
        try {
           return getAbonneDao().findAll();
        }catch (Exception e){
            getLogger().error("Methode updateAbonne() erreur : "+e);
            return null;
        }
    }

    protected Logger getLogger() {
        return logger;
    }


    protected AbonneDao getAbonneDao() {
        return abonneDao;
    }

}
