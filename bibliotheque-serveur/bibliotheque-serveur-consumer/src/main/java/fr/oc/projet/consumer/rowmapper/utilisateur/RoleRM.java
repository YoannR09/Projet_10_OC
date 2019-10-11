package fr.oc.projet.consumer.rowmapper.utilisateur;


import fr.oc.projet.model.beans.utilisateur.Role;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RoleRM implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet resultSet, int i) throws SQLException {

        Role role = new Role();
        role.setId(resultSet.getInt("id"));
        role.setRole(resultSet.getString("role"));
        role.setDescription(resultSet.getString("description"));
        return role;
    }
}
