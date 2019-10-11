package fr.oc.projet.microservicelivre;

import fr.oc.projet.microservicelivre.dao.LivreDao;
import fr.oc.projet.microservicelivre.model.Livre;
import fr.oc.projet.microservicelivre.web.controller.LivreController;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LivreControllerTest {

    private static Integer ID = new Integer(6);
    private static String RESUME = "resume";
    private static String AUTEUR = "auteur";
    private static String TITRE = "titre";
    private static String ISBN = "isbn";
    private static Logger log;
    private LivreDao dao;
    private LivreController controller;
    private List<Livre> vList;


    @Test
    public void getLivre() {
        // GIVEN
        Livre livre = new Livre();
        livre.setResume(RESUME);
        when(dao.findById(anyInt())).thenReturn(livre);

        // WHEN
        Livre livreTest = controller.getLivre(4);

        // THEN
        assertEquals(livreTest.getResume(),RESUME);
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getLivre(5));
    }

    @Test
    public void findLivreByCategorieId(){
        // GIVEN
        when(dao.findLivreByCategorieId(anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivreByCategorieId(4);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivreByCategorieId(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivreByCategorieId(4));
    }

    @Test
    public void findLivresByTitreAndAuteurAndIsbn(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndAuteurContainingAndIsbnContaining(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreAndAuteurAndIsbn(TITRE,AUTEUR,ISBN);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndAuteurContainingAndIsbnContaining(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreAndAuteurAndIsbn(TITRE,AUTEUR,ISBN));
    }

    @Test
    public void findLivresByAuteurContainingAndIsbnContaining(){
        // GIVEN
        when(dao.findLivresByAuteurContainingAndIsbnContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByAuteurContainingAndIsbnContaining(TITRE,ISBN);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByAuteurContainingAndIsbnContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByAuteurContainingAndIsbnContaining(TITRE,ISBN));
    }

    @Test
    public void findLivresByTitreContainingAndIsbnContaining(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndIsbnContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreContainingAndIsbnContaining(TITRE,ISBN);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndIsbnContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreContainingAndIsbnContaining(TITRE,ISBN));
    }

    @Test
    public void findLivresByTitreContainingAndAuteurContaining(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndAuteurContaining(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreContainingAndAuteurContaining(TITRE,ISBN);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndAuteurContaining(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreContainingAndAuteurContaining(TITRE,ISBN));
    }

    @Test
    public void findLivresByTitreContaining(){
        // GIVEN
        when(dao.findLivresByTitreContaining(anyString())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreContaining(TITRE);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContaining(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreContaining(TITRE));
    }

    @Test
    public void findLivresByAuteurContaining(){
        // GIVEN
        when(dao.findLivresByAuteurContaining(anyString())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByAuteurContaining(AUTEUR);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByAuteurContaining(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByAuteurContaining(AUTEUR));
    }

    @Test
    public void findLivresByIsbnContaining(){
        // GIVEN
        when(dao.findLivresByIsbnContaining(anyString())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByIsbnContaining(ISBN);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByIsbnContaining(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByIsbnContaining(ISBN));
    }

    @Test
    public void findLivresByTitreAndAuteurAndIsbnAndCategorieId(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndAuteurContainingAndIsbnContainingAndCategorieId(anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreAndAuteurAndIsbnAndCategorieId(TITRE,AUTEUR,ISBN,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndAuteurContainingAndIsbnContainingAndCategorieId(anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreAndAuteurAndIsbnAndCategorieId(TITRE,AUTEUR,ISBN,ID));
    }

    @Test
    public void findLivresByAuteurContainingAndIsbnContainingAndCategorieId(){
        // GIVEN
        when(dao.findLivresByAuteurContainingAndIsbnContainingAndCategorieId(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByAuteurContainingAndIsbnContainingAndCategorieId(AUTEUR,ISBN,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByAuteurContainingAndIsbnContainingAndCategorieId(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByAuteurContainingAndIsbnContainingAndCategorieId(AUTEUR,ISBN,ID));
    }

    @Test
    public void findLivresByTitreContainingAndIsbnContainingAndCategorieId(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndIsbnContainingAndCategorieId(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreContainingAndIsbnContainingAndCategorieId(TITRE,ISBN,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndIsbnContainingAndCategorieId(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreContainingAndIsbnContainingAndCategorieId(TITRE,ISBN,ID));
    }

    @Test
    public void findLivresByTitreContainingAndAuteurContainingAndCategorieId(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndAuteurContainingAndCategorieId(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreContainingAndAuteurContainingAndCategorieId(TITRE,AUTEUR,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndAuteurContainingAndCategorieId(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreContainingAndAuteurContainingAndCategorieId(TITRE,AUTEUR,ID));
    }

    @Test
    public void findLivresByTitreContainingAndCategorieId(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndCategorieId(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreContainingAndCategorieId(TITRE,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndCategorieId(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreContainingAndCategorieId(TITRE,ID));
    }

    @Test
    public void findLivresByAuteurContainingAndCategorieId(){
        // GIVEN
        when(dao.findLivresByTitreContainingAndCategorieId(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByTitreContainingAndCategorieId(AUTEUR,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByTitreContainingAndCategorieId(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByTitreContainingAndCategorieId(AUTEUR,ID));
    }

    @Test
    public void findLivresByIsbnContainingAndCategorieId(){
        // GIVEN
        when(dao.findLivresByIsbnContainingAndCategorieId(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Livre> list = controller.findLivresByIsbnContainingAndCategorieId(TITRE,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findLivresByIsbnContainingAndCategorieId(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findLivresByIsbnContainingAndCategorieId(TITRE,ID));
    }

    @Before
    public void init(){
        controller = new LivreControllerFake();
        dao = mock(LivreDao.class);
        log = mock(org.apache.logging.log4j.Logger.class);
        doNothing().when(log).warn(anyString());
        vList = new ArrayList<>();
        vList.add(new Livre());
        vList.add(new Livre());
    }

    public class LivreControllerFake extends LivreController {
        @Override
        protected LivreDao getLivreDao() {
            return dao;
        }

        @Override
        protected Logger getLogger() {
            return log;
        }
    }
}
