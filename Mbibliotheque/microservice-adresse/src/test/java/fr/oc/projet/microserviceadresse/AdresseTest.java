package fr.oc.projet.microserviceadresse;

import fr.oc.projet.microserviceadresse.model.Adresse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdresseTest {

    Adresse adresse = new Adresse();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        adresse.setId(4);

        // WHEN
        Integer id = adresse.getId();

        // THEN
        assertEquals(id,new Integer(4));
    }

    @Test
    public void numeroSettersGettersTest() {
        // GIVEN
        adresse.setNumero("numero");

        // WHEN
        String numero = adresse.getNumero();

        // THEN
        assertEquals(numero,"numero");
    }

    @Test
    public void rueSettersGettersTest() {
        // GIVEN
        adresse.setRue("rue");

        // WHEN
        String rue = adresse.getRue();

        // THEN
        assertEquals(rue,"rue");
    }

    @Test
    public void codePostalSettersGettersTest() {
        // GIVEN
        adresse.setCodePostal("code");

        // WHEN
        String code = adresse.getCodePostal();

        // THEN
        assertEquals(code,"code");
    }

    @Test
    public void villeSettersGettersTest() {
        // GIVEN
        adresse.setVille("ville");

        // WHEN
        String ville = adresse.getVille();

        // THEN
        assertEquals(ville,"ville");
    }

    @Test
    public void paysSettersGettersTest() {
        // GIVEN
        adresse.setPays("pays");

        // WHEN
        String pays = adresse.getPays();

        // THEN
        assertEquals(pays,"pays");
    }
}
