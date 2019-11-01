package fr.oc.projet.microservicereservation;

import fr.oc.projet.microservicereservation.model.Reservation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReservationTest {


    private     Integer         ID;
    private     Reservation     resa;

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        resa.setId(ID);

        // WHEN
        Integer id = resa.getId();

        // THEN
        assertEquals(id,ID);
    }

    @Test
    public void abonneIdSettersGettersTest() {
        // GIVEN
        resa.setAbonneId(ID);

        // WHEN
        Integer abonneId = resa.getAbonneId();

        // THEN
        assertEquals(abonneId,ID);
    }

    @Test
    public void livreIdSettersGettersTest() {
        // GIVEN
        resa.setLivreId(ID);

        // WHEN
        Integer livreId = resa.getLivreId();

        // THEN
        assertEquals(livreId,ID);
    }

    @Test
    public void bibliothequeIdSettersGettersTest() {
        // GIVEN
        resa.setBibliothequeId(ID);

        // WHEN
        Integer bibliothequeId = resa.getBibliothequeId();

        // THEN
        assertEquals(bibliothequeId,ID);
    }

    @Test
    public void livreUniqueIdSettersGettersTest() {
        // GIVEN
        resa.setLivreUniqueId(ID);

        // WHEN
        Integer livreUniqueId = resa.getLivreUniqueId();

        // THEN
        assertEquals(livreUniqueId,ID);
    }
}
