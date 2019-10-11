package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.BibliothequeDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.BibliothequeRM;
import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BibliothequeDaoImpl extends AbstractDaoImpl implements BibliothequeDao {

    @Inject
    BibliothequeRM bibliothequeRM;

    @Override
    public Bibliotheque getBibliotheque(Integer pId) {
        String vSQL = "SELECT * FROM bibliotheque WHERE id ="+pId;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        Bibliotheque bibliotheque = vJdbcTemplate.queryForObject(vSQL,bibliothequeRM);

        return bibliotheque;
    }

    @Override
    public Bibliotheque getBibliothequeNom(String nom) {
        String vSQL = "SELECT * FROM bibliotheque WHERE nom = "+"'"+nom+"'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        Bibliotheque bibliotheque = vJdbcTemplate.queryForObject(vSQL,bibliothequeRM);

        return bibliotheque;
    }

    @Override
    public List<Bibliotheque> getListBibliotheque() {
        String vSQL = "SELECT * FROM bibliotheque ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Bibliotheque> vList = vJdbcTemplate.query(vSQL,bibliothequeRM);
        return vList;
    }
}
