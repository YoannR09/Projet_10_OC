package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Abonne;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe pour récupèrer les données du MicroServiceAbonne
 */
@FeignClient(value = "microservice-abonne", url = "localhost:9097")
public interface MicroServiceAbonneProxy {

    /**
     * Méthode pour récupérer un abonné via son id
     * @param id
     * @return
     */
    @GetMapping(value = "/Abonne/{id}")
    Abonne getAbonne(@PathVariable("id") int id);


    /**
     * Méthode pou récupérer une liste d'abonnés via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Abonne/ListPseudo/{pseudo}")
    List<Abonne> getListByPseudo(@PathVariable("pseudo") String pseudo);

    /**
     * Méthode pour récupérer une liste d'abonnés via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/ListEmail/{email}")
    List<Abonne> getListByEmail(@PathVariable("email") String email);

    /**
     * Méthode pour récupérer une liste d'abonnés via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Abonne/Pseudo/{pseudo}")
    Abonne getAbonnePseudo(@PathVariable("pseudo") String pseudo);

    /**
     * Méthode pour récupérer une liste d'abonnés via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/Email/{email}")
    Abonne getAbonneEmail(@PathVariable("email") String email);

    /**
     * Méthode pour récupèrer une liste d'abonnés via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/Nom/{nom}")
    List<Abonne> findByNom(@PathVariable("nom") String nom);

    /**
     * Méthode pour récupérer une liste d'abonnés via son prénom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/Prenom/{prenom}")
    List<Abonne> findByPrenom(@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un pseudo, email, nom et prénom
     * @param pseudo
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailNomPrenom/{pseudo},{email},{nom},{prenom}")
    List<Abonne> findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un pseudo, email et nom
     * @param pseudo
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailNom/{pseudo},{email},{nom}")
    List<Abonne> findByPseudoContainingAndEmailContainingAndNomContaining(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("nom") String nom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un pseudo, email et prenom
     * @param pseudo
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmailPrenom/{pseudo},{email},{prenom}")
    List<Abonne> findByPseudoContainingAndEmailContainingAndPrenomContaining(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un pseudo, nom et prenom
     * @param pseudo
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoNomPrenom/{pseudo},{nom},{prenom}")
    List<Abonne> findByPseudoContainingAndNomContainingAndPrenomContaining(@PathVariable("pseudo") String pseudo,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupérer une liste d'abonné via un email, nom et prenom
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailNomPrenom/{email},{nom},{prenom}")
    List<Abonne> findByEmailContainingAndNomContainingAndPrenomContaining(@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un pseudo et email
     * @param pseudo
     * @param email
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoEmail/{pseudo},{email}")
    List<Abonne> findByPseudoContainingAndEmailContaining(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email);

    /**
     * Méthode pour récupérer une liste d'abonnés via un nom et prenom
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/NomPrenom/{nom},{prenom}")
    List<Abonne> findByNomContainingAndPrenomContaining(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste d'abonnés via un pseudo et prenom
     * @param pseudo
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoPrenom/{pseudo},{prenom}")
    List<Abonne> findByPseudoContainingAndPrenomContaining(@PathVariable("pseudo") String pseudo,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un email et nom
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailNom/{email},{nom}")
    List<Abonne> findByEmailContainingAndNomContaining(@PathVariable("email") String email,@PathVariable("nom") String nom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un email et prenom
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Abonne/EmailPrenom/{email},{prenom}")
    List<Abonne> findByEmailContainingAndPrenomContaining(@PathVariable("email") String email,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupérer une liste d'abonnés via un pseudo et nom
     * @param pseudo
     * @param nom
     * @return
     */
    @GetMapping(value = "/Abonne/PseudoNom/{pseudo},{nom}")
    List<Abonne> findByPseudoContainingAndNomContaining(@PathVariable("pseudo") String pseudo,@PathVariable("nom") String nom);

    /**
     * Méthode pour récupérer la liste des abonnées.
     */
    @GetMapping(value = "/Abonne")
    List<Abonne> findALL();

    /**
     * Méthode pour ajouter un abonné à la base de données.
     * @param abonne
     */
    @PostMapping(value = "/Abonne")
    void addAbonne(@RequestBody Abonne abonne);

    /**
     * Méthode pour mettre à jour un abonné.
     * @param abonne
     */
    @PutMapping(value = "/Abonne")
    void updateAbonne(@RequestBody Abonne abonne);


}
