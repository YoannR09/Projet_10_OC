package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.IllustrationDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.IllustrationRM;
import fr.oc.projet.model.beans.bibliotheque.Illustration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class IllustrationDaoImpl extends AbstractDaoImpl implements IllustrationDao {

    @Inject
    IllustrationRM illustrationRM;

    @Override
    public Illustration getIllustration(Integer pId) {
        String vSQL = "SELECT * FROM illustration WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Illustration illustration = vJdbcTemplate.queryForObject(vSQL, illustrationRM);
        return illustration;
    }

    @Override
    public List<Illustration> getListIllustration() {
        String vSQL = "SELECT * FROM image ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Illustration> vList = vJdbcTemplate.query(vSQL, illustrationRM);
        return vList;
    }
}
