package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.CategorieDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.CategorieRM;
import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;
import fr.oc.projet.model.beans.bibliotheque.Categorie;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CategorieDaoImpl extends AbstractDaoImpl implements CategorieDao {

    @Inject
    CategorieRM categorieRM;

    @Override
    public Categorie getCategorie(Integer pId) {
        String vSQL = "SELECT * FROM categorie WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Categorie categorie = vJdbcTemplate.queryForObject(vSQL,categorieRM);
        return categorie;
    }

    @Override
    public List<Categorie> getListCategorie() {
        String vSQL = "SELECT * FROM categorie ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Categorie> vList = vJdbcTemplate.query(vSQL,categorieRM);
        return vList;
    }
}
