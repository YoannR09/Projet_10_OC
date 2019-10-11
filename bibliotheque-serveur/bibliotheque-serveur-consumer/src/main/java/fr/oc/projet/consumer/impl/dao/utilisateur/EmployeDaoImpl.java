package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.EmployeDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.EmployeRM;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import fr.oc.projet.model.beans.utilisateur.Employe;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class EmployeDaoImpl extends AbstractDaoImpl implements EmployeDao {


    @Inject
    EmployeRM employeRM;


    @Override
    public Employe getEmploye(Integer pId) {
        String vSQL = "SELECT * FROM employe WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Employe employe = vJdbcTemplate.queryForObject(vSQL, employeRM);
        return employe;
    }

    @Override
    public Employe getEmployeEmail(String email) {
        String vSQL = "SELECT * FROM employe WHERE email ="+"'"+email+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Employe> vList = vJdbcTemplate.query(vSQL, employeRM);
        if (vList.size() != 0) {
            Employe employe = vList.get(0);
            return employe;
        }else {
            return null;
        }
    }

    @Override
    public List<Employe> getListEmploye() {
        String vSQL = "SELECT * FROM employe ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Employe> vList = vJdbcTemplate.query(vSQL,employeRM);
        return vList;
    }
}
