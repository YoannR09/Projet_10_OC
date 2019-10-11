package fr.oc.projet.microservicecategorie;

import fr.oc.projet.microservicecategorie.model.Categorie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategorieTest {

    private Categorie categorie = new Categorie();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        categorie.setId(45);

        // WHEN
        Integer id = categorie.getId();

        // THEN
        assertEquals(id,new Integer(45));
    }

    @Test
    public void nomSettersGettersTest() {
        // GIVEN
        categorie.setNom("nom");

        // WHEN
        String nom = categorie.getNom();

        // THEN
        assertEquals(nom,"nom");
    }

    @Test
    public void descriptionSettersGettersTest() {
        // GIVEN
        categorie.setDescription("description");

        // WHEN
        String description = categorie.getDescription();

        // THEN
        assertEquals(description,"description");
    }
}
