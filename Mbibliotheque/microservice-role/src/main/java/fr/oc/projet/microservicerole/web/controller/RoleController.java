package fr.oc.projet.microservicerole.web.controller;

import fr.oc.projet.microservicerole.dao.RoleDao;
import fr.oc.projet.microservicerole.model.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private RoleDao roleDao;

    /**
     * Récupère un role via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Role/{id}")
    public Role getRole(@PathVariable int id){
        try {
            return roleDao.findById(id);
        }catch (Exception e){
            logger.error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }
}
