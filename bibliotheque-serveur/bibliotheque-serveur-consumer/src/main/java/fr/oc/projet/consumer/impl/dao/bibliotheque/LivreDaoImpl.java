package fr.oc.projet.consumer.impl.dao.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.bibliotheque.LivreRM;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LivreDaoImpl extends AbstractDaoImpl implements LivreDao {

    @Inject
    LivreRM livreRM;

    @Override
    public Livre getLivre(Integer pId) {
        String vSQL = "SELECT * FROM livre WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Livre livre = vJdbcTemplate.queryForObject(vSQL,livreRM);
        return livre;
    }

    @Override
    public Livre getLivreTitreAuteurISBN(String titre, String auteur, String isbn) {
        String vSQL = "SELECT * FROM livre WHERE titre LIKE "+"'%"+titre+"%'" +
               " AND auteur LIKE "+"'%"+auteur+"%'" +
                " AND isbn LIKE "+"'%"+isbn+"%'" +
                " LIMIT 1" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL, livreRM);
        if (vList.size() != 0) {
            Livre livre = vList.get(0);
            return livre;
        }else {
            return null;
        }

    }

    @Override
    public Livre getLivreTitreAuteur(String titre, String auteur) {
        String vSQL = "SELECT * FROM livre WHERE titre LIKE "+"'%"+titre+"%'" +
                " AND auteur LIKE "+"'%"+auteur+"%'" +
                " LIMIT 1" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL, livreRM);
        if (vList.size() != 0) {
            Livre livre = vList.get(0);
            return livre;
        }else {
            return null;
        }
    }

    @Override
    public Livre getLivreAuteurISBN(String auteur, String isbn) {
        String vSQL = "SELECT * FROM livre WHERE " +
                " auteur LIKE "+"'%"+auteur+"%'" +
                " AND isbn LIKE "+"'%"+isbn+"%'" +
                " LIMIT 1" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL, livreRM);
        if (vList.size() != 0) {
            Livre livre = vList.get(0);
            return livre;
        }else {
            return null;
        }
    }

    @Override
    public Livre getLivreTitreISBN(String titre, String isbn) {
        String vSQL = "SELECT * FROM livre WHERE titre LIKE "+"'%"+titre+"%'" +
                " AND isbn LIKE "+"'%"+isbn+"%'" +
                " LIMIT 1" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL, livreRM);
        if (vList.size() != 0) {
            Livre livre = vList.get(0);
            return livre;
        }else {
            return null;
        }
    }

    @Override
    public Livre getLivreTitre(String titre) {
        String vSQL = "SELECT * FROM livre WHERE titre LIKE "+"'%"+titre+"%'" +
                " LIMIT 1" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL, livreRM);
        if (vList.size() != 0) {
            Livre livre = vList.get(0);
            return livre;
        }else {
            return null;
        }
    }

    @Override
    public Livre getLivreAuteur(String auteur) {
        String vSQL = "SELECT * FROM livre WHERE "+
                " auteur LIKE "+"'%"+auteur+"%'" +
                " LIMIT 1" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL, livreRM);
        if (vList.size() != 0) {
            Livre livre = vList.get(0);
            return livre;
        }else {
            return null;
        }
    }

    @Override
    public Livre getLivreISBN(String isbn) {
        String vSQL = "SELECT * FROM livre WHERE "+
                " isbn LIKE "+"'%"+isbn+"%'" +
                " LIMIT 1" ;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL, livreRM);
        if (vList.size() != 0) {
            Livre livre = vList.get(0);
            return livre;
        }else {
            return null;
        }
    }

    @Override
    public List<Livre> getListLivre() {
        String vSQL = "SELECT * FROM livre ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Livre> vList = vJdbcTemplate.query(vSQL,livreRM);
        return vList;
    }
}
