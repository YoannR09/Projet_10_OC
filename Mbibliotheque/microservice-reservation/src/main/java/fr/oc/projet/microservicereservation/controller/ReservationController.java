package fr.oc.projet.microservicereservation.controller;

import fr.oc.projet.microservicereservation.dao.ReservationDao;
import fr.oc.projet.microservicereservation.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationDao dao;

    /**
     * Méthode pour récupérer une réservation via un id.
     * @param id
     * @return
     */
    @GetMapping(value = "/Reservation/{id}")
    public Reservation getReservation(@PathVariable int id){
        return dao.findById(id);
    }

    @GetMapping(value = "/Reservation/CountLivreBibliotheque/{livreId},{bibliothequeId}")
    public Integer countReservationsByLivreIdAndBibliothequeId(@PathVariable int livreId,@PathVariable int bibliothequeId){
        return dao.countReservationsByLivreIdAndBibliothequeId(livreId,bibliothequeId);
    }


    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque.
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Reservation/Bibliotheque/{bibliothequeId}")
    public List<Reservation> findByBibliothequeId(@PathVariable int bibliothequeId){
        return dao.findByBibliothequeId(bibliothequeId);
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'un abonné.
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Reservation/Abonne/{abonneId}")
    public List<Reservation> findByAbonneId(@PathVariable int abonneId){
        return dao.findByAbonneId(abonneId);
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque et l'id d'un abonné.
     * @param bibliothequeId
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeAbonne/{bibliothequeId},{abonneId}")
    public List<Reservation> findByBibliothequeIdAndAbonneId(@PathVariable int bibliothequeId,@PathVariable int abonneId){
        return dao.findByBibliothequeIdAndAbonneId(bibliothequeId,abonneId);
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
        return dao.findByBibliothequeIdAndAbonneIdAndLivreId(bibliothequeId,abonneId,livreId);
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque et l'id d'un livre.
     * @param bibliothequeId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeLivre/{bibliothequeId},{livreId}")
    public List<Reservation> findByBibliothequeIdAndLivreId(@PathVariable int bibliothequeId,@PathVariable int livreId){
        return dao.findByBibliothequeIdAndLivreId(bibliothequeId,livreId);
    }

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'un abonné et l'id d'un livre.
     * @param abonneId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/AbonneLivre/{abonneId},{livreId}")
    public List<Reservation> findByAbonneIdAndLivreId(@PathVariable int abonneId,@PathVariable int livreId){
        return dao.findByAbonneIdAndLivreId(abonneId,livreId);
    }

    /**
     * Méthode pour supprimer une réservation
     * @param id
     */
    @DeleteMapping(value = "/Reservation/{id}")
    public void delete(@PathVariable int id){
        dao.deleteById(id);
    }

    /**
     * Méthode pour ajouter une réservation à la bdd.
     * @param reservation
     */
    @PostMapping(value = "/Reservation")
    public void addReservation(@RequestBody Reservation reservation){
        dao.save(reservation);
    }

    /**
     * Méthode pour mettre à jour une réservation.
     * @param reservation
     */
    @PutMapping(value = "/Reservation")
    public void updateReservation(@RequestBody Reservation reservation){
        dao.save(reservation);
    }
}
