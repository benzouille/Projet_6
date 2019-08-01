package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoSecteur;
import fr.banane.projet6.consumer.contract.dao.DaoVoie;
import fr.banane.projet6.consumer.impl.rowmapper.SecteurRM;
import fr.banane.projet6.model.bean.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;


/**
 * Classe d'implementation de {@link DaoSecteur}
 *
 * @author Banane
 */
@Named
public class DaoSecteurImpl extends AbstractDao implements DaoSecteur {

    @Inject
    SecteurRM secteurRM;
    @Inject
    DaoVoie daoVoieImpl;

    @Override
    public boolean create(Secteur obj) {
        String vSQL = "INSERT INTO secteur (nom, id_spot, description) VALUES (:nom, :id_secteur, :descrption)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_spot", obj.getId_spot(), Types.INTEGER);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public Secteur read(int id) {
        String vSQL = "SELECT * FROM secteur WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, secteurRM);
        Secteur vSecteur = vListSecteur.get(0);
        return vSecteur;
    }

    @Override
    public Secteur read(String code) {
        return null;
    }

    @Override
    public List<Secteur> readAll() {
        String vSQL = "SELECT * FROM secteur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, secteurRM);
        return vListSecteur;
    }

    @Override
    public List<Secteur> readAllByIdSpot(int id_spot) {
        String vSQL = "SELECT * FROM secteur WHERE id_spot="+id_spot;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Secteur> vListSecteur = vJdbcTemplate.query(vSQL, secteurRM);
        return vListSecteur;
    }

    @Override
    public boolean update(Secteur obj) {
        String vSQL = "UPDATE secteur SET nom = :nom, id_spot = :id_spot, description = :descrption WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_spot", obj.getId_spot(), Types.INTEGER);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Secteur obj) {
        //supression des voies liées à l'id du secteur
        daoVoieImpl.deleteAll(obj.getId());

        String vSQL = "DELETE FROM secteur WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);

        return false;
    }

    @Override
    public boolean deleteAll(int id_spot) {
        String vSQL = "DELETE FROM secteur WHERE id_spot = ?";
        //TODO à tester
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, id_spot);
        return false;
    }

    @Override
    public int getCountSecteur() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbSecteur = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM secteur", Integer.class);
        return vNbSecteur;
    }
}
