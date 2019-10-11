package fr.oc.projet.microserviceillustration.web.controller;

import fr.oc.projet.microserviceillustration.dao.IllustrationDao;
import fr.oc.projet.microserviceillustration.model.Illustration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IllustrationController {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private IllustrationDao illustrationDao;

    /**
     * Méthode pour récupèrer une illustration via id
     * @param id
     * @return
     */
    @GetMapping(value = "/Illustration/{id}")
    public Illustration getIllustration(@PathVariable int id) {
        try {
            return getIllustrationDao().findById(id);
        }catch (Exception e){
            getLogger().error("Methode getCategorie() erreur : "+e);
            return null;
        }
    }

    protected Logger getLogger() {
        return logger;
    }

    protected IllustrationDao getIllustrationDao() {
        return illustrationDao;
    }
}
