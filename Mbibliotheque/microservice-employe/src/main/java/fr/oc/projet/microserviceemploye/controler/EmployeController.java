package fr.oc.projet.microserviceemploye.controler;

import fr.oc.projet.microserviceemploye.dao.EmployeDao;
import fr.oc.projet.microserviceemploye.model.Employe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeController {

    @Autowired
    private EmployeDao employeDao;

    private static final Logger logger = LogManager.getLogger();

    /**
     * Méthode pour récupèrer un employé via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Employe/Id/{id}")
    public Employe findById(@PathVariable int id){
        try{
            return getEmployeDao().findById(id);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    /**
     * Méthode pour récupèrer un employé via une adresse électronnique
     * @param email
     * @return
     */
    @GetMapping(value = "/Employe/Email/{email}")
    public Employe findByEmail(@PathVariable String email){
        try{
            return getEmployeDao().findByEmail(email);
        }catch (Exception e){
            getLogger().error(e);
            return null;
        }
    }

    protected EmployeDao getEmployeDao() {
        return employeDao;
    }

    protected Logger getLogger() {
        return logger;
    }
}

