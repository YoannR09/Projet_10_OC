package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.model.beans.bibliotheque.Illustration;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class IllustrationRM implements RowMapper<Illustration> {

    @Override
    public Illustration mapRow(ResultSet resultSet, int i) throws SQLException {
        Illustration illustration = new Illustration();
        illustration.setId(resultSet.getInt("id"));
        illustration.setUrl(resultSet.getString("url"));
        illustration.setDescription(resultSet.getString("description"));
        illustration.setTypeIllustration(resultSet.getString("type_illustration"));
        return illustration;
    }
}
