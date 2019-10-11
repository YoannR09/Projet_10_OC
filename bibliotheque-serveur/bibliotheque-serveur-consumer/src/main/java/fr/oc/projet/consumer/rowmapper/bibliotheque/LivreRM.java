package fr.oc.projet.consumer.rowmapper.bibliotheque;

import fr.oc.projet.consumer.contract.dao.bibliotheque.CategorieDao;
import fr.oc.projet.consumer.contract.dao.bibliotheque.IllustrationDao;
import fr.oc.projet.model.beans.bibliotheque.Livre;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class LivreRM implements RowMapper<Livre> {

    @Inject
    CategorieDao categorieDao;
    @Inject
    IllustrationDao illustrationDao;

    @Override
    public Livre mapRow(ResultSet resultSet, int i) throws SQLException {
        Livre livre = new Livre();
        livre.setId(resultSet.getInt("id"));
        livre.setAuteur(resultSet.getString("auteur"));
        livre.setEditeur(resultSet.getString("editeur"));
        livre.setResume(resultSet.getString("resume"));
        livre.setDateDeCreation(resultSet.getDate("date_de_creation"));
        livre.setIsbn(resultSet.getString("isbn"));
        livre.setTitre(resultSet.getString("titre"));
        livre.setLangue(resultSet.getString("langue"));
        livre.setIllustration(illustrationDao.getIllustration(resultSet.getInt("illustration_id")));
        livre.setCategorie(categorieDao.getCategorie(resultSet.getInt("categorie_id")));
        return livre;
    }
}
