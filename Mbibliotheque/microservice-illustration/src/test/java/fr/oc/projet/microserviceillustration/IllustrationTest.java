package fr.oc.projet.microserviceillustration;

import fr.oc.projet.microserviceillustration.model.Illustration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IllustrationTest {

    private static Integer ID = new Integer(4);
    private static String URL = "url";
    private static String DESCRIPTION = "description";
    private static String TYPE = "type";

    private Illustration illustration = new Illustration();

    @Test
    public void idSettersGettersTest() {
        // GIVEN
        illustration.setId(ID);

        // WHEN
        Integer id = illustration.getId();

        // THEN
        assertEquals(id,ID);
    }

    @Test
    public void urlSettersGettersTest() {
        // GIVEN
        illustration.setUrl(URL);

        // WHEN
        String url = illustration.getUrl();

        // THEN
        assertEquals(url,URL);
    }

    @Test
    public void descriptionSettersGettersTest() {
        // GIVEN
        illustration.setDescription(DESCRIPTION);

        // WHEN
        String description = illustration.getDescription();

        // THEN
        assertEquals(description,DESCRIPTION);
    }

    @Test
    public void typeIllustrationSettersGettersTest() {
        // GIVEN
        illustration.setTypeIllustration(TYPE);

        // WHEN
        String type = illustration.getTypeIllustration();

        // THEN
        assertEquals(type,TYPE);
    }
}
