package fr.oc.projet.microservicelivre;

import fr.oc.projet.microservicelivre.model.Livre;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class LivreTest {

    private static      Integer         ID              = new Integer(6);
    private static      String          RESUME          = "resume";
    private static      String          AUTEUR          = "auteur";
    private static      String          EDITEUR         = "editeur";
    private static      String          LANGUE          = "langue";
    private static      String          TITRE           = "titre";
    private static      String          ISBN            = "isbn";
    private static      Date            DATE            = new Date();
    private static      Integer         CATEGORIEID     = new Integer(2);
    private static      Integer         ILLUSTRATIONID  = new Integer(8);

    private Livre livre = new Livre();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        livre.setId(ID);

        // WHEN
        Integer id = livre.getId();

        // THEN
        assertEquals(id, ID);
    }

    @Test
    public void titreSettersGettersTest() {
        // GIVEN
        livre.setTitre(TITRE);

        // WHEN
        String titre = livre.getTitre();

        // THEN
        assertEquals(titre,TITRE);
    }

    @Test
    public void auteurSettersGettersTest() {
        // GIVEN
        livre.setAuteur(AUTEUR);

        // WHEN
        String auteur = livre.getAuteur();

        // THEN
        assertEquals(auteur,AUTEUR);
    }

    @Test
    public void editeurSettersGettersTest() {
        // GIVEN
        livre.setEditeur(EDITEUR);

        // WHEN
        String editeur = livre.getEditeur();

        // THEN
        assertEquals(editeur,EDITEUR);
    }

    @Test
    public void isbnSettersGettersTest() {
        // GIVEN
        livre.setIsbn(ISBN);

        // WHEN
        String isbn = livre.getIsbn();

        // THEN
        assertEquals(isbn,ISBN);
    }

    @Test
    public void langueSettersGettersTest() {
        // GIVEN
        livre.setLangue(LANGUE);

        // WHEN
        String langue = livre.getLangue();

        // THEN
        assertEquals(langue,LANGUE);
    }

    @Test
    public void resumeSettersGettersTest() {
        // GIVEN
        livre.setResume(RESUME);

        // WHEN
        String resume = livre.getResume();

        // THEN
        assertEquals(resume,RESUME);
    }

    @Test
    public void dateDeCreationSettersGettersTest() {
        // GIVEN
        livre.setDateDeCreation(DATE);

        // WHEN
        Date date = livre.getDateDeCreation();

        // THEN
        assertEquals(date,DATE);
    }

    @Test
    public void categorieIdSettersGettersTest() {
        // GIVEN
        livre.setCategorieId(CATEGORIEID);

        // WHEN
        Integer categorieId = livre.getCategorieId();

        // THEN
        assertEquals(categorieId,CATEGORIEID);
    }

    @Test
    public void illustrationIdSettersGettersTest() {
        // GIVEN
        livre.setIllustrationId(ILLUSTRATIONID);

        // WHEN
        Integer illustrationId = livre.getIllustrationId();

        // THEN
        assertEquals(illustrationId, ILLUSTRATIONID);
    }
}
