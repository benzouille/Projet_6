package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.*;
import fr.banane.projet6.consumer.impl.rowmapper.UtilisateurRM;
import fr.banane.projet6.model.bean.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoUtilisateur}
 *
 * @author Banane
 */
@Named
public class DaoUtilisateurImpl extends AbstractDao implements DaoUtilisateur {

    @Inject
    UtilisateurRM utilisateurRM;

    @Override
    public boolean create(Utilisateur obj) {
        String vSQL = "INSERT INTO utilisateur (id_sexe, pseudo, email, password, id_departement, date_naissance, id_privilege) " +
                "VALUES (:id_sexe, :pseudo, :email, :password, :departement, :date_naissance, :id_privilege)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_sexe", obj.getSexe().getId(), Types.INTEGER);
        vParams.addValue("pseudo", obj.getPseudo(), Types.VARCHAR);
        vParams.addValue("email", obj.getEmail(), Types.VARCHAR);
        vParams.addValue("password", obj.getPassword(), Types.VARCHAR);
        vParams.addValue("departement", obj.getDepartement().getId(), Types.INTEGER);
        vParams.addValue("date_naissance", obj.getDate_naissance(), Types.VARCHAR);
        vParams.addValue("id_privilege", obj.getPrivilege().getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public Utilisateur read(int id) {
            String vSQL = "SELECT * FROM utilisateur WHERE id="+id;
            JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
            List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, utilisateurRM);
        Utilisateur vUtilisateur = vListUtilisateur.get(0);
            return vUtilisateur;
    }

    @Override
    public Utilisateur read(String pseudo) {

        Utilisateur vUtilisateur = null;

        String vSQL = "SELECT * FROM utilisateur WHERE pseudo='"+pseudo+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Utilisateur> vListUtilisateur = null;
        vListUtilisateur = vJdbcTemplate.query(vSQL, utilisateurRM);
        if(vListUtilisateur.size() != 0) {
            vUtilisateur = vListUtilisateur.get(0);
        }

        return vUtilisateur;

    }

    @Override
    public List<Utilisateur> readAll() {
        String vSQL = "SELECT * FROM utilisateur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, utilisateurRM);
        return vListUtilisateur;
    }

    @Override
    public List<Utilisateur> readAll(int id) {

        String vSQL = "SELECT * FROM utilisateur WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, utilisateurRM);
        return vListUtilisateur;
    }

    @Override
    public boolean update(Utilisateur obj) {
        String vSQL = "UPDATE utilisateur SET " +
                "id_sexe=:id_sexe, pseudo=:pseudo, email=:email, password=:password, id_departement=:departement, date_naissance=:date_naissance, id_privilege=:id_privilege WHERE id = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
        vParams.addValue("id_sexe", obj.getSexe().getId(), Types.INTEGER);
        vParams.addValue("pseudo", obj.getPseudo(), Types.VARCHAR);
        vParams.addValue("email", obj.getEmail(), Types.VARCHAR);
        vParams.addValue("password", obj.getPassword(), Types.VARCHAR);
        vParams.addValue("departement", obj.getDepartement().getId(), Types.INTEGER);
        vParams.addValue("date_naissance", obj.getDate_naissance(), Types.VARCHAR);
        vParams.addValue("id_privilege", obj.getPrivilege().getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Utilisateur obj) {
        String vSQL = "DELETE FROM utilisateur WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);

        return false;
    }

    @Override
    public int getCountUtilisateur() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbUtilisateur = vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM utilisateur", Integer.class);
        return vNbUtilisateur;

    }
}
