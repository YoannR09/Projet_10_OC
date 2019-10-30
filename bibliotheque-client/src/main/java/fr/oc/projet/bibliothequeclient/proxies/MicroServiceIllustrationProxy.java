package fr.oc.projet.bibliothequeclient.proxies;

import fr.oc.projet.bibliothequeclient.beans.Illustration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * Classe pour récupérer les données du MicroServiceIllustration
 */
@FeignClient(value = "microservice-illustration", url = "192.168.1.61:9093")
public interface MicroServiceIllustrationProxy {

    /**
     * Méthode pour récupérer une illustration via un id
     * @param id
     * @return
     */
    @GetMapping(value = "/Illustration/{id}")
    Illustration getIllustration(@PathVariable("id") int id);
}
