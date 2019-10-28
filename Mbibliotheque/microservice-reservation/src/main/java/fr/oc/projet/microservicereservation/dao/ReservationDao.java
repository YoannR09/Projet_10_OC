package fr.oc.projet.microservicereservation.dao;

import fr.oc.projet.microservicereservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {

    Reservation findById(int id);
    Integer countReservationsByLivreIdAndBibliothequeId(int livreId, int bibliothequeId);
    List<Reservation> findByBibliothequeId(int bibliothequeId);
    List<Reservation> findByAbonneId(int abonneId);
    List<Reservation> findByBibliothequeIdAndAbonneId(int bibliothequeId,int abonneId);
    List<Reservation> findByBibliothequeIdAndAbonneIdAndLivreId(int bibliothequeId,int abonneId,int livreId);
    List<Reservation> findByBibliothequeIdAndLivreId(int bibliothequeId,int livreId);
    List<Reservation> findByAbonneIdAndLivreId(int abonneId,int livreId);
}
