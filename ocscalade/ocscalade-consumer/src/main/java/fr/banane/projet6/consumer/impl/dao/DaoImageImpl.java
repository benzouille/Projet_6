package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoImage;
import fr.banane.projet6.consumer.impl.rowmapper.ImageRM;
import fr.banane.projet6.model.bean.Image;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoImage}
 *
 * @author Banane
 */
@Named
public class DaoImageImpl extends AbstractDao implements DaoImage {

    @Inject
    ImageRM imageRM;

    @Override
    public boolean create(Image obj) {

        String vSQL = "INSERT INTO image (idspot, titre, path) VALUES (:id_spot, :titre, :path)";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);

        return false;
    }

    @Override
    public Image read(int id) {
        String vSQL = "SELECT * FROM image WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Image> vListImages = vJdbcTemplate.query(vSQL, imageRM);
        Image vImage = vListImages.get(0);

        return vImage;
    }

    @Override
    public Image read(String code) {
        return null;
    }

    @Override
    public List<Image> readAll() {
        String vSQL = "SELECT * FROM image";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Image> vListImages = vJdbcTemplate.query(vSQL, imageRM);
        return vListImages;
    }

    @Override
    public List<Image> readAll(int id) {
        String vSQL = "SELECT * FROM image WHERE id_spot="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Image> vListImages = vJdbcTemplate.query(vSQL, imageRM);
        return vListImages;
    }

    @Override
    public boolean update(Image obj) {

        String vSQL = "UPDATE image SET idspot=:id_spot, titre=:titre WHERE id=:id";

        BeanPropertySqlParameterSource vParams = new BeanPropertySqlParameterSource(obj);
        vParams.registerSqlType("id", Types.INTEGER);
        vParams.registerSqlType("id_spot", Types.INTEGER);
        vParams.registerSqlType("titre", Types.VARCHAR);
        vParams.registerSqlType("path", Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Image obj) {
        String vSQL = "DELETE FROM image WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);
        return false;
    }

    @Override
    public boolean deleteAll(int id_spot) {
        String vSQL = "SELECT * FROM image WHERE id_spot="+id_spot;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL);
        return false;
    }

    @Override
    public int getCountImage() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbImage = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM image", Integer.class);
        return vNbImage;
    }
}
