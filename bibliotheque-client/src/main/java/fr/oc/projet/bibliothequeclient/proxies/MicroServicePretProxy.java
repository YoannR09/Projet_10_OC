package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Pret;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Classe pour récupèrer les données du MicroServicePret
 */
@FeignClient(value = "microservice-pret",url = "192.168.1.61:9099")
public interface MicroServicePretProxy {

    /**
     * Récupère un prêt via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Pret/{id}")
    Pret getPret(@PathVariable("id") int id);

    /**
     * Récupère une liste de prêts via l'id d'un abonné
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Pret/Abonne/{abonneId}")
    List<Pret> getListPretAbonne(@PathVariable("abonneId") int abonneId);

    /**
     * Méthode pour récupèrer la liste des prêts en cours
     * @return
     */
    @GetMapping(value = "/Pret")
    List<Pret> findAll();

    /**
     * Méthode pour récupèrer une liste de prêts via l'id d'un livre
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Pret/Livre/{livreId}")
    List<Pret> getListPretLivre(@PathVariable("livreId") Integer livreId);

    /**
     * Méthode pour récupèrer une liste de prêts via l'id d'un livre et l'id d'une bibliothèque
     * @param livreId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/LivreBibliotheque/{livreId},{bibliothequeId}")
    List<Pret> getListPretLivreBibliotheque(@PathVariable("livreId") Integer livreId,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via l'id d'un abonné et l'id d'une bibliothèque
     * @param abonneId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/AbonneBibliotheque/{abonneId},{bibliothequeId}")
    List<Pret> getListPretAbonneBibliotheque(@PathVariable("abonneId") Integer abonneId,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupurer une liste de prêt via un code isbn et le numéro interne
     * @param isbn
     * @param numInterne
     * @return
     */
    @GetMapping(value = "/Pret/ISBNNumInterne/{isbn],{numInterne}")
    List<Pret> getListPretLivreISBNNumInterne(@PathVariable("isbn") String isbn,@PathVariable("numInterne") String numInterne);

    /**
     * Méthode pour récupèrer une liste de prêts via un code isbn, un numéro interne et l'id d'une bibliothèque
     * @param isbn
     * @param numInterne
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/ISBNNumInterneBibliotheque/{isbn},{numInterne},{bibliothequeId}")
    List<Pret> getListPretLivreISBNNumInterneBibliotheque(@PathVariable("isbn") String isbn,@PathVariable("numInterne") String numInterne,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un code isbn
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/ISBN/{isbn}")
    List<Pret> getListPretLivreISBN(@PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupèrer une liste de prêts via un numéro interne
     * @param numInterne
     * @return
     */
    @GetMapping(value = "/Pret/NumInterne/{numInterne}")
    List<Pret> getListPretLivreNumInterne(@PathVariable("numInterne") String numInterne);

    /**
     * Méthode pour récupèrer une liste de prêts via un code isbn et l'id d'une bibliothèque
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/ISBNBibliotheque/{isbn},{bibliothequeId}")
    List<Pret> getListPretLivreISBNBibliotheque(@PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un numéro interne et l'id d'une bibliothèque
     * @param numInterne
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/NumInterneBibliotheque/{numInterne},{bibliothequeId}")
    List<Pret> getListPretLivreNumInterneBibliotheque(@PathVariable("numInterne") String numInterne,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Ajouter un prêt
     * @param pret
     */
    @PostMapping(value = "/Pret")
    void addPret(@RequestBody Pret pret);

    /**
     * Met à jour un prêt
     * Méthode utilisé pour la prolongation d'un prêt
     * @param pret
     */
    @PutMapping(value = "/Pret")
    void updatePret(@RequestBody Pret pret);

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, auteur et un code isbn
     * @param titre
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteurISBN/{titre},{auteur},{isbn}")
    List<Pret> getListPretLivreTitreAuteurISBN(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupèrer une liste de prêts avec un titre et un code isbn
     * @param titre
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/TitreISBN/{titre},{isbn}")
    List<Pret> getListPretLivreTitreISBN(@PathVariable("titre") String titre,@PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupèrer une liste de prêts via un titre et un auteur
     * @param titre
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteur/{titre},{auteur}")
    List<Pret> getListPretLivreTitreAuteur(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur);

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur et un code isbn
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/AuteurISBN/{auteur},{isbn}")
    List<Pret> getListPretLivreAuteurISBN(@PathVariable("auteur") String auteur,@PathVariable("isbn") String isbn);

    /**
     * Méthode pour récupèrer une liste de prêts via un titre
     * @param titre
     * @return
     */
    @GetMapping(value = "/Pret/Titre/{titre}")
    List<Pret> getListPretLivreTitre(@PathVariable("titre") String titre);

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Pret/Auteur/{auteur}")
    List<Pret> getListPretLivreAuteur(@PathVariable("auteur") String auteur);

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, auteur, code isbn et l'id d'une bibliotheque
     * @param titre
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteurISBNBibliotheque/{titre},{auteur},{isbn},{bibliothequeId}")
    List<Pret> getListPretLivreTitreAuteurISBNBibliotheque(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, code isbn et l'id d'une bibliothèque
     * @param titre
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreISBNBibliotheque/{titre},{isbn},{bibliothequeId}")
    List<Pret> getListPretLivreTitreISBNBibliotheque(@PathVariable("titre") String titre,@PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, auteur et l'id d'une bibliotheque
     * @param titre
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteurBibliotheque/{titre},{auteur},{bibliothequeId}")
    List<Pret> getListPretLivreTitreAuteurBibliotheque(@PathVariable("titre") String titre,@PathVariable("auteur") String auteur,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur, code isbn et l'id d'une bibliothèque
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/AuteurISBNBibliotheque/{auteur},{isbn},{bibliothequeId}")
    List<Pret> getListPretLivreAuteurISBNBibliotheque(@PathVariable("auteur") String auteur,@PathVariable("isbn") String isbn,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un titre et l'id d'un bibliothèque
     * @param titre
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreBibliotheque/{titre},{bibliothequeId}")
    List<Pret> getListPretLivreTitreBibliotheque(@PathVariable("titre") String titre,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur et l'id d'une bibliothèque
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/AuteurBibliotheque/{auteur},{bibliothequeId}")
    List<Pret> getListPretLivreAuteurBibliotheque(@PathVariable("auteur") String auteur,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email, nom et prenom
     * @param pseudo
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailNomPrenom/{pseudo},{email},{nom},{prenom}")
    public List<Pret> getListPretAbonnePseudoEmailNomPrenom(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email et nom
     * @param pseudo
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailNom/{pseudo},{email},{nom}")
    List<Pret> getListPretAbonnePseudoEmailNom(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("nom") String nom);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email et prenom
     * @param pseudo
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailPrenom/{pseudo},{email},{prenom}")
    List<Pret> getListPretAbonnePseudoEmailPrenom(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, nom et prenom
     * @param pseudo
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNomPrenom/{pseudo},{nom},{prenom}")
    List<Pret> getListPretAbonnePseudoNomPrenom(@PathVariable("pseudo") String pseudo,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un email, nom et prenom
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/EmailNomPrenom/{email},{nom},{prenom}")
    List<Pret> getListPretAbonneEmailNomPrenom(@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et email
     * @param pseudo
     * @param email
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmail/{pseudo},{email}")
    List<Pret> getListPretAbonnePseudoEmail(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email);

    /**
     * Méthode pour récupèrer une liste de prêts via un nom et prenom
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/NomPrenom/{nom},{prenom}")
    List<Pret> getListPretAbonneNomPrenom(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et prenom
     * @param pseudo
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoPrenom/{pseudo},{prenom}")
    List<Pret> getListPretAbonnePseudoPrenom(@PathVariable("pseudo") String pseudo,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un email et nom
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/EmailNom/{email},{nom}")
    List<Pret> getListPretAbonneEmailNom(@PathVariable("email") String email,@PathVariable("nom") String nom);

    /**
     * Méthode pour récupèrer une liste de prêts via un email et prenom
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/EmailPrenom/{email},{prenom}")
    List<Pret> getListPretAbonneEmailPrenom(@PathVariable("email") String email,@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et nom
     * @param pseudo
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNom/{pseudo},{nom}")
    List<Pret> getListPretAbonnePseudoNom(@PathVariable("pseudo") String pseudo,@PathVariable("nom") String nom);


    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Pret/Pseudo/{pseudo}")
    List<Pret> getListPretAbonnePseudo(@PathVariable("pseudo") String pseudo);

    /**
     * Méthode pour récupèrer une liste de prêts via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Pret/Email/{email}")
    List<Pret> getListPretAbonneEmail(@PathVariable("email") String email);

    /**
     * Méthode pour récupèrer une liste de prêts via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/Nom/{nom}")
    List<Pret> getListPretAbonneNom(@PathVariable("nom") String nom);

    /**
     * Méthode pour récupèrer une liste de prêts via un prenom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/Prenom/{prenom}")
    List<Pret> getListPretAbonnePrenom(@PathVariable("prenom") String prenom);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email, nom, prenom et l'id d'une bibliothèque
     * @param pseudo
     * @param email
     * @param nom
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailNomPrenomBibliotheque/{pseudo},{email},{nom},{prenom},{bibliothequeId}")
    List<Pret> getListPretAbonnePseudoEmailNomPrenomBibliotheque(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email, nom et l'id d'une bibliotheque
     * @param pseudo
     * @param email
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailNomBibliotheque/{pseudo},{email},{nom},{bibliothequeId}")
    List<Pret> getListPretAbonnePseudoEmailNomBibliotheque(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("bibliothequeId") Integer bibliothequeId);


    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email, prenom et l'id d'une bibliotheque
     * @param pseudo
     * @param email
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailPrenomBibliotheque/{pseudo},{email},{prenom},{bibliothequeId}")
    List<Pret> getListPretAbonnePseudoEmailPrenomBibliotheque(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, nom, prenom et bibliotequeId
     * @param pseudo
     * @param nom
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNomPrenom/{pseudo},{nom},{prenom},{bibliothequeId")
    List<Pret> getListPretAbonnePseudoNomPrenomBibliotheque(@PathVariable("pseudo") String pseudo,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un email, nom, prenom et l'id d'une bibliotheque
     * @param email
     * @param nom
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailNomPrenomBibliotheque/{email},{nom},{prenom},{bibliothequeId}")
    List<Pret> getListPretAbonneEmailNomPrenomBibliotheque(@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email et l'id d'une bibliotheque
     * @param pseudo
     * @param email
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailBibliotheque/{pseudo},{email},{bibliothequeId}")
    List<Pret> getListPretAbonnePseudoEmailBibliotheque(@PathVariable("pseudo") String pseudo,@PathVariable("email") String email,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un nom, prenom et l'id d'une bibliotheque
     * @param nom
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/NomPrenomBibliotheque/{nom},{prenom},{bibliothequeId}")
    List<Pret> getListPretAbonneNomPrenomBibliotheque(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, prenom et l'id d'une bibliotheque
     * @param pseudo
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoPrenomBibliotheque/{pseudo},{prenom},{bibliothequeId}")
    List<Pret> getListPretAbonnePseudoPrenomBibliotheque(@PathVariable("pseudo") String pseudo,@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un email, nom et l'id d'une bibliothèque
     * @param email
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailNomBibliotheque/{email},{nom},{bibliothequeId}")
    List<Pret> getListPretAbonneEmailNomBibliotheque(@PathVariable("email") String email,@PathVariable("nom") String nom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un email, prenom et l'id d'une biblbiotheque
     * @param email
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailPrenomBibliotheque/{email},{prenom},{bibliothequeId}")
    List<Pret> getListPretAbonneEmailPrenomBibliotheque(@PathVariable("email") String email,@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, nom et l'adresse id d'une bibliotheque
     * @param pseudo
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNomBibliotheque/{pseudo},{nom},{bibliothequeId}")
    List<Pret> getListPretAbonnePseudoNomBibliotheque(@PathVariable String pseudo,@PathVariable("nom") String nom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et l'id d'une bibliotheque
     * @param pseudo
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoBibliotheque/{pseudo},{bibliothequeId}")
    List<Pret> getListPretAbonnePseudoBibliotheque(@PathVariable("pseudo") String pseudo,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un email et l'id d'une bibliotheque
     * @param email
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailBibliotheque/{email},{bibliothequeId}")
    List<Pret> getListPretAbonneEmailBibliotheque(@PathVariable("email") String email,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un nom et l'id d'une bibliotheque
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/NomBibliotheque/{nom},{bibliothequeId}")
    List<Pret> getListPretAbonneNomBibliotheque(@PathVariable("nom") String nom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour récupèrer une liste de prêts via un prenom et l'id d'une bibliotheque
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PrenomBibliotheque/{prenom},{bibliothequeId}")
    List<Pret> getListPretAbonnePrenomBibliotheque(@PathVariable("prenom") String prenom,@PathVariable("bibliothequeId") Integer bibliothequeId);

    /**
     * Méthode pour supprimer un prêt en cours
     * @param id
     */
    @DeleteMapping (value = "/Pret/{id}")
    void delete(@PathVariable("id") Integer id);
}
