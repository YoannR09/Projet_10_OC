package fr.oc.projet.consumer.rowmapper.utilisateur;

import fr.oc.projet.consumer.contract.dao.bibliotheque.BibliothequeDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.RoleDao;
import fr.oc.projet.model.beans.utilisateur.Abonne;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class AbonneRM implements RowMapper<Abonne> {

    @Inject
    private RoleDao roleDao;
    @Inject
    private BibliothequeDao bibliothequeDao;

    @Override
    public Abonne mapRow(ResultSet resultSet, int i) throws SQLException {
            Abonne abonne = new Abonne();
            abonne.setId(resultSet.getInt("id"));
            abonne.setPseudo(resultSet.getString("pseudo"));
            abonne.setNom(resultSet.getString("nom"));
            abonne.setPrenom(resultSet.getString("prenom"));
            abonne.setEmail(resultSet.getString("email"));
            abonne.setMotDePasse(resultSet.getString("mot_de_passe"));
            abonne.setNumeroTelephone(resultSet.getString("numero_telephone"));
            abonne.setRole(roleDao.getRole(resultSet.getInt("role_id")));
            abonne.setBibliotheque(bibliothequeDao.getBibliotheque(resultSet.getInt("bibliotheque_id")));
            return abonne;
    }
}
