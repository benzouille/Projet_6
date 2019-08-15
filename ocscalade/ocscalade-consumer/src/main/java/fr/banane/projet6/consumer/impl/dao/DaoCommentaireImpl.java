package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoCommentaire;
import fr.banane.projet6.consumer.impl.rowmapper.CommentaireRM;
import fr.banane.projet6.model.bean.Commentaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoCommentaire}
 *
 * @author Banane
 */
@Named
public class DaoCommentaireImpl extends AbstractDao implements DaoCommentaire {

    @Inject
    CommentaireRM commentaireRM;

    @Override
    public boolean create(Commentaire obj) {

        String vSQL = "INSERT INTO commentaire (id_user, id_spot, commentaire, date) VALUES (:id_utilisateur, :id_spot, :commentaire, :date)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_utilisateur", obj.getUtilisateur().getId(), Types.INTEGER);
        vParams.addValue("id_spot", obj.getIdSpot(), Types.INTEGER);
        vParams.addValue("commentaire", obj.getCommentaire(), Types.VARCHAR);
        vParams.addValue("date", obj.getDate(), Types.TIMESTAMP);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public Commentaire read(int id) {
        String vSQL = "SELECT * FROM commentaire WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaires = vJdbcTemplate.query(vSQL, commentaireRM);
        Commentaire vCommentaire = vListCommentaires.get(0);
        return vCommentaire;
    }

    @Override
    public Commentaire read(String code) {
        return null;
    }

    @Override
    public List<Commentaire> readAll() {
        String vSQL = "SELECT * FROM commentaire";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaires = vJdbcTemplate.query(vSQL, commentaireRM);
        return vListCommentaires;
    }

    @Override
    public List<Commentaire> readAllByUser(int id_utilisateur) {
        String vSQL = "SELECT * FROM commentaire WHERE id_user="+id_utilisateur;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaires = vJdbcTemplate.query(vSQL, commentaireRM);
        return vListCommentaires;
    }

    @Override
    public List<Commentaire> readAllBySpot(int id_spot) {
        String vSQL = "SELECT * FROM commentaire WHERE id_spot="+id_spot+"ORDER BY date";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Commentaire> vListCommentaires = vJdbcTemplate.query(vSQL, commentaireRM);
        return vListCommentaires;
    }

    @Override
    public boolean update(Commentaire obj) {

        String vSQL = "UPDATE commentaire SET id_user=:id_utilisateur, id_spot=:id_spot, commentaire=:commentaire, date=:date WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
        vParams.addValue("id_utilisateur", obj.getUtilisateur().getId(), Types.INTEGER);
        vParams.addValue("id_spot", obj.getIdSpot(), Types.INTEGER);
        vParams.addValue("commentaire", obj.getCommentaire(), Types.VARCHAR);
        vParams.addValue("date", obj.getDate(), Types.TIMESTAMP);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Commentaire obj) {
        String vSQL = "DELETE FROM commentaire WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);
        return false;
    }

    @Override
    public boolean deleteAllByUser(int id_utilisateur) {
        String vSQL = "DELETE FROM commentaire WHERE id_user = :id_utilisateur";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_utilisateur", id_utilisateur, Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean deleteAllBySpot(int id_spot) {
        String vSQL = "DELETE FROM commentaire WHERE id_spot = :id_spot";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_spot", id_spot, Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public int getCountCommentaire() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbCommentaire = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM commentaire", Integer.class);
        return vNbCommentaire;
    }
}
