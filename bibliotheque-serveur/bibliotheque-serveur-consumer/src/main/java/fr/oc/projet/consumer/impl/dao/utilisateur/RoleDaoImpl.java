package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.RoleDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.RoleRM;
import fr.oc.projet.model.beans.utilisateur.Role;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class RoleDaoImpl extends AbstractDaoImpl implements RoleDao {

    @Inject
    RoleRM roleRM;

    @Override
    public Role getRole(Integer pId) {
        String vSQL = "SELECT * FROM role WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Role role = vJdbcTemplate.queryForObject(vSQL, roleRM);
        return role;
    }

    @Override
    public List<Role> getListRole() {
        return null;
    }
}
