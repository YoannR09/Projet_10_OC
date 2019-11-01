package fr.oc.projet.microservicereservation;

import fr.oc.projet.microservicereservation.controller.ReservationController;
import fr.oc.projet.microservicereservation.dao.ReservationDao;
import fr.oc.projet.microservicereservation.model.Reservation;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ReservationControllerTest {

    private             ReservationDao          dao;
    private             ReservationController   controller;
    private static      Logger                  log;
    private             List<Reservation>       vList;
    private static      Integer                 ID = 44;

    @Test
    public void getReservation(){

        // GIVEN
        Reservation resa = new Reservation();
        resa.setLivreId(2);
        resa.setLivreUniqueId(5);
        when(dao.findById(anyInt())).thenReturn(resa);

        // WHEN
        Reservation resaTest = controller.getReservation(ID);

        // THEN
        assertEquals(resaTest.getLivreId(),new Integer(2));
        assertEquals(resaTest.getLivreUniqueId(),new Integer(5));
    }

    @Test
    public void countReservationsByLivreIdAndBibliothequeId(){

        // GIVEN
        when(dao.countReservationsByLivreIdAndBibliothequeId(anyInt(),anyInt())).thenReturn(12);

        // WHEN
        Integer count = controller.countReservationsByLivreIdAndBibliothequeId(ID,ID);

        // THEN
        assertEquals(count,new Integer(12));
        when(dao.countReservationsByLivreIdAndBibliothequeId(anyInt(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.countReservationsByLivreIdAndBibliothequeId(ID,ID));
    }

    @Test
    public void findByBibliothequeId(){

        // GIVEN
        Reservation resa = new Reservation();
        resa.setLivreId(2);
        resa.setLivreUniqueId(5);
        when(dao.findByBibliothequeId(anyInt())).thenReturn(vList);

        // WHEN
        List<Reservation> listTest = controller.findByBibliothequeId(ID);

        // THEN
        assertEquals(listTest.size(),2);
        when(dao.findByBibliothequeId(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByBibliothequeId(ID));
    }

    @Test
    public void findByAbonneId(){

        // GIVEN
        Reservation resa = new Reservation();
        resa.setLivreId(2);
        resa.setLivreUniqueId(5);
        when(dao.findByAbonneId(anyInt())).thenReturn(vList);

        // WHEN
        List<Reservation> listTest = controller.findByAbonneId(ID);

        // THEN
        assertEquals(listTest.size(),2);
        when(dao.findByAbonneId(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByAbonneId(ID));
    }

    @Test
    public void findByBibliothequeIdAndAbonneId(){

        // GIVEN
        Reservation resa = new Reservation();
        resa.setLivreId(2);
        resa.setLivreUniqueId(5);
        when(dao.findByBibliothequeIdAndAbonneId(anyInt(),anyInt())).thenReturn(vList);

        // WHEN
        List<Reservation> listTest = controller.findByBibliothequeIdAndAbonneId(ID,ID);

        // THEN
        assertEquals(listTest.size(),2);
    }

    @Test
    public void findByBibliothequeIdAndAbonneIdAndLivreId(){

        // GIVEN
        Reservation resa = new Reservation();
        resa.setLivreId(2);
        resa.setLivreUniqueId(5);
        when(dao.findByBibliothequeIdAndAbonneIdAndLivreId(anyInt(),anyInt(),anyInt())).thenReturn(vList);

        // WHEN
        List<Reservation> listTest = controller.findByBibliothequeIdAndAbonneIdAndLivreId(ID,ID,ID);

        // THEN
        assertEquals(listTest.size(),2);
        when(dao.findByBibliothequeIdAndAbonneIdAndLivreId(anyInt(),anyInt(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByBibliothequeIdAndAbonneIdAndLivreId(ID,ID,ID));
    }

    @Test
    public void findByBibliothequeIdAndLivreId(){

        // GIVEN
        Reservation resa = new Reservation();
        resa.setLivreId(2);
        resa.setLivreUniqueId(5);
        when(dao.findByBibliothequeIdAndLivreId(anyInt(),anyInt())).thenReturn(vList);

        // WHEN
        List<Reservation> listTest = controller.findByBibliothequeIdAndLivreId(ID,ID);

        // THEN
        assertEquals(listTest.size(),2);
        when(dao.findByBibliothequeIdAndLivreId(anyInt(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByBibliothequeIdAndLivreId(ID,ID));
    }

    @Test
    public void findByAbonneIdAndLivreId(){

        // GIVEN
        Reservation resa = new Reservation();
        resa.setLivreId(2);
        resa.setLivreUniqueId(5);
        when(dao.findByAbonneIdAndLivreId(anyInt(),anyInt())).thenReturn(vList);

        // WHEN
        List<Reservation> listTest = controller.findByAbonneIdAndLivreId(ID,ID);

        // THEN
        assertEquals(listTest.size(),2);
        when(dao.findByAbonneIdAndLivreId(anyInt(),anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByAbonneIdAndLivreId(ID,ID));
    }

    @Test
    public void delete(){
        // WHEN


    }

    public void addReservation(@RequestBody Reservation reservation){

    }

    public void updateReservation(@RequestBody Reservation reservation){

    }


    @Before
    public void init(){
        controller = new ReservationControllerFake();
        dao = mock(ReservationDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
        vList = new ArrayList<>();
        vList.add(new Reservation());
        vList.add(new Reservation());
    }

    public class ReservationControllerFake extends ReservationController {
        @Override
        protected ReservationDao getDao() {
            return dao;
        }

        @Override
        protected Logger getLogger() {
            return log;
        }
    }

}
