package fr.oc.projet.consumer.rowmapper.utilisateur;

import fr.oc.projet.model.beans.utilisateur.Adresse;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class AdresseRM implements RowMapper<Adresse> {

    @Override
    public Adresse mapRow(ResultSet resultSet, int i) throws SQLException {
        Adresse adresse = new Adresse();
        adresse.setCodePostal(resultSet.getString("code_postal"));
        adresse.setNumero(resultSet.getString("numero"));
        adresse.setRue(resultSet.getString("rue"));
        adresse.setVille(resultSet.getString("ville"));
        adresse.setPays(resultSet.getString("pays"));
        return adresse;
    }
}
