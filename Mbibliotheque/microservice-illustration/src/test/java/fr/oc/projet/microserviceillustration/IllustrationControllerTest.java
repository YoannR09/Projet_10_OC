package fr.oc.projet.microserviceillustration;

import fr.oc.projet.microserviceillustration.dao.IllustrationDao;
import fr.oc.projet.microserviceillustration.model.Illustration;
import fr.oc.projet.microserviceillustration.web.controller.IllustrationController;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;


public class IllustrationControllerTest {

    private IllustrationDao dao;
    private IllustrationController controller;
    private static Logger log;

    private static String URL = "url";

    @Test
    public void getIllustration() {
        // GIVEN
        Illustration illustration = new Illustration();
        illustration.setUrl(URL);
        when(dao.findById(anyInt())).thenReturn(illustration);

        // WHEN
        Illustration illustrationTest = controller.getIllustration(5);

        // THEN
        assertEquals(illustrationTest.getUrl(),URL);
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getIllustration(5));
    }

    @Before
    public void init(){
        controller = new IllustrationControllerFake();
        dao = mock(IllustrationDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
    }

    public class IllustrationControllerFake extends IllustrationController {
        @Override
        protected Logger getLogger() {
            return log;
        }

        @Override
        protected IllustrationDao getIllustrationDao() {
            return dao;
        }
    }
}
