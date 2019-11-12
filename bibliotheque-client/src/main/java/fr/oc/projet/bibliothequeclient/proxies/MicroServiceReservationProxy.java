package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe pour récupèrer les données du MicroServiceReservation
 */
@FeignClient(value = "microservice-reservation",url = "localhost:9085")
public interface MicroServiceReservationProxy {

    /**
     * Méthode pour récupérer une réservation via un id.
     * @param id
     * @return
     */
    @GetMapping(value = "/Reservation/{id}")
    Reservation getReservation(@PathVariable("id") int id);

    @GetMapping(value = "/Reservation/CountLivreBibliotheque/{livreId},{bibliothequeId}")
    Integer countReservationsByLivreIdAndBibliothequeId(@PathVariable("livreId") int livreId,@PathVariable("bibliothequeId") int bibliothequeId);

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque.
     * @param bibliothequeId
     * @return
     */
    @GetMapping(value = "/Reservation/Bibliotheque/{bibliothequeId}")
    List<Reservation> findByBibliothequeId(@PathVariable("bibliothequeId") int bibliothequeId);


    /**
     * Méthode pour récupérer une liste de réservation via l'id d'un abonné.
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Reservation/Abonne/{abonneId}")
    List<Reservation> findByAbonneId(@PathVariable("abonneId") int abonneId);

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque et l'id d'un abonné.
     * @param bibliothequeId
     * @param abonneId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeAbonne/{bibliothequeId},{abonneId}")
    List<Reservation> findByBibliothequeIdAndAbonneId(@PathVariable("bibliothequeId") int bibliothequeId,@PathVariable("abonneId") int abonneId);
    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque, l'id d'un abonné et l'id d'un livre.
     * @param bibliothequeId
     * @param abonneId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeAbonneLivre/{bibliothequeId},{abonneId},{livreId}")
    List<Reservation> findByBibliothequeIdAndAbonneIdAndLivreId(@PathVariable("bibliothequeId") int bibliothequeId,@PathVariable("abonneId") int abonneId,@PathVariable("livreId") int livreId);

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'une bibliotheque et l'id d'un livre.
     * @param bibliothequeId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/BibliothequeLivre/{bibliothequeId},{livreId}")
    List<Reservation> findByBibliothequeIdAndLivreId(@PathVariable("bibliothequeId") int bibliothequeId,@PathVariable("livreId") int livreId);

    /**
     * Méthode pour récupérer une liste de réservation via l'id d'un abonné et l'id d'un livre.
     * @param abonneId
     * @param livreId
     * @return
     */
    @GetMapping(value = "/Reservation/AbonneLivre/{abonneId},{livreId}")
    List<Reservation> findByAbonneIdAndLivreId(@PathVariable("abonneId") int abonneId,@PathVariable("livreId") int livreId);

    /**
     * Méthode pour ajouter une réservation à la bdd.
     * @param reservation
     */
    @PostMapping(value = "/Reservation")
    void addReservation(@RequestBody Reservation reservation);

    /**
     * Méthode pour mettre à jour une réservation.
     * @param reservation
     */
    @PutMapping(value = "/Reservation")
    void updateReservation(@RequestBody Reservation reservation);

    /**
     * Méthode pour supprimer une réservation
     * @param id
     */
    @DeleteMapping(value = "/Reservation/{id}")
    void delete(@PathVariable("id") int id);
}
