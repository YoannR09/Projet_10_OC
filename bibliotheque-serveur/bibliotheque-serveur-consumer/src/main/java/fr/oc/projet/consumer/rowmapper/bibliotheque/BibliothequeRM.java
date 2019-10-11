package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.consumer.contract.dao.utilisateur.AdresseDao;
import fr.oc.projet.model.beans.bibliotheque.Bibliotheque;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class BibliothequeRM implements RowMapper<Bibliotheque> {

    @Inject
    AdresseDao adresseDao;

    @Override
    public Bibliotheque mapRow(ResultSet resultSet, int i) throws SQLException {
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.setId(resultSet.getInt("id"));
        bibliotheque.setNom(resultSet.getString("nom"));
        bibliotheque.setAdresse(adresseDao.getAdresse(resultSet.getInt("adresse_id")));
        bibliotheque.setNumeroSiret(resultSet.getString("numero_siret"));
        return bibliotheque;
    }
}
