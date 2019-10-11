package fr.oc.projet.microserviceabonne;

import fr.oc.projet.microserviceabonne.model.Abonne;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbonneTest {

    private Abonne abonne = new Abonne();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        abonne.setId(4);

        // WHEN
        Integer id = abonne.getId();

        // THEN
        assertEquals(id,new Integer(4));
    }

    @Test
    public void pseudoSettersGettersTest() {
        // GIVEN
        abonne.setPseudo("pseudo");

        // WHEN
        String pseudo = abonne.getPseudo();

        // THEN
        assertEquals(pseudo,"pseudo");
    }

    @Test
    public void emailSettersGettersTest() {
        // GIVEN
        abonne.setEmail("email");

        // WHEN
        String email = abonne.getEmail();

        // THEN
        assertEquals(email,"email");
    }

    @Test
    public void motDePasseSettersGettersTest() {
        // GIVEN
        abonne.setMotDePasse("mdp");

        // WHEN
        String motDePasse = abonne.getMotDePasse();

        // THEN
        assertEquals(motDePasse,"mdp");
    }

    @Test
    public void nomSettersGettersTest() {
        // GIVEN
        abonne.setNom("nom");

        // WHEN
        String nom = abonne.getNom();

        // THEN
        assertEquals(nom,"nom");
    }

    @Test
    public void prenomSettersGettersTest() {
        // GIVEN
        abonne.setPrenom("prenom");

        // WHEN
        String prenom = abonne.getPrenom();

        // THEN
        assertEquals(prenom,"prenom");
    }

    @Test
    public void numeroTelephoneSettersGettersTest() {
        // GIVEN
        abonne.setNumeroTelephone("numero");

        // WHEN
        String numero = abonne.getNumeroTelephone();

        // THEN
        assertEquals(numero,"numero");
    }

    @Test
    public void adresseIdSettersGettersTest() {
        // GIVEN
        abonne.setAdresseId(2);

        // WHEN
        Integer adresseId = abonne.getAdresseId();

        // THEN
        assertEquals(adresseId,new Integer(2));
    }

    @Test
    public void roleIdSettersGettersTest() {
        // GIVEN
        abonne.setRoleId(1);

        // WHEN
        Integer roleId = abonne.getRoleId();

        // THEN
        assertEquals(roleId,new Integer(1));
    }

    @Test
    public void bibliothequeIdSettersGettersTest() {
        // GIVEN
        abonne.setBibliothequeId(7);

        // WHEN
        Integer bibliothequeId = abonne.getBibliothequeId();

        // THEN
        assertEquals(bibliothequeId,new Integer(7));
    }
}
