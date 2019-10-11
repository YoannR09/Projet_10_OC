package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.AdresseDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.AdresseRM;
import fr.oc.projet.model.beans.utilisateur.Adresse;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AdresseDaoImpl extends AbstractDaoImpl implements AdresseDao {

    @Inject
    AdresseRM adresseRM;

    @Override
    public Adresse getAdresse(Integer pId) {
        String vSQL = "SELECT * FROM adresse WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Adresse adresse = vJdbcTemplate.queryForObject(vSQL, adresseRM);
        return adresse;
    }
}
