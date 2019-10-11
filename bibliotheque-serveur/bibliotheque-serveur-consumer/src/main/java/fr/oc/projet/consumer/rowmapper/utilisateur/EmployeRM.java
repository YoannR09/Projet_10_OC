package fr.oc.projet.consumer.rowmapper.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.AdresseDao;
import fr.oc.projet.consumer.contract.dao.utilisateur.RoleDao;
import fr.oc.projet.model.beans.utilisateur.Employe;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class EmployeRM implements RowMapper<Employe> {

    @Inject
    AdresseDao adresseDao;
    @Inject
    RoleDao roleDao;

    @Override
    public Employe mapRow(ResultSet resultSet, int i) throws SQLException {
        Employe employe = new Employe();
        employe.setId(resultSet.getInt("id"));
        employe.setMotDePasse(resultSet.getString("mot_de_passe"));
        employe.setMatricule(resultSet.getString("matricule"));
        employe.setNom(resultSet.getString("nom"));
        employe.setPrenom(resultSet.getString("prenom"));
        employe.setNumeroTelephone(resultSet.getString("numero_telephone"));
        employe.setDateEntree(resultSet.getDate("dateentree"));
        employe.setDateSortie(resultSet.getDate("datesortie"));
        employe.setEmail(resultSet.getString("email"));
        employe.setAdresse(adresseDao.getAdresse(resultSet.getInt("adresse_id")));
        employe.setRole(roleDao.getRole(resultSet.getInt("role_id")));
        return employe;
    }
}
