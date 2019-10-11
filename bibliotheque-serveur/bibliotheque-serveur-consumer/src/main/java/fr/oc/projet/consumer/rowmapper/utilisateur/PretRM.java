package fr.oc.projet.consumer.rowmapper.utilisateur;

import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreUniqueDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.AbonneDao;
import fr.oc.projet.model.beans.utilisateur.Pret;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class PretRM implements RowMapper<Pret> {

    @Inject
    private AbonneDao abonneDao;
    @Inject
    private LivreUniqueDao livreUniqueDao;


    @Override
    public Pret mapRow(ResultSet resultSet, int i) throws SQLException {
        Pret pret = new Pret();
        pret.setId(resultSet.getInt("id"));
        pret.setDateEmprunt(resultSet.getDate("date_emprunt"));
        pret.setDateRestitution(resultSet.getDate("date_restitution"));
        pret.setProlongation(resultSet.getBoolean("prolongation"));
        pret.setAbonne(abonneDao.getAbonne(resultSet.getInt("abonne_id")));
        pret.setLivreUnique(livreUniqueDao.getLivreUnique(resultSet.getInt("livre_unique_id")));
        return pret;
    }
}
