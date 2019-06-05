package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoLongueur;
import fr.banane.projet6.consumer.impl.rowmapper.LongueurRM;
import fr.banane.projet6.model.bean.Longueur;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoLongueur}
 *
 * @author Banane
 */
@Named
public class DaoLongueurImpl extends AbstractDao implements DaoLongueur {

    @Inject
    LongueurRM longueurRM;

    @Override
    public boolean create(Longueur obj) {
        String vSQL = "INSERT INTO longueur (id_voie, equipement, nb_point) VALUES (:id_voie, :equipement, :nb_point)";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);
        return false;
    }

    @Override
    public Longueur read(int id) {
        String vSQL = "SELECT * FROM longueur WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Longueur> vListLongueur = vJdbcTemplate.query(vSQL, longueurRM);
        Longueur vLongueur = vListLongueur.get(0);

        return vLongueur;
    }

    @Override
    public Longueur read(String code) {
        return null;
    }

    @Override
    public List<Longueur> readAll() {
        String vSQL = "SELECT * FROM longueur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Longueur> vListLongueur = vJdbcTemplate.query(vSQL, longueurRM);

        return vListLongueur;
    }

    @Override
    public List<Longueur> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Longueur obj) {

        String vSQL = "UPDATE longueur SET " +
                "id_voie = :id_voie" +
                ", equipement = :equipement" +
                ", nb_point = :nb_point" +
                " WHERE id = :id";

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(obj);
        vParams.registerSqlType("id", Types.INTEGER);
        vParams.registerSqlType("id_voie", Types.INTEGER);
        vParams.registerSqlType("equipement", Types.BOOLEAN);
        vParams.registerSqlType("nb_point", Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        try {
            vJdbcTemplate.update(vSQL, vParams);
        } catch (DuplicateKeyException vEx) {
            //LOGGER.error("La longueur existe déjà ! id=" + obj.getId(), vEx);
            System.out.println("La longueur existe déjà ! id=" + obj.getId());
        }
        return false;
    }

    @Override
    public boolean delete(Longueur obj) {
        String vSQL = "DELETE FROM longueur WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);

        return false;
    }

    @Override
    public boolean deleteAll(int id_voie) {
        String vSQL = "DELETE FROM longueur WHERE id_voie = ?";
        //TODO à tester
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, id_voie);

        return false;
    }

    @Override
    public int getCountLongueur() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbLongueur = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM longueur", Integer.class);
        return vNbLongueur;
    }
}