package fr.oc.projet.microservicepret;

import fr.oc.projet.microservicepret.dao.PretDao;
import fr.oc.projet.microservicepret.model.Pret;
import fr.oc.projet.microservicepret.web.controller.PretController;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class PretControllerTest {

    private PretDao dao;
    private PretController controller;
    private static Logger log;
    private List<Pret> vList;
    private static String STRING = "anyString";
    private static Integer ID = 44;


    @Test
    public void getPret(){
        // GIVEN
        Pret pret = new Pret();
        pret.setAbonneId(4);
        when(dao.findById(anyInt())).thenReturn(pret);

        // WHEN
        Pret pretTest = controller.getPret(ID);

        // THEN
        assertEquals(pretTest.getAbonneId(),4);
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getPret(ID));
    }

    @Test
    public void findAll(){
        // GIVEN
        when(dao.findAll()).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.findAll();

        // THEN
        assertEquals(list.size(),2);
        when(dao.findAll()).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findAll());
    }

    @Test
    public void getListPretLivre(){
        // GIVEN
        when(dao.getListPretLivre(anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivre(ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivre(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivre(ID));
    }

    @Test
    public void getListPretAbonne(){
        // GIVEN
        when(dao.findByAbonneId(anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonne(ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.findByAbonneId(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonne(ID));
    }

    @Test
    public void getListPretLivreBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreBibliotheque(anyInt(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreBibliotheque(ID,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreBibliotheque(anyInt(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreBibliotheque(ID,ID));
    }

    @Test
    public void getListPretAbonneBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneBibliotheque(anyInt(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneBibliotheque(ID,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneBibliotheque(anyInt(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneBibliotheque(ID,ID));
    }

    @Test
    public void getListPretLivreISBNNumInterne(){
        // GIVEN
        when(dao.getListPretLivreISBNNumInterne(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreISBNNumInterne(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreISBNNumInterne(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreISBNNumInterne(STRING,STRING));
    }

    @Test
    public void getListPretLivreISBNNumInterneBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreISBNNumInterneBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreISBNNumInterneBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreISBNNumInterneBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreISBNNumInterneBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretLivreISBN(){
        // GIVEN
        when(dao.getListPretLivreISBN(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreISBN(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreISBN(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreISBN(STRING));
    }

    @Test
    public void getListPretLivreNumInterne(){
        // GIVEN
        when(dao.getListPretLivreNumInterne(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreNumInterne(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreNumInterne(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreNumInterne(STRING));
    }

    @Test
    public void getListPretLivreISBNBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreISBNBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreISBNBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreISBNBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreISBNBibliotheque(STRING,ID));
    }

    @Test
    public void getListPretLivreNumInterneBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreNumInterneBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreNumInterneBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreNumInterneBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreNumInterneBibliotheque(STRING,ID));
    }

    @Test
    public void addPret() {
        // GIVEN
        List<Pret> fakeList = new ArrayList<>();
        fakeList.add(new Pret());
        reset(dao);
        when(dao.save(any(Pret.class))).then((Answer<Void>) invocationOnMock -> {
            fakeList.add(new Pret());
            return null;
        });

        // WHEN
        controller.addPret(new Pret());

        // THEN
        assertEquals(fakeList.size(),2);
        when(dao.save(any(Pret.class))).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
    }

    @Test
    public void updatePret() {
        // GIVEN
        Pret pret = new Pret();
        pret.setId(44);
        reset(dao);
        when(dao.save(any(Pret.class))).then((Answer<Void>) invocationOnMock -> {
            pret.setId(22);
            return null;
        });

        // WHEN
        controller.updatePret(pret);

        // THEN
        assertEquals(pret.getId(),22);
        when(dao.save(any(Pret.class))).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        controller.updatePret(pret);
    }

    @Test
    public void getListPretLivreTitreAuteurISBN(){
        // GIVEN
        when(dao.getListPretLivreTitreAuteurISBN(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitreAuteurISBN(STRING,STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitreAuteurISBN(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitreAuteurISBN(STRING,STRING,STRING));
    }

    @Test
    public void getListPretLivreTitreISBN(){
        // GIVEN
        when(dao.getListPretLivreTitreISBN(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitreISBN(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitreISBN(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitreISBN(STRING,STRING));
    }

    @Test
    public void getListPretLivreTitreAuteur(){
        // GIVEN
        when(dao.getListPretLivreTitreAuteur(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitreAuteur(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitreAuteur(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitreAuteur(STRING,STRING));
    }

    @Test
    public void getListPretLivreAuteurISBN(){
        // GIVEN
        when(dao.getListPretLivreAuteurISBN(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreAuteurISBN(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreAuteurISBN(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreAuteurISBN(STRING,STRING));
    }

    @Test
    public void getListPretLivreTitre(){
        // GIVEN
        when(dao.getListPretLivreTitre(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitre(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitre(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitre(STRING));
    }

    @Test
    public void getListPretLivreAuteur(){
        // GIVEN
        when(dao.getListPretLivreAuteur(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreAuteur(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreAuteur(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreAuteur(STRING));
    }

    @Test
    public void getListPretLivreTitreAuteurISBNBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreTitreAuteurISBNBibliotheque(anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitreAuteurISBNBibliotheque(STRING,STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitreAuteurISBNBibliotheque(anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitreAuteurISBNBibliotheque(STRING,STRING,STRING,ID));
    }

    @Test
    public void getListPretLivreTitreISBNBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreTitreISBNBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitreISBNBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitreISBNBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitreISBNBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretLivreTitreAuteurBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreTitreAuteurBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitreAuteurBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitreAuteurBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitreAuteurBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretLivreAuteurISBNBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreAuteurISBNBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreAuteurISBNBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreAuteurISBNBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreAuteurISBNBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void  getListPretLivreTitreBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreTitreBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreTitreBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreTitreBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreTitreBibliotheque(STRING,ID));
    }

    @Test
    public void getListPretLivreAuteurBibliotheque(){
        // GIVEN
        when(dao.getListPretLivreAuteurBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretLivreAuteurBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretLivreAuteurBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretLivreAuteurBibliotheque(STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoEmailNomPrenom(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmailNomPrenom(anyString(),anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmailNomPrenom(STRING,STRING,STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmailNomPrenom(anyString(),anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmailNomPrenom(STRING,STRING,STRING,STRING));
    }

    @Test
    public void getListPretAbonnePseudoEmailNom(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmailNom(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmailNom(STRING,STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmailNom(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmailNom(STRING,STRING,STRING));
    }

    @Test
    public void getListPretAbonnePseudoEmailPrenom(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmailPrenom(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmailPrenom(STRING,STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmailPrenom(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmailPrenom(STRING,STRING,STRING));
    }

    @Test
    public void getListPretAbonnePseudoNomPrenom(){
        // GIVEN
        when(dao.getListPretAbonnePseudoNomPrenom(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoNomPrenom(STRING,STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoNomPrenom(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoNomPrenom(STRING,STRING,STRING));
    }

    @Test
    public void getListPretAbonneEmailNomPrenom(){
        // GIVEN
        when(dao.getListPretAbonneEmailNomPrenom(anyString(),anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmailNomPrenom(STRING,STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmailNomPrenom(anyString(),anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmailNomPrenom(STRING,STRING,STRING));
    }

    @Test
    public void getListPretAbonnePseudoEmail(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmail(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmail(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmail(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmail(STRING,STRING));
    }

    @Test
    public void getListPretAbonneNomPrenom(){
        // GIVEN
        when(dao.getListPretAbonneNomPrenom(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneNomPrenom(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneNomPrenom(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneNomPrenom(STRING,STRING));
    }

    @Test
    public void getListPretAbonnePseudoPrenom(){
        // GIVEN
        when(dao.getListPretAbonnePseudoPrenom(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoPrenom(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoPrenom(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoPrenom(STRING,STRING));
    }

    @Test
    public void getListPretAbonneEmailNom(){
        // GIVEN
        when(dao.getListPretAbonneEmailNom(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmailNom(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmailNom(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmailNom(STRING,STRING));
    }

    @Test
    public void getListPretAbonneEmailPrenom(){
        // GIVEN
        when(dao.getListPretAbonneEmailPrenom(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmailPrenom(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmailPrenom(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmailPrenom(STRING,STRING));
    }

    @Test
    public void getListPretAbonnePseudoNom(){
        // GIVEN
        when(dao.getListPretAbonnePseudoNom(anyString(),anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoNom(STRING,STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoNom(anyString(),anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoNom(STRING,STRING));
    }

    @Test
    public void getListPretAbonnePseudo(){
        // GIVEN
        when(dao.getListPretAbonnePseudo(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudo(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudo(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudo(STRING));
    }

    @Test
    public void getListPretAbonneEmail(){
        // GIVEN
        when(dao.getListPretAbonneEmail(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmail(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmail(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmail(STRING));
    }

    @Test
    public void getListPretAbonneNom(){
        // GIVEN
        when(dao.getListPretAbonneNom(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneNom(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneNom(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneNom(STRING));
    }

    @Test
    public void getListPretAbonnePrenom(){
        // GIVEN
        when(dao.getListPretAbonnePrenom(anyString())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePrenom(STRING);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePrenom(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePrenom(STRING));
    }

    @Test
    public void getListPretAbonnePseudoEmailNomPrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmailNomPrenomBibliotheque(anyString(),anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmailNomPrenomBibliotheque(STRING,STRING,STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmailNomPrenomBibliotheque(anyString(),anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmailNomPrenomBibliotheque(STRING,STRING,STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoEmailNomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmailNomBibliotheque(anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmailNomBibliotheque(STRING,STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmailNomBibliotheque(anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmailNomBibliotheque(STRING,STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoEmailPrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmailPrenomBibliotheque(anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmailPrenomBibliotheque(STRING,STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmailPrenomBibliotheque(anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmailPrenomBibliotheque(STRING,STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoNomPrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePseudoNomPrenomBibliotheque(anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoNomPrenomBibliotheque(STRING,STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoNomPrenomBibliotheque(anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoNomPrenomBibliotheque(STRING,STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonneEmailNomPrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneEmailNomPrenomBibliotheque(anyString(),anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmailNomPrenomBibliotheque(STRING,STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmailNomPrenomBibliotheque(anyString(),anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmailNomPrenomBibliotheque(STRING,STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoEmailBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePseudoEmailBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoEmailBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoEmailBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoEmailBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonneNomPrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneNomPrenomBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneNomPrenomBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneNomPrenomBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneNomPrenomBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoPrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneNomPrenomBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneNomPrenomBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneNomPrenomBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneNomPrenomBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonneEmailNomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneEmailNomBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmailNomBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmailNomBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmailNomBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonneEmailPrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneEmailPrenomBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmailPrenomBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmailPrenomBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmailPrenomBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoNomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePseudoNomBibliotheque(anyString(),anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoNomBibliotheque(STRING,STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoNomBibliotheque(anyString(),anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoNomBibliotheque(STRING,STRING,ID));
    }

    @Test
    public void getListPretAbonnePseudoBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePseudoBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePseudoBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePseudoBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePseudoBibliotheque(STRING,ID));
    }

    @Test
    public void getListPretAbonneEmailBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneEmailBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneEmailBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneEmailBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneEmailBibliotheque(STRING,ID));
    }

    @Test
    public void getListPretAbonneNomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonneNomBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonneNomBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonneNomBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonneNomBibliotheque(STRING,ID));
    }

    @Test
    public void getListPretAbonnePrenomBibliotheque(){
        // GIVEN
        when(dao.getListPretAbonnePrenomBibliotheque(anyString(),anyInt())).thenReturn(vList);

        // WHEN
        List<Pret> list = controller.getListPretAbonnePrenomBibliotheque(STRING,ID);

        // THEN
        assertEquals(list.size(),2);
        when(dao.getListPretAbonnePrenomBibliotheque(anyString(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.getListPretAbonnePrenomBibliotheque(STRING,ID));
    }


    @Before
    public void init(){
        controller = new PretControllerFake();
        dao = mock(PretDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
        vList = new ArrayList<>();
        vList.add(new Pret());
        vList.add(new Pret());
    }

    public class PretControllerFake extends PretController {
        @Override
        protected Logger getLogger() {
            return log;
        }

        @Override
        protected PretDao getPretDao() {
            return dao;
        }
    }
}
