package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoLongueur;
import fr.banane.projet6.consumer.contract.dao.DaoVoie;
import fr.banane.projet6.consumer.impl.rowmapper.VoieRM;
import fr.banane.projet6.model.bean.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoVoie}
 *
 * @author Banane
 */
@Named
public class DaoVoieImpl extends AbstractDao implements DaoVoie {

    @Inject
    VoieRM voieRM;

    @Inject
    DaoLongueur daoLongueurImpl;

    @Override
    public boolean create(Voie obj) {
        String vSQL = "INSERT INTO voie (nom, id_secteur, id_difficulte, description) VALUES (:nom, :id_secteur, :id_difficulte, :descrption)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_secteur", obj.getId_secteur(), Types.INTEGER);
        vParams.addValue("id_difficulte", obj.getDifficulte().getId(), Types.INTEGER);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public Voie read(int id) {
        String vSQL = "SELECT * FROM voie WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, voieRM);
        Voie vVoie = vListVoie.get(0);
        return vVoie;
    }

    @Override
    public Voie read(String code) {
        return null;
    }

    @Override
    public List<Voie> readAll() {
        String vSQL = "SELECT * FROM voie";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, voieRM);
        return vListVoie;
    }

    @Override
    public List<Voie> readAll(int id) {
        String vSQL = "SELECT * FROM voie WHERE id_secteur="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Voie> vListVoie = vJdbcTemplate.query(vSQL, voieRM);
        return vListVoie;
    }

    @Override
    public boolean update(Voie obj) {
        String vSQL = "UPDATE voie SET nom = :nom, id_secteur = :id_secteur, id_difficulte = :id_difficulte, description = :descrption WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_secteur", obj.getId_secteur(), Types.INTEGER);
        vParams.addValue("id_difficulte", obj.getDifficulte().getId(), Types.INTEGER);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Voie obj) {

        //supression des longueurs liées à l'id de la voie
        daoLongueurImpl.deleteAll(obj.getId());

        String vSQL = "DELETE FROM voie WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);

        return false;
    }

    @Override
    public boolean deleteAll(int id_secteur) {
        String vSQL = "DELETE FROM voie WHERE id_secteur = ?";
        //TODO à tester
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, id_secteur);
        return false;
    }

    @Override
    public int getCountVoie() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbVoie = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM voie", Integer.class);
        return vNbVoie;
    }
}