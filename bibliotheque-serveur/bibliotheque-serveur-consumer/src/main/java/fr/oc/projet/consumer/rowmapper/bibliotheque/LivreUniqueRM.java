package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.BibliothequeDao;
import fr.oc.projet.consumer.contract.dao.bibliotheque.LivreDao;
import fr.oc.projet.model.beans.bibliotheque.LivreUnique;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class LivreUniqueRM implements RowMapper<LivreUnique> {

    @Inject
    LivreDao livreDao;
    @Inject
    BibliothequeDao bibliothequeDao;

    @Override
    public LivreUnique mapRow(ResultSet resultSet, int i) throws SQLException {
        LivreUnique livreUnique = new LivreUnique();
        livreUnique.setId(resultSet.getInt("id"));
        livreUnique.setLivre(livreDao.getLivre(resultSet.getInt("livre_id")));
        livreUnique.setBibliotheque(bibliothequeDao.getBibliotheque(resultSet.getInt("bibliotheque_id")));
        livreUnique.setDisponible(resultSet.getBoolean("disponible"));
        livreUnique.setNumeroInterne(resultSet.getString("numero_interne"));
        return livreUnique;
    }
}
