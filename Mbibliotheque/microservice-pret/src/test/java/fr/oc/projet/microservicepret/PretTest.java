package fr.oc.projet.microservicepret;

import fr.oc.projet.microservicepret.model.Pret;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PretTest {

    private static          Integer         ID              = 3;
    private static          Integer         ABONNEID        = 44;
    private static          Integer         LIVREID         = 52;
    private static          Date            DATE            = new Date();
    private static          Boolean         PROLONGATION    = false;

    private Pret pret = new Pret();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        pret.setId(ID);

        // WHEN
        Integer id = pret.getId();

        // THEN
        assertEquals(id,ID);
    }

    @Test
    public void dateEmpruntSettersGettersTest() {
        // GIVEN
        pret.setDateEmprunt(DATE);

        // WHEN
        Date date = pret.getDateEmprunt();

        // THEN
        assertEquals(date,DATE);
    }

    @Test
    public void dateRestitutionSettersGettersTest() {
        // GIVEN
        pret.setDateRestitution(DATE);

        // WHEN
        Date date = pret.getDateRestitution();

        // THEN
        assertEquals(date,DATE);
    }

    public void prolongationSettersGettersTest() {
        // GIVEN
        pret.setProlongation(PROLONGATION);

        // WHEN
        Boolean pro = pret.getProlongation();

        // THEN
        assertFalse(pro);
    }

    @Test
    public void abonneIdSettersGettersTest() {
        // GIVEN
        pret.setAbonneId(ABONNEID);

        // WHEN
        Integer abonneId = pret.getAbonneId();

        // THEN
        assertEquals(abonneId,ABONNEID);
    }

    @Test
    public void livreUniqueIdSettersGettersTest() {
        // GIVEN
        pret.setLivreUniqueId(LIVREID);

        // WHEN
        Integer livreId = pret.getLivreUniqueId();

        // THEN
        assertEquals(livreId,LIVREID);
    }
}
