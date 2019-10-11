package fr.oc.projet.microservicecategorie;

import fr.oc.projet.microservicecategorie.dao.CategorieDao;
import fr.oc.projet.microservicecategorie.model.Categorie;
import fr.oc.projet.microservicecategorie.web.controller.CategorieController;
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

public class CategorieControllerTest {


    private             CategorieDao                dao;
    private static      Logger                      log;
    private             CategorieController         controller;

    @Test
    public void getCategorie(){
        // GIVEN
        Categorie categorie = new Categorie();
        categorie.setDescription("test");
        when(dao.findById(anyInt())).thenReturn(categorie);

        // WHEN
        Categorie categorieTest = controller.getCategorie(4);

        // THEN
        assertEquals(categorieTest.getDescription(),"test");
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getCategorie(4));
    }

    @Test
    public void findByNom(){
        // GIVEN
        Categorie categorie = new Categorie();
        categorie.setDescription("test");
        when(dao.findByNom(anyString())).thenReturn(categorie);

        // WHEN
        Categorie categorieTest = controller.findByNom("ca");

        // THEN
        assertEquals(categorieTest.getDescription(),"test");
        when(dao.findByNom(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByNom("ca"));
    }

    @Test
    public void getListCategorie(){
        // GIVEN
        Categorie categorie1 = new Categorie();
        Categorie categorie2 = new Categorie();
        List<Categorie> vList = new ArrayList<>();
        vList.add(categorie1);
        vList.add(categorie2);
        when(dao.findAll()).thenReturn(vList);

        // WHEN
        List<Categorie> list = controller.getListCategorie();

        // THEN
        assertEquals(list.size(),2);
        when(dao.findAll()).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListCategorie());
    }

    @Before
    public void init() {
        controller = new CategorieControllerFake();
        dao = mock(CategorieDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
    }

    public class CategorieControllerFake extends CategorieController {
        @Override
        protected Logger getLogger() {
            return log;
        }

        @Override
        protected CategorieDao getCategorieDao() {
            return dao;
        }
    }
}
