package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoSecteur;
import fr.banane.projet6.consumer.contract.dao.DaoSpot;
import fr.banane.projet6.consumer.impl.rowmapper.SpotRM;
import fr.banane.projet6.model.bean.Spot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoSpot}
 *
 * @author Banane
 */
@Named
public class DaoSpotImpl extends AbstractDao implements DaoSpot {

    @Inject
    SpotRM spotRM;
    @Inject
    DaoSecteur daoSecteurImpl;

    @Override
    public boolean create(Spot obj) {

        String vSQL = "INSERT INTO spot (nom, id_createur, officiel, departement, adresse, description) VALUES (:nom, :id_createur, :officiel, :departement, :adresse, :descrption)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_createur", obj.getCreateur().getId(), Types.INTEGER);
        vParams.addValue("officiel", obj.isOfficiel(), Types.BOOLEAN);
        vParams.addValue("departement", obj.getDepartement(), Types.INTEGER);
        vParams.addValue("adresse", obj.getAdresse(), Types.VARCHAR);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public Spot read(int id) {
        String vSQL = "SELECT * FROM spot WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        Spot vSpot = vListSpot.get(0);
        return vSpot;
    }

    @Override
    public Spot read(String code) {
        return null;
    }

    @Override
    public List<Spot> readAll() {
        String vSQL = "SELECT * FROM spot";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        return vListSpot;
    }

    @Override
    public List<Spot> readAll(int id_createur) {
        String vSQL = "SELECT * FROM spot WHERE id_createur="+id_createur;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        return vListSpot;
    }

    @Override
    public boolean update(Spot obj) {

        String vSQL = "UPDATE spot SET nom=:nom, id_createur=:id_createur, officiel=:officiel, departement=:departement, adresse=:adresse, description=:descrption WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_createur", obj.getCreateur().getId(), Types.INTEGER);
        vParams.addValue("officiel", obj.isOfficiel(), Types.BOOLEAN);
        vParams.addValue("departement", obj.getDepartement(), Types.INTEGER);
        vParams.addValue("adresse", obj.getAdresse(), Types.VARCHAR);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Spot obj) {
        //supression des secteurs liées à l'id du spot
        daoSecteurImpl.deleteAll(obj.getId());

        String vSQL = "DELETE FROM spot WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);

        return false;
    }

    @Override
    public int getCountSpot() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbSpot = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM spot", Integer.class);
        return vNbSpot;
    }
}
