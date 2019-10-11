package fr.oc.projet.microservicebibliotheque;

import fr.oc.projet.microservicebibliotheque.dao.BibliothequeDao;
import fr.oc.projet.microservicebibliotheque.model.Bibliotheque;
import fr.oc.projet.microservicebibliotheque.web.controller.BibliothequeController;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class BibliothequeControllerTest {

    private static      Logger                  log;
    private             BibliothequeDao         dao;
    private             BibliothequeController  controller;

    @Test
    public void getBibliotheque() {
        // GIVEN
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.setAdresseId(3);
        when(dao.findById(anyInt())).thenReturn(bibliotheque);

        // WHEN
        Bibliotheque bibliothequeTest = controller.getBibliotheque(4);

        // THEN
        assertEquals(bibliothequeTest.getAdresseId(),3);
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getBibliotheque(4));
    }

    @Test
    public void findByNom() {
        // GIVEN
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.setAdresseId(3);
        when(dao.findByNom(anyString())).thenReturn(bibliotheque);

        // WHEN
        Bibliotheque bibliothequeTest = controller.findByNom("Test");

        // THEN
        assertEquals(bibliothequeTest.getAdresseId(),3);
        when(dao.findByNom(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByNom("test"));
    }

    @Test
    public void findAll(){
        // GIVEN
        Bibliotheque bibliotheque1 = new Bibliotheque();
        Bibliotheque bibliotheque2 = new Bibliotheque();
        List<Bibliotheque> vList = new ArrayList<>();
        vList.add(bibliotheque1);
        vList.add(bibliotheque2);
        when(dao.findAll()).thenReturn(vList);

        // WHEN
        List<Bibliotheque> list = controller.findAll();

        // THEN
        assertEquals(list.size(),2);
        when(dao.findAll()).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findAll());
    }

    @Before
    public void init() {
        controller = new BibliothequeControllerFake();
        dao = mock(BibliothequeDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
    }

    public class BibliothequeControllerFake extends BibliothequeController {
        @Override
        protected BibliothequeDao getBibliothequeDao() {
            return dao;
        }

        @Override
        protected Logger getLogger() {
            return log;
        }
    }
}
