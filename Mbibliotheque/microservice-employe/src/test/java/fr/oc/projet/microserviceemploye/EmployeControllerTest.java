package fr.oc.projet.microserviceemploye;

import fr.oc.projet.microserviceemploye.controler.EmployeController;
import fr.oc.projet.microserviceemploye.dao.EmployeDao;
import fr.oc.projet.microserviceemploye.model.Employe;
import javassist.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class EmployeControllerTest {

    private EmployeDao dao;
    private static Logger log;
    private EmployeController controller;


    @Test
    public void findById(){
        // GIVEN
        Employe employe = new Employe();
        employe.setEmail("email");
        when(dao.findById(anyInt())).thenReturn(employe);

        // WHEN
        Employe employeTest = controller.findById(5);

        // THEN
        assertEquals(employeTest.getEmail(),"email");
        when(dao.findById(anyInt())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findById(5));
    }

    @Test
    public void findByEmail() {
        // GIVEN
        Employe employe = new Employe();
        employe.setId(44);
        when(dao.findByEmail(anyString())).thenReturn(employe);

        // WHEN
        Employe employeTest = controller.findByEmail("mail");

        // THEN
        assertEquals(employeTest.getId(),new Integer(44));
        when(dao.findByEmail(anyString())).then((Answer<Void>) invocationOnMock -> {
            throw new NotFoundException("Erreur");
        });
        assertNull(controller.findByEmail("mail"));
    }

    @Before
    public void init(){
        controller = new EmployeControllerFake();
        dao = mock(EmployeDao.class);
        log = mock(Logger.class);
        doNothing().when(log).warn(anyString());
    }

    public class EmployeControllerFake extends EmployeController {
        @Override
        protected EmployeDao getEmployeDao() {
            return dao;
        }

        @Override
        protected Logger getLogger() {
            return log;
        }
    }
}
