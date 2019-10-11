package fr.oc.projet.consumer.impl.dao.utilisateur;

import fr.oc.projet.consumer.contract.dao.utilisateur.PretDao;
import fr.oc.projet.consumer.impl.dao.AbstractDaoImpl;
import fr.oc.projet.consumer.rowmapper.utilisateur.PretRM;
import fr.oc.projet.model.beans.utilisateur.Pret;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class PretDaoImpl extends AbstractDaoImpl implements PretDao {

    @Inject
    private PretRM pretRM;

    @Override
    public Pret getPret(Integer pId) {
        String vSQL = "SELECT * FROM pret WHERE id ="+pId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        Pret reservation = vJdbcTemplate.queryForObject(vSQL,pretRM);
        return reservation;
    }

    @Override
    public List<Pret> getListPret() {
        String vSQL = "SELECT * FROM pret ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivre(Integer livreId) {
        String vSQL = "SELECT * FROM pret,livre_unique WHERE livre_unique.livre_id = "+livreId +"" +
                " AND livre_unique_id = livre_unique.id ";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretAbonne(Integer abonneId) {
        String vSQL = "SELECT * FROM pret WHERE abonne_id = "+abonneId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivreBibliotheque(Integer livreId, Integer bibliothequeId) {
        String vSQL = "SELECT * FROM pret,livre_unique WHERE livre_unique.livre_id = "+livreId +" " +
                " AND livre_unique_id = livre_unique.id" +
                " AND bibliotheque_id = "+bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretAbonneBibliotheque(Integer abonneId, Integer bibliothequeId) {
        String vSQL = "SELECT * FROM pret,livre_unique WHERE abonne_id = "+abonneId +" " +
                " AND livre_unique.id = livre_unique_id" +
                " AND bibliotheque_id = " +bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivreISBNNumInterne(String isbn, String numInterne) {
        String vSQL = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE "+"'%"+isbn+"%'" +
                " AND livre_unique.numero_interne LIKE "+"'%"+numInterne+"%'"+
                " AND livre_unique_id = livre_unique.id" +
                " AND livre.id = livre_unique.livre_id";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivreISBNNumInterneBibliotheque(String isbn, String numInterne, Integer bibliothequeId) {
            String vSQL = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE "+"'%"+isbn+"%'" +
                    " AND livre_unique.numero_interne LIKE "+"'%"+numInterne+"%'"+
                    " AND livre_unique_id = livre_unique.id" +
                    " AND livre.id = livre_unique.livre_id" +
                    " AND bibliotheque_id = "+bibliothequeId;
            JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
            List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
            return vList;
    }

    @Override
    public List<Pret> getListPretLivreISBN(String isbn) {
        String vSQL = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE "+"'%"+isbn+"%'" +
                " AND livre_unique_id = livre_unique.id" +
                " AND livre.id = livre_unique.livre_id";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivreNumInterne(String numInterne) {
        String vSQL = "SELECT * FROM pret,livre_unique,livre WHERE "+
                " livre_unique.numero_interne LIKE "+"'%"+numInterne+"%'"+
                " AND livre_unique_id = livre_unique.id" +
                " AND livre.id = livre_unique.livre_id";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivreISBNBibliotheque(String isbn, Integer bibliothequeId) {
        String vSQL = "SELECT * FROM pret,livre_unique,livre WHERE isbn LIKE "+"'%"+isbn+"%'" +
                " AND livre_unique_id = livre_unique.id" +
                " AND livre.id = livre_unique.livre_id" +
                " AND bibliotheque_id = "+bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public List<Pret> getListPretLivreNumInterneBibliotheque(String numInterne, Integer bibliothequeId) {
        String vSQL = "SELECT * FROM pret,livre_unique,livre WHERE "+
                " livre_unique.numero_interne LIKE "+"'%"+numInterne+"%'"+
                " AND livre_unique_id = livre_unique.id" +
                " AND livre.id = livre_unique.livre_id" +
                " AND bibliotheque_id = "+bibliothequeId;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Pret> vList = vJdbcTemplate.query(vSQL,pretRM);
        return vList;
    }

    @Override
    public void updateProlongation(Pret pret) {

        String vSQL = "UPDATE pret SET prolongation = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.BOOLEAN, pret.getProlongation()),
                new SqlParameterValue(Types.INTEGER, pret.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void updateDateRestitution(Pret pret) {

        String vSQL = "UPDATE pret SET date_restitution = ? WHERE id = ?";
        Object[] vParams = {
                new SqlParameterValue(Types.DATE, pret.getDateRestitution()),
                new SqlParameterValue(Types.INTEGER, pret.getId()),
        };
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public void deletePret(Integer idPret) {

        String vSQL = "DELETE FROM pret WHERE id = "+idPret;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL);
    }

    @Override
    public void addPret(Pret pret) {
            String vSQL = "INSERT INTO pret (date_emprunt, date_restitution, prolongation, abonne_id, livre_unique_id)" +
                    " VALUES (:dateEmprunt, :dateRestitution, :prolongation, :abonneId, :livreUniqueId)";
            NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
            BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(pret);
            vParams.registerSqlType("dateEmprunt", Types.DATE);
            vParams.registerSqlType("motRestitution", Types.DATE);
            vParams.registerSqlType("prolongation", Types.BOOLEAN);
            vParams.registerSqlType("abonneId", Types.INTEGER);
            vParams.registerSqlType("livreUniqueId", Types.INTEGER);
            vJdbcTemplate.update(vSQL, vParams);
    }
}
