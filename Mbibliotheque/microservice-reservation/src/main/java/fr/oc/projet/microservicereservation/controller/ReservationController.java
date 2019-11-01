package fr.oc.projet.microservicereservation.controller;

import fr.oc.projet.microservicereservation.dao.ReservationDao;
import fr.oc.projet.microservicereservation.model.Reservation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationDao dao;

    private static Logger logger = LogManager.getLogger();

    /**
     * Méthode pour récupérer une réservation via un id.
     * @param id
     * @return
     */
    @GetMapping(value = "/Reservation/{id}")
    public Reservation getReservation(@PathVariable int id){
        return getDao().findById(id);
    }

    @GetMapping(value = "/Reservation/CountLivreBibliotheque/{livreId},{bibliothequeId}")
    public Integer countReservationsByLivreIdAndBibliothequeId(@PathVariable int livreId,@PathVariable int bibliothequeId){
        try {
            return getDao().countReservationsByLivreIdAndBibliothequeId(livreId, bibliothequeId);
        }catch (Exception e){
            getLogger().warn(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer la liste des réservations.
     * @return
     */
    @GetMapping(value = "/Reservation")
    public List<Reservation> getListReservation(){
        try {
            return getDao().findAll();
        }catch (Exception e){
            logger.warn(e);
            return null;
        }
    }


    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque.
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Reservation/Bibliotheque/{bibliothequeId}")
    public List<Reservation> findByBibliothequeId(@PathVariable int bibliothequeId){
        try {
            return getDao().findByBibliothequeId(bibliothequeId);
        }catch (Exception e){
            getLogger().warn(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'un abonné.
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Reservation/Abonne/{abonneId}")
    public List<Reservation> findByAbonneId(@PathVariable int abonneId){
        try {
            return getDao().findByAbonneId(abonneId);
        }catch (Exception e){
            getLogger().warn(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque et l'id d'un abonné.
     * @param bibliothequeId
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeAbonne/{bibliothequeId},{abonneId}")
    public List<Reservation> findByBibliothequeIdAndAbonneId(@PathVariable int bibliothequeId,@PathVariable int abonneId){
        try {
            return getDao().findByBibliothequeIdAndAbonneId(bibliothequeId, abonneId);
        }catch (Exception e){
            getLogger().warn(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque, l'id d'un abonné et l'id d'un livre.
     * @param bibliothequeId
     * @param abonneId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeAbonneLivre/{bibliothequeId},{abonneId},{livreId}")
    public List<Reservation> findByBibliothequeIdAndAbonneIdAndLivreId(@PathVariable int bibliothequeId,@PathVariable int abonneId,@PathVariable int livreId){
        try {
            return getDao().findByBibliothequeIdAndAbonneIdAndLivreId(bibliothequeId, abonneId, livreId);
        }catch (Exception e){
            getLogger().warn(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque et l'id d'un livre.
     * @param bibliothequeId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeLivre/{bibliothequeId},{livreId}")
    public List<Reservation> findByBibliothequeIdAndLivreId(@PathVariable int bibliothequeId,@PathVariable int livreId){
        try {
            return getDao().findByBibliothequeIdAndLivreId(bibliothequeId, livreId);
        }catch (Exception e){
            getLogger().warn(e);
            return null;
        }
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'un abonné et l'id d'un livre.
     * @param abonneId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/AbonneLivre/{abonneId},{livreId}")
    public List<Reservation> findByAbonneIdAndLivreId(@PathVariable int abonneId,@PathVariable int livreId){
        try {
            return getDao().findByAbonneIdAndLivreId(abonneId, livreId);
        }catch (Exception e){
            getLogger().warn(e);
            return null;
        }
    }

    /**
     * Méthode pour supprimer une réservation
     * @param id
     */
    @DeleteMapping(value = "/Reservation/{id}")
    public void delete(@PathVariable int id){
        try {
            getDao().deleteById(id);
        }catch (Exception e){
            getLogger().warn(e);
        }
    }

    /**
     * Méthode pour ajouter une réservation à la bdd.
     * @param reservation
     */
    @PostMapping(value = "/Reservation")
    public void addReservation(@RequestBody Reservation reservation){
        try {
            getDao().save(reservation);
        }catch (Exception e){
            getLogger().warn(e);
        }
    }

    /**
     * Méthode pour mettre à jour une réservation.
     * @param reservation
     */
    @PutMapping(value = "/Reservation")
    public void updateReservation(@RequestBody Reservation reservation){
        try {
            getDao().save(reservation);
        }catch (Exception e){
            getLogger().warn(e);
        }
    }

    protected Logger getLogger() {
        return logger;
    }

    protected ReservationDao getDao() {
        return dao;
    }
}
