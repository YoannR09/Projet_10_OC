package fr.oc.projet.microserviceadresse;

import fr.oc.projet.microserviceadresse.dao.AdresseDao;
import fr.oc.projet.microserviceadresse.model.Adresse;
import fr.oc.projet.microserviceadresse.web.controller.AdresseController;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class AdresseControllerTest {

    private                 AdresseDao          dao;
    private static          Logger              log;
    private                 AdresseController   controller;

    @Test
    public void getAdresse(){
        // GIVEN
        Adresse adresse = new Adresse();
        adresse.setCodePostal("83110");
        when(dao.findById(anyInt())).thenReturn(adresse);

        // WHEN
        Adresse adresseTest = controller.getAdresse(4);

        // THEN
        assertEquals(adresseTest.getCodePostal(),"83110");
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getAdresse(4));
    }

    @Test
    public void getAdresseAll(){
        // GIVEN
        Adresse adresse = new Adresse();
        adresse.setId(44);
        when(dao.findByCodePostalAndNumeroAndRueAndPaysAndVille(anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(adresse);

        // WHEN
        Adresse adresseTest = controller.getAdresseAll("t","O","22","Fr","es");

        // THEN
        assertEquals(adresseTest.getId(),new Integer(44));
        when(dao.findByCodePostalAndNumeroAndRueAndPaysAndVille(anyString(),anyString(),anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getAdresseAll("t","TR","42","ts","fr"));
    }

    @Test
    public void addAdresse() {
        // GIVEN
        List<Adresse> vList = new ArrayList<>();
        vList.add(new Adresse());
        when(dao.save(any(Adresse.class))).then((Answer<Void>) invocationOnMock -> {
            vList.add(new Adresse());
            return null;
        });

        // WHEN
        controller.addAdresse(new Adresse());

        // THEN
        assertEquals(vList.size(),2);
        when(dao.save(any(Adresse.class))).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        controller.addAdresse(new Adresse());
    }

    @Test
    public void updateAdresse(){
        // GIVEN
        Adresse adresse = new Adresse();
        reset(dao);
        when(dao.save(any(Adresse.class))).then((Answer<Void>) invocationOnMock -> {
            adresse.setCodePostal("83190");
            return null;
        });

        // WHEN
        controller.updateAdresse(adresse);

        // THEN
        assertEquals(adresse.getCodePostal(),"83190");
        reset(dao);
        when(dao.save(any(Adresse.class))).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        controller.updateAdresse(new Adresse());
    }

    @Before
    public void init() {
        controller = new AdresseControllerFake();
        dao = mock(AdresseDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
    }

    public class AdresseControllerFake extends AdresseController {
        @Override
        protected AdresseDao getAdresseDao() {
            return dao;
        }

        @Override
        protected Logger getLogger() {
            return log;
        }
    }
}
