package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Categorie;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CategorieRM implements RowMapper<Categorie> {

    @Override
    public Categorie mapRow(ResultSet resultSet, int i) throws SQLException {
        Categorie categorie = new Categorie();
        categorie.setNom(resultSet.getString("nom"));
        categorie.setDescription(resultSet.getString("description"));
        categorie.setId(resultSet.getInt("id"));
        return categorie;
    }
}
