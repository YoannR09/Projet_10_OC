package fr.oc.projet.microserviceemploye;

import fr.oc.projet.microserviceemploye.model.Employe;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class EmployeTest {

    private static String MDP = "mdp";
    private static String NOM = "nom";
    private static String PRENOM = "prenom";
    private static String EMAIL = "email";
    private static String NUMERO = "numero";
    private static String MATRICULE = "matricule";
    private static Integer ID = new Integer(4);
    private static Integer ADRESSEID = new Integer(5);
    private static Integer ROLEID = new Integer(2);
    private static Date DATE = new Date();

    private Employe employe = new Employe();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        employe.setId(ID);

        // WHEN
        Integer id = employe.getId();

        // THEN
        assertEquals(id,ID);
    }

    @Test
    public void motDePasseSettersGettersTest() {
        // GIVEN
        employe.setMotDePasse(MDP);

        // WHEN
        String mdp = employe.getMotDePasse();

        // THEN
        assertEquals(mdp,MDP);
    }

    @Test
    public void emailSettersGettersTest() {
        // GIVEN
        employe.setEmail(EMAIL);

        // WHEN
        String email = employe.getEmail();

        // THEN
        assertEquals(email,EMAIL);
    }

    @Test
    public void numeroTelephoneSettersGettersTest() {
        // GIVEN
        employe.setNumeroTelephone(NUMERO);

        // WHEN
        String numero = employe.getNumeroTelephone();

        // THEN
        assertEquals(numero,NUMERO);
    }

    @Test
    public void nomSettersGettersTest() {
        // GIVEN
        employe.setNom(NOM);

        // WHEN
        String nom = employe.getNom();

        // THEN
        assertEquals(nom,NOM);
    }

    @Test
    public void prenomSettersGettersTest() {
        // GIVEN
        employe.setPrenom(PRENOM);

        // WHEN
        String prenom = employe.getPrenom();

        // THEN
        assertEquals(prenom,PRENOM);
    }

    @Test
    public void matriculeSettersGettersTest() {
        // GIVEN
        employe.setMatricule(MATRICULE);

        // WHEN
        String matricule = employe.getMatricule();

        // THEN
        assertEquals(matricule,MATRICULE);
    }

    @Test
    public void dateentreeSettersGettersTest() {
        // GIVEN
        employe.setDateentree(DATE);

        // WHEN
        Date date = employe.getDateentree();

        // THEN
        assertEquals(date,DATE);
    }

    @Test
    public void datesortieSettersGettersTest() {
        // GIVEN
        employe.setDatesortie(DATE);

        // WHEN
        Date date = employe.getDatesortie();

        // THEN
        assertEquals(date,DATE);
    }

    @Test
    public void roleIdSettersGettersTest() {
        // GIVEN
        employe.setRoleId(ROLEID);

        // WHEN
        Integer roleId = employe.getRoleId();

        // THEN
        assertEquals(roleId,ROLEID);
    }

    @Test
    public void adresseIdSettersGettersTest() {
        // GIVEN
        employe.setAdresseId(ADRESSEID);

        // WHEN
        Integer adresseId = employe.getAdresseId();

        // THEN
        assertEquals(adresseId,ADRESSEID);
    }

}
