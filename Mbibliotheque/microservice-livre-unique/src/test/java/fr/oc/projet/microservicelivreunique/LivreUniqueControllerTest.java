package fr.oc.projet.microservicelivreunique;

import fr.oc.projet.microservicelivreunique.dao.LivreUniqueDao;
import fr.oc.projet.microservicelivreunique.model.LivreUnique;
import fr.oc.projet.microservicelivreunique.web.controller.LivreUniqueController;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LivreUniqueControllerTest {


    private LivreUniqueDao dao;
    private static Logger log;
    private static String STRING = "anyString";
    private static Integer ID = new Integer(47);
    private LivreUniqueController controller;
    private List<LivreUnique> vList;

    @Test
    public void findById(){
        // GIVEN
        LivreUnique livreUnique = new LivreUnique();
        livreUnique.setDisponible(true);
        when(dao.findById(anyInt())).thenReturn(livreUnique);

        // WHEN
        LivreUnique livreUniqueTest = controller.findById(ID);

        // THEN
        assertTrue(livreUniqueTest.getDisponible());
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findById(ID));
    }

    @Test
    public void countLivreUniqueBibliotheque(){
        // GIVEN
        when(dao.countLivreUniqueByLivreIdAndBibliothequeIdAndDisponibleIsTrue(anyInt(),anyInt())).thenReturn(33);

        // WHEN
        Integer count = controller.countLivreUniqueBibliotheque(ID,ID);

        // THEN
        assertEquals(count,new Integer(33));
        when(dao.countLivreUniqueByLivreIdAndBibliothequeIdAndDisponibleIsTrue(anyInt(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.countLivreUniqueBibliotheque(ID,ID));
    }

    @Test
    public void countLivreUnique(){
        // GIVEN
        when(dao.countLivreUniqueByLivreIdAndDisponibleIsTrue(anyInt())).thenReturn(22);

        // WHEN
        Integer count = controller.countLivreUnique(ID);

        // THEN
        assertEquals(count,new Integer(22));
        when(dao.countLivreUniqueByLivreIdAndDisponibleIsTrue(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.countLivreUnique(ID));
    }

    @Test
    public void getListLivreUniqueTitreAuteurISBN(){
        // GIVEN
        when(dao.getListLivreUniqueTitreAuteurISBN(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitreAuteurISBN(STRING,STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitreAuteurISBN(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitreAuteurISBN(STRING,STRING,STRING));
    }

    @Test
    public void getListLivreUniqueTitreAuteur(){
        // GIVEN
        when(dao.getListLivreUniqueTitreAuteur(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitreAuteur(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitreAuteur(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitreAuteur(STRING,STRING));
    }

    @Test
    public void getListLivreUniqueAuteurISBN(){
        // GIVEN
        when(dao.getListLivreUniqueAuteurISBN(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueAuteurISBN(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueAuteurISBN(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueAuteurISBN(STRING,STRING));
    }

    @Test
    public void getListLivreUniqueTitreISBN(){
        // GIVEN
        when(dao.getListLivreUniqueTitreISBN(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitreISBN(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitreISBN(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitreISBN(STRING,STRING));
    }


    @Test
    public void getListLivreUniqueTitre(){
        // GIVEN
        when(dao.getListLivreUniqueTitre(anyString())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitre(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitre(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitre(STRING));
    }


    @Test
    public void getListLivreUniqueAuteur(){
        // GIVEN
        when(dao.getListLivreUniqueAuteur(anyString())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueAuteur(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueAuteur(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueAuteur(STRING));
    }

    @Test
    public void getListLivreUniqueISBN(){
        // GIVEN
        when(dao.getListLivreUniqueISBN(anyString())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueISBN(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueISBN(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueISBN(STRING));
    }

    @Test
    public void getListLivreUniqueTitreAuteurISBNBibliotheque(){
        // GIVEN
        when(dao.getListLivreUniqueTitreAuteurISBNBibliotheque(anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitreAuteurISBNBibliotheque(STRING,STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitreAuteurISBNBibliotheque(anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitreAuteurISBNBibliotheque(STRING,STRING,STRING,ID));
    }

    @Test
    public void getListLivreUniqueTitreAuteurBibliotheque(){
        // GIVEN
        when(dao.getListLivreUniqueTitreAuteurBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitreAuteurBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitreAuteurBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitreAuteurBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListLivreUniqueAuteurISBNBibliotheque(){
        // GIVEN
        when(dao.getListLivreUniqueAuteurISBNBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueAuteurISBNBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueAuteurISBNBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueAuteurISBNBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListLivreUniqueTitreISBNBibliotheque(){
        // GIVEN
        when(dao.getListLivreUniqueTitreISBNBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitreISBNBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitreISBNBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitreISBNBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListLivreUniqueTitreBibliotheque(){
        // GIVEN
        when(dao.getListLivreUniqueTitreBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueTitreBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueTitreBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueTitreBibliotheque(STRING,ID));
    }

    @Test
    public void getListLivreUniqueAuteurBibliotheque(){
        // GIVEN
        when(dao.getListLivreUniqueAuteurBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueAuteurBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueAuteurBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueAuteurBibliotheque(STRING,ID));
    }


    @Test
    public void getListLivreUniqueISBNBibliotheque(){
        // GIVEN
        when(dao.getListLivreUniqueISBNBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUniqueISBNBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListLivreUniqueISBNBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUniqueISBNBibliotheque(STRING,ID));
    }

    @Test
    public void getListLivreUnique(){
        // GIVEN
        when(dao.findAll()).thenReturn(vList);

        // WHEN
        List<LivreUnique> list = controller.getListLivreUnique();

        // THEN
        assertEquals(list.size(),2);
        when(dao.findAll()).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListLivreUnique());
    }

    @Test
    public void updateDispo(){
        // GIVEN
        LivreUnique livreUnique = new LivreUnique();
        when(dao.save(any(LivreUnique.class))).then((Answer<Void>) invocationOnMock -> {
            livreUnique.setDisponible(false);
            return null;
        });

        // WHEN
        controller.updateDispo(livreUnique);

        // THEN
        assertFalse(livreUnique.getDisponible());
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        controller.updateDispo(livreUnique);
    }

    @Before
    public void init(){
        controller = new LivreUniqueControllerFake();
        dao = mock(LivreUniqueDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
        vList = new ArrayList<>();
        vList.add(new LivreUnique());
        vList.add(new LivreUnique());
    }

    public class LivreUniqueControllerFake extends LivreUniqueController {
        @Override
        protected LivreUniqueDao getLivreUniqueDao() {
            return dao;
        }

        @Override
        protected Logger getLogger() {
            return log;
        }
    }
}
