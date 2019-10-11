package fr.oc.projet.microservicepret.web.controller;

import fr.oc.projet.microservicepret.dao.PretDao;
import fr.oc.projet.microservicepret.model.Pret;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import java.util.List;

@RestController
public class PretController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private PretDao pretDao;

    /**
     * Récupère un prêt via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Pret/{id}")
    public Pret getPret(@PathVariable int id){
        try {
            return pretDao.findById(id);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }


    /**
     * Méthode pour récupèrer la liste des prêts en cours
     * @return
     */
    @GetMapping(value = "/Pret")
    public List<Pret> findAll(){
        try {
            return pretDao.findAll();
        }catch (Exception e){
            logger.error("Methode findAll() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via l'id d'un livre
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Pret/Livre/{livreId}")
    public List<Pret> getListPretLivre(@PathVariable Integer livreId){
        try {
            return pretDao.getListPretLivre(livreId);
        }catch (Exception e){
            logger.error("Methode getListPretLivre() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêt via l'id d'un abonné
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Pret/Abonne/{abonneId}")
    public List<Pret> getListPretAbonne(@PathVariable Integer abonneId){
        try {
            return pretDao.findByAbonneId(abonneId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonne() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via l'id d'un livre et l'id d'une bibliothèque
     * @param livreId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/LivreBibliotheque/{livreId},{bibliothequeId}")
    public List<Pret> getListPretLivreBibliotheque(@PathVariable Integer livreId,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreBibliotheque(livreId,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via l'id d'un abonné et l'id d'une bibliothèque
     * @param abonneId
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/AbonneBibliotheque/{abonneId},{bibliothequeId}")
    public List<Pret> getListPretAbonneBibliotheque(@PathVariable Integer abonneId,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonneBibliotheque(abonneId,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupurer une liste de prêt via un code isbn et le numéro interne
     * @param isbn
     * @param numInterne
     * @return
     */
    @GetMapping(value = "/Pret/ISBNNumInterne/{isbn],{numInterne}")
    public List<Pret> getListPretLivreISBNNumInterne(@PathVariable String isbn,@PathVariable String numInterne){
        try {
            return pretDao.getListPretLivreISBNNumInterne(isbn,numInterne);
        }catch (Exception e){
            logger.error("Methode getListPretLivreISBNNumInterne() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un code isbn, un numéro interne et l'id d'une bibliothèque
     * @param isbn
     * @param numInterne
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/ISBNNumInterneBibliotheque/{isbn},{numInterne},{bibliothequeId}")
    public List<Pret> getListPretLivreISBNNumInterneBibliotheque(@PathVariable String isbn,@PathVariable String numInterne,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreISBNNumInterneBibliotheque(isbn,numInterne,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreISBNNumInterneBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un code isbn
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/ISBN/{isbn}")
    public List<Pret> getListPretLivreISBN(@PathVariable String isbn){
        try {
            return pretDao.getListPretLivreISBN(isbn);
        }catch (Exception e){
            logger.error("Methode getListPretLivreISBN() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un numéro interne
     * @param numInterne
     * @return
     */
    @GetMapping(value = "/Pret/NumInterne/{numInterne}")
    public List<Pret> getListPretLivreNumInterne(@PathVariable String numInterne){
        try {
            return pretDao.getListPretLivreNumInterne(numInterne);
        }catch (Exception e){
            logger.error("Methode getListPretLivreNumInterne() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un code isbn et l'id d'une bibliothèque
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/ISBNBibliotheque/{isbn},{bibliothequeId}")
    public List<Pret> getListPretLivreISBNBibliotheque(@PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreISBNBibliotheque(isbn,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un numéro interne et l'id d'une bibliothèque
     * @param numInterne
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/NumInterneBibliotheque/{numInterne},{bibliothequeId}")
    public List<Pret> getListPretLivreNumInterneBibliotheque(@PathVariable String numInterne,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreNumInterneBibliotheque(numInterne,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreNumInterneBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Ajouter un prêt
     * @param pret
     */
    @PostMapping(value = "/Pret")
    public void addPret(@RequestBody Pret pret) {
        try {
            pretDao.save(pret);
        }catch (Exception e){
            logger.error("Methode addPret() erreur : "+e);
        }
    }



    /**
     * Met à jour un prêt
     * Méthode utilisé pour la prolongation d'un prêt
     * @param pret
     */
    @PutMapping(value = "/Pret")
    public void updatePret(@RequestBody Pret pret) {
        try {
            pretDao.save(pret);
        }catch (Exception e){
            logger.error("Methode updatePret() erreur : "+e);
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, auteur et un code isbn
     * @param titre
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteurISBN/{titre},{auteur},{isbn}")
    public List<Pret> getListPretLivreTitreAuteurISBN(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn){
        try {
            return pretDao.getListPretLivreTitreAuteurISBN(titre,auteur,isbn);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitreAuteurISBN() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts avec un titre et un code isbn
     * @param titre
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/TitreISBN/{titre},{isbn}")
    public List<Pret> getListPretLivreTitreISBN(@PathVariable String titre,@PathVariable String isbn){
        try {
            return pretDao.getListPretLivreTitreISBN(titre,isbn);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitreISBN() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un titre et un auteur
     * @param titre
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteur/{titre},{auteur}")
    public List<Pret> getListPretLivreTitreAuteur(@PathVariable String titre,@PathVariable String auteur){
        try {
            return pretDao.getListPretLivreTitreAuteur(titre,auteur);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitreAuteur() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur et un code isbn
     * @param auteur
     * @param isbn
     * @return
     */
    @GetMapping(value = "/Pret/AuteurISBN/{auteur},{isbn}")
    public List<Pret> getListPretLivreAuteurISBN(@PathVariable String auteur,@PathVariable String isbn){
        try {
            return pretDao.getListPretLivreAuteurISBN(auteur,isbn);
        }catch (Exception e){
            logger.error("Methode getListPretLivreAuteurISBN() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un titre
     * @param titre
     * @return
     */
    @GetMapping(value = "/Pret/Titre/{titre}")
    public List<Pret> getListPretLivreTitre(@PathVariable String titre){
        try {
            return pretDao.getListPretLivreTitre(titre);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitre() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur
     * @param auteur
     * @return
     */
    @GetMapping(value = "/Pret/Auteur/{auteur}")
    public List<Pret> getListPretLivreAuteur(@PathVariable String auteur){
        try {
            return pretDao.getListPretLivreAuteur(auteur);
        }catch (Exception e){
            logger.error("Methode getListPretLivreAuteur() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, auteur, code isbn et l'id d'une bibliotheque
     * @param titre
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteurISBNBibliotheque/{titre},{auteur},{isbn},{bibliothequeId}")
    public List<Pret> getListPretLivreTitreAuteurISBNBibliotheque(@PathVariable String titre,@PathVariable String auteur,@PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreTitreAuteurISBNBibliotheque(titre,auteur,isbn,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitreAuteurISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, code isbn et l'id d'une bibliothèque
     * @param titre
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreISBNBibliotheque/{titre},{isbn},{bibliothequeId}")
    public List<Pret> getListPretLivreTitreISBNBibliotheque(@PathVariable String titre,@PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreTitreISBNBibliotheque(titre,isbn,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitreISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un titre, auteur et l'id d'une bibliotheque
     * @param titre
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreAuteurBibliotheque/{titre},{auteur},{bibliothequeId}")
    public List<Pret> getListPretLivreTitreAuteurBibliotheque(@PathVariable String titre,@PathVariable String auteur,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreTitreAuteurBibliotheque(titre,auteur,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitreAuteurBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur, code isbn et l'id d'une bibliothèque
     * @param auteur
     * @param isbn
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/AuteurISBNBibliotheque/{auteur},{isbn},{bibliothequeId}")
    public List<Pret> getListPretLivreAuteurISBNBibliotheque(@PathVariable String auteur,@PathVariable String isbn,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreAuteurISBNBibliotheque(auteur,isbn,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreAuteurISBNBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un titre et l'id d'un bibliothèque
     * @param titre
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/TitreBibliotheque/{titre},{bibliothequeId}")
    public List<Pret> getListPretLivreTitreBibliotheque(@PathVariable String titre,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreTitreBibliotheque(titre,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreTitreBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un auteur et l'id d'une bibliothèque
     * @param auteur
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/AuteurBibliotheque/{auteur},{bibliothequeId}")
    public List<Pret> getListPretLivreAuteurBibliotheque(@PathVariable String auteur,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretLivreAuteurBibliotheque(auteur,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretLivreAuteurBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email, nom et prenom
     * @param pseudo
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailNomPrenom/{pseudo},{email},{nom},{prenom}")
    public List<Pret> getListPretAbonnePseudoEmailNomPrenom(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom,@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonnePseudoEmailNomPrenom(pseudo,email,nom,prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmailNomPrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email et nom
     * @param pseudo
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailNom/{pseudo},{email},{nom}")
    public List<Pret> getListPretAbonnePseudoEmailNom(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom){
        try {
            return pretDao.getListPretAbonnePseudoEmailNom(pseudo,email,nom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmailNom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email et prenom
     * @param pseudo
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailPrenom/{pseudo},{email},{prenom}")
    public List<Pret> getListPretAbonnePseudoEmailPrenom(@PathVariable String pseudo,@PathVariable String email,@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonnePseudoEmailPrenom(pseudo,email,prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmailPrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, nom et prenom
     * @param pseudo
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNomPrenom/{pseudo},{nom},{prenom}")
    public List<Pret> getListPretAbonnePseudoNomPrenom(@PathVariable String pseudo,@PathVariable String nom,@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonnePseudoNomPrenom(pseudo,nom,prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoNomPrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email, nom et prenom
     * @param email
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/EmailNomPrenom/{email},{nom},{prenom}")
    public List<Pret> getListPretAbonneEmailNomPrenom(@PathVariable String email,@PathVariable String nom,@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonneEmailNomPrenom(email,nom,prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneEmailNomPrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et email
     * @param pseudo
     * @param email
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmail/{pseudo},{email}")
    public List<Pret> getListPretAbonnePseudoEmail(@PathVariable String pseudo,@PathVariable String email){
        try {
            return pretDao.getListPretAbonnePseudoEmail(pseudo,email);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmail() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un nom et prenom
     * @param nom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/NomPrenom/{nom},{prenom}")
    public List<Pret> getListPretAbonneNomPrenom(@PathVariable String nom,@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonneNomPrenom(nom,prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneNomPrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et prenom
     * @param pseudo
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoPrenom/{pseudo},{prenom}")
    public List<Pret> getListPretAbonnePseudoPrenom(@PathVariable String pseudo,@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonnePseudoPrenom(pseudo,prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoPrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email et nom
     * @param email
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/EmailNom/{email},{nom}")
    public List<Pret> getListPretAbonneEmailNom(@PathVariable String email,@PathVariable String nom){
        try {
            return pretDao.getListPretAbonneEmailNom(email,nom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneEmailNom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email et prenom
     * @param email
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/EmailPrenom/{email},{prenom}")
    public List<Pret> getListPretAbonneEmailPrenom(@PathVariable String email,@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonneEmailPrenom(email,prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneEmailPrenom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et nom
     * @param pseudo
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNom/{pseudo},{nom}")
    public List<Pret> getListPretAbonnePseudoNom(@PathVariable String pseudo,@PathVariable String nom){
        try {
            return pretDao.getListPretAbonnePseudoNom(pseudo,nom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoNom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo
     * @param pseudo
     * @return
     */
    @GetMapping(value = "/Pret/Pseudo/{pseudo}")
    public List<Pret> getListPretAbonnePseudo(@PathVariable String pseudo){
        try {
            return pretDao.getListPretAbonnePseudo(pseudo);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudo() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email
     * @param email
     * @return
     */
    @GetMapping(value = "/Pret/Email/{email}")
    public List<Pret> getListPretAbonneEmail(@PathVariable String email){
        try {
            return pretDao.getListPretAbonneEmail(email);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneEmail() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un nom
     * @param nom
     * @return
     */
    @GetMapping(value = "/Pret/Nom/{nom}")
    public List<Pret> getListPretAbonneNom(@PathVariable String nom){
        try {
            return pretDao.getListPretAbonneNom(nom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneNom() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un prenom
     * @param prenom
     * @return
     */
    @GetMapping(value = "/Pret/Prenom/{prenom}")
    public List<Pret> getListPretAbonnePrenom(@PathVariable String prenom){
        try {
            return pretDao.getListPretAbonnePrenom(prenom);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePrenom() erreur : "+e);
            return null;
        }
    }

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
    public List<Pret> getListPretAbonnePseudoEmailNomPrenomBibliotheque(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom,@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoEmailNomPrenomBibliotheque(pseudo,email,nom,prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmailNomPrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email, nom et l'id d'une bibliotheque
     * @param pseudo
     * @param email
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailNomBibliotheque/{pseudo},{email},{nom},{bibliothequeId}")
    public List<Pret> getListPretAbonnePseudoEmailNomBibliotheque(@PathVariable String pseudo,@PathVariable String email,@PathVariable String nom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoEmailNomBibliotheque(pseudo,email,nom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmailNomBibliotheque() erreur : "+e);
            return null;
        }
    }


    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email, prenom et l'id d'une bibliotheque
     * @param pseudo
     * @param email
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailPrenomBibliotheque/{pseudo},{email},{prenom},{bibliothequeId}")
    public List<Pret> getListPretAbonnePseudoEmailPrenomBibliotheque(@PathVariable String pseudo,@PathVariable String email,@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoEmailPrenomBibliotheque(pseudo,email,prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmailPrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, nom, prenom et bibliotequeId
     * @param pseudo
     * @param nom
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNomPrenom/{pseudo},{nom},{prenom},{bibliothequeId")
    public List<Pret> getListPretAbonnePseudoNomPrenomBibliotheque(@PathVariable String pseudo,@PathVariable String nom,@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoNomPrenomBibliotheque(pseudo,nom,prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoNomPrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email, nom, prenom et l'id d'une bibliotheque
     * @param email
     * @param nom
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailNomPrenomBibliotheque/{email},{nom},{prenom},{bibliothequeId}")
    public List<Pret> getListPretAbonneEmailNomPrenomBibliotheque(@PathVariable String email,@PathVariable String nom,@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonneEmailNomPrenomBibliotheque(email,nom,prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoNomPrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, email et l'id d'une bibliotheque
     * @param pseudo
     * @param email
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoEmailBibliotheque/{pseudo},{email},{bibliothequeId}")
    public List<Pret> getListPretAbonnePseudoEmailBibliotheque(@PathVariable String pseudo,@PathVariable String email,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoEmailBibliotheque(pseudo,email,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoEmailBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un nom, prenom et l'id d'une bibliotheque
     * @param nom
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/NomPrenomBibliotheque/{nom},{prenom},{bibliothequeId}")
    public List<Pret> getListPretAbonneNomPrenomBibliotheque(@PathVariable String nom,@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonneNomPrenomBibliotheque(nom,prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneNomPrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, prenom et l'id d'une bibliotheque
     * @param pseudo
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoPrenomBibliotheque/{pseudo},{prenom},{bibliothequeId}")
    public List<Pret> getListPretAbonnePseudoPrenomBibliotheque(@PathVariable String pseudo,@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoPrenomBibliotheque(pseudo,prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoPrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email, nom et l'id d'une bibliothèque
     * @param email
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailNomBibliotheque/{email},{nom},{bibliothequeId}")
    public List<Pret> getListPretAbonneEmailNomBibliotheque(@PathVariable String email,@PathVariable String nom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonneEmailNomBibliotheque(email,nom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneEmailNomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email, prenom et l'id d'une biblbiotheque
     * @param email
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailPrenomBibliotheque/{email},{prenom},{bibliothequeId}")
    public List<Pret> getListPretAbonneEmailPrenomBibliotheque(@PathVariable String email,@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonneEmailPrenomBibliotheque(email,prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneEmailPrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo, nom et l'adresse id d'une bibliotheque
     * @param pseudo
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoNomBibliotheque/{pseudo},{nom},{bibliothequeId}")
    public List<Pret> getListPretAbonnePseudoNomBibliotheque(@PathVariable String pseudo,@PathVariable String nom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoNomBibliotheque(pseudo,nom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoNomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un pseudo et l'id d'une bibliotheque
     * @param pseudo
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PseudoBibliotheque/{pseudo},{bibliothequeId}")
    public List<Pret> getListPretAbonnePseudoBibliotheque(@PathVariable String pseudo,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePseudoBibliotheque(pseudo,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePseudoBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un email et l'id d'une bibliotheque
     * @param email
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/EmailBibliotheque/{email},{bibliothequeId}")
    public List<Pret> getListPretAbonneEmailBibliotheque(@PathVariable String email,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonneEmailBibliotheque(email,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneEmailBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un nom et l'id d'une bibliotheque
     * @param nom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/NomBibliotheque/{nom},{bibliothequeId}")
    public List<Pret> getListPretAbonneNomBibliotheque(@PathVariable String nom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonneNomBibliotheque(nom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonneNomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer une liste de prêts via un prenom et l'id d'une bibliotheque
     * @param prenom
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Pret/PrenomBibliotheque/{prenom},{bibliothequeId}")
    public List<Pret> getListPretAbonnePrenomBibliotheque(@PathVariable String prenom,@PathVariable Integer bibliothequeId){
        try {
            return pretDao.getListPretAbonnePrenomBibliotheque(prenom,bibliothequeId);
        }catch (Exception e){
            logger.error("Methode getListPretAbonnePrenomBibliotheque() erreur : "+e);
            return null;
        }
    }

    /**
     * Méthode pour supprimer un prêt en cours
     * @param id
     */
    @DeleteMapping (value = "/Pret/{id}")
    public void delete(@PathVariable Integer id) {
        pretDao.deleteById(id);
    }
}
