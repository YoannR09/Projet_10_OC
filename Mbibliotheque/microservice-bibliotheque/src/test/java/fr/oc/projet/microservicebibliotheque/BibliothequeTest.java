package fr.oc.projet.microservicebibliotheque;

import fr.oc.projet.microservicebibliotheque.model.Bibliotheque;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliothequeTest {

    private Bibliotheque bibliotheque = new Bibliotheque();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        bibliotheque.setId(4);

        // WHEN
        Integer id = bibliotheque.getId();

        // THEN
        assertEquals(id,new Integer(4));
    }

    @Test
    public void nomSettersGettersTest() {
        // GIVEN
        bibliotheque.setNom("nom");

        // WHEN
        String nom = bibliotheque.getNom();

        // THEN
        assertEquals(nom,"nom");
    }

    @Test
    public void numeroSiretSettersGettersTest() {
        // GIVEN
        bibliotheque.setNumeroSiret("siret");

        // WHEN
        String siret = bibliotheque.getNumeroSiret();

        // THEN
        assertEquals(siret,"siret");
    }

    @Test
    public void adresseIdSettersGettersTest() {
        // GIVEN
        bibliotheque.setAdresseId(3);

        // WHEN
        Integer adresseId = bibliotheque.getAdresseId();

        // THEN
        assertEquals(adresseId,new Integer(3));
    }
}
