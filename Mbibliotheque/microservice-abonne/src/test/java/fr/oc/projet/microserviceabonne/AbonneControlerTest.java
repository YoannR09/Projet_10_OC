package fr.oc.projet.microserviceabonne;

import fr.oc.projet.microserviceabonne.dao.AbonneDao;
import fr.oc.projet.microserviceabonne.model.Abonne;
import fr.oc.projet.microserviceabonne.web.controller.AbonneController;
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

public class AbonneControlerTest {

    private                 AbonneDao           dao;
    private static          Logger              log;
    private                 AbonneController    controller;
    private                 List<Abonne>        vList;
    private                 Abonne              abonne1;
    private                 Abonne              abonne2;


    @Test
    public void getAbonne(){
        // GIVEN
        Abonne abonne = new Abonne();
        abonne.setEmail("test");
        when(dao.findById(anyInt())).thenReturn(abonne);

        // WHEN
        Abonne abonneTest = controller.getAbonne(4);

        // THEN
        assertEquals(abonneTest.getEmail(),"test");
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getAbonne(4));
    }

    @Test
    public void getAbonnePseudo(){
        // GIVEN
        Abonne abonne = new Abonne();
        abonne.setEmail("test");
        when(dao.findByPseudo(anyString())).thenReturn(abonne);

        // WHEN
        Abonne abonneTest = controller.getAbonnePseudo("Pat");

        // THEN
        assertEquals(abonneTest.getEmail(),"test");
        when(dao.findByPseudo(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getAbonnePseudo("Pat"));
    }


    @Test
    public void getAbonneEmail(){
        // GIVEN
        Abonne abonne = new Abonne();
        abonne.setPrenom("Yoann");
        when(dao.findByEmail(anyString())).thenReturn(abonne);

        // WHEN
        Abonne abonneTest = controller.getAbonneEmail("Pat");

        // THEN
        assertEquals(abonneTest.getPrenom(),"Yoann");
        when(dao.findByEmail(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getAbonneEmail("Pat"));
    }

    @Test
    public void getListByPseudo(){
        // GIVEN
        when(dao.getListByPseudo(anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.getListByPseudo("Bob");

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListByPseudo(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListByPseudo("Bob"));
    }

    @Test
    public void getListByEmail(){
        // GIVEN
        when(dao.getListByEmail(anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.getListByEmail("Bob");

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListByEmail(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListByEmail("Bob"));
    }



    @Test
    public void findByNom(){
        // GIVEN
        when(dao.findByNom(anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByNom("Bob");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByNom(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByNom("Bob"));
    }


    @Test
    public void findByPrenom(){
        // GIVEN
        when(dao.findByPrenom(anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPrenom("Bob");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPrenom(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPrenom("Bob"));
    }

    @Test
    public void findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(){
        // GIVEN
        when(dao.findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(anyString(),anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining("Bob","t","A","B");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining(anyString(),anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPseudoContainingAndEmailContainingAndNomContainingAndPrenomContaining("Bob","t","A","B"));
    }

    @Test
    public void findByPseudoContainingAndEmailContainingAndNomContaining(){
        // GIVEN
        when(dao.findByPseudoContainingAndEmailContainingAndNomContaining(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPseudoContainingAndEmailContainingAndNomContaining("t","A","B");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPseudoContainingAndEmailContainingAndNomContaining(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPseudoContainingAndEmailContainingAndNomContaining("t","A","B"));
    }

    @Test
    public void findByPseudoContainingAndEmailContainingAndPrenomContaining(){
        // GIVEN
        when(dao.findByPseudoContainingAndEmailContainingAndPrenomContaining(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPseudoContainingAndEmailContainingAndPrenomContaining("t","A","B");

        // THEN
        assertEquals(list.size(),2);
        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPseudoContainingAndEmailContainingAndPrenomContaining(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPseudoContainingAndEmailContainingAndPrenomContaining("t","A","B"));
    }

    @Test
    public void findByPseudoContainingAndNomContainingAndPrenomContaining(){
        // GIVEN
        when(dao.findByPseudoContainingAndNomContainingAndPrenomContaining(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPseudoContainingAndNomContainingAndPrenomContaining("t","A","B");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPseudoContainingAndNomContainingAndPrenomContaining(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPseudoContainingAndNomContainingAndPrenomContaining("t","A","B"));
    }

    @Test
    public void findByEmailContainingAndNomContainingAndPrenomContaining(){
        // GIVEN
        when(dao.findByEmailContainingAndNomContainingAndPrenomContaining(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByEmailContainingAndNomContainingAndPrenomContaining("t","A","B");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByEmailContainingAndNomContainingAndPrenomContaining(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByEmailContainingAndNomContainingAndPrenomContaining("t","A","B"));
    }

    @Test
    public void findByPseudoContainingAndEmailContaining(){
        // GIVEN
        when(dao.findByPseudoContainingAndEmailContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPseudoContainingAndEmailContaining("t","A");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPseudoContainingAndEmailContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPseudoContainingAndEmailContaining("t","A"));
    }

    @Test
    public void findByNomContainingAndPrenomContaining(){
        // GIVEN
        when(dao.findByNomContainingAndPrenomContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByNomContainingAndPrenomContaining("t","A");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByNomContainingAndPrenomContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByNomContainingAndPrenomContaining("t","A"));
    }

    @Test
    public void findByPseudoContainingAndPrenomContaining(){
        // GIVEN
        when(dao.findByPseudoContainingAndPrenomContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPseudoContainingAndPrenomContaining("t","A");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPseudoContainingAndPrenomContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPseudoContainingAndPrenomContaining("t","A"));
    }

    @Test
    public void findByEmailContainingAndNomContaining(){
        // GIVEN
        when(dao.findByEmailContainingAndNomContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByEmailContainingAndNomContaining("t","A");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByEmailContainingAndNomContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByEmailContainingAndNomContaining("t","A"));
    }

    @Test
    public void findByEmailContainingAndPrenomContaining(){
        // GIVEN
        when(dao.findByEmailContainingAndPrenomContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByEmailContainingAndPrenomContaining("t","A");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByEmailContainingAndPrenomContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByEmailContainingAndPrenomContaining("t","A"));
    }

    @Test
    public void findByPseudoContainingAndNomContaining(){
        // GIVEN
        when(dao.findByPseudoContainingAndNomContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findByPseudoContainingAndNomContaining("t","A");

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByPseudoContainingAndNomContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByPseudoContainingAndNomContaining("t","A"));
    }

    @Test
    public void addAbonne() {
        // GIVEN
        List<Abonne> fakeList = vList;
        Abonne abonne = new Abonne();
        reset(dao);
        when(dao.save(any(Abonne.class))).then((Answer<Void>) invocationOnMock -> {
            fakeList.add(abonne);
            return null;
        });

        // WHEN
        controller.addAbonne(abonne);

        // THEN
        assertEquals(fakeList.size(),3);
        when(dao.save(any(Abonne.class))).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        controller.addAbonne(abonne);
    }

    @Test
    public void updateAbonne() {
        // GIVEN
        Abonne abonne = new Abonne();
        reset(dao);
        when(dao.save(any(Abonne.class))).then((Answer<Void>) invocationOnMock -> {
            abonne.setPrenom("Yoann");
            return null;
        });

        // WHEN
        controller.updateAbonne(abonne);

        // THEN
        assertEquals(abonne.getPrenom(),"Yoann");
        when(dao.save(any(Abonne.class))).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        controller.updateAbonne(abonne);
    }

    @Test
    public void findALL(){
        // GIVEN
        when(dao.findAll()).thenReturn(vList);

        // WHEN
        List<Abonne> list = controller.findALL();

        // THEN
        assertEquals(list.size(),2);
        when(dao.findAll()).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findALL());
    }

    @Before
    public void init() {
        controller = new AbonneControllerFake();
        dao = mock(AbonneDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
        abonne1 = new Abonne();
        abonne1.setPrenom("Yoann");
        abonne2 = new Abonne();
        abonne2.setPrenom("Bob");
        vList = new ArrayList<>();
        vList.add(abonne1);
        vList.add(abonne2);
    }

    private class AbonneControllerFake extends AbonneController {
        @Override
        protected Logger getLogger() {
            return log;
        }

        @Override
        protected AbonneDao getAbonneDao() {
            return dao;
        }
    }
}


