package fr.oc.projet.microservicelivreunique;


import fr.oc.projet.microservicelivreunique.model.LivreUnique;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LivreUniqueTest {

    private static      Integer             ID                  = new Integer(4);
    private static      Integer             NUMERO              = new Integer(4456);
    private static      Integer             BIBLIOTHEQUEID      = new Integer(5);
    private static      Integer             LIVREID             = new Integer(45);
    private static      Boolean             DISPONIBLE          = true;

    private LivreUnique livreUnique = new LivreUnique();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        livreUnique.setId(ID);

        // WHEN
        Integer id = livreUnique.getId();

        // THEN
        assertEquals(id,ID);
    }

    @Test
    public void numeroInterneSettersGettersTest() {
        // GIVEN
        livreUnique.setNumero(NUMERO);

        // WHEN
        Integer numero = livreUnique.getNumero();

        // THEN
        assertEquals(numero,NUMERO);
    }

    @Test
    public void bibliothequeIdSettersGettersTest() {
        // GIVEN
        livreUnique.setBibliothequeId(BIBLIOTHEQUEID);

        // WHEN
        Integer bibliothequeId = livreUnique.getBibliothequeId();

        // THEN
        assertEquals(bibliothequeId,BIBLIOTHEQUEID);
    }

    @Test
    public void livreIdSettersGettersTest() {
        // GIVEN
        livreUnique.setLivreId(LIVREID);

        // WHEN
        Integer livreId = livreUnique.getLivreId();

        // THEN
        assertEquals(livreId,LIVREID);
    }

    @Test
    public void disponibleSettersGettersTest() {
        // GIVEN
        livreUnique.setDisponible(DISPONIBLE);

        // WHEN
        Boolean dispo = livreUnique.getDisponible();

        // THEN
        assertTrue(dispo);
    }
}
