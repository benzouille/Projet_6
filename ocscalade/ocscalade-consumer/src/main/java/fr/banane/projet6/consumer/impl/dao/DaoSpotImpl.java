package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoImage;
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
import java.util.ArrayList;
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
    @Inject
    DaoImage daoImageImpl;

    @Override
    public boolean create(Spot obj) {

        String vSQL = "INSERT INTO spot (nom, id_createur, officiel, id_departement, adresse, description) VALUES (:nom, :id_createur, :officiel, :departement, :adresse, :description)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_createur", obj.getCreateur().getId(), Types.INTEGER);
        vParams.addValue("officiel", obj.isOfficiel(), Types.BOOLEAN);
        vParams.addValue("departement", obj.getDepartement().getId(), Types.INTEGER);
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
    public Spot readByName(String name) {
        String vSQL = "SELECT * FROM spot WHERE nom="+"'"+name+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        Spot vSpot = vListSpot.get(0);
        return vSpot;
    }

    @Override
    public List<Spot> readAll() {
        String vSQL = "SELECT * FROM spot";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        return vListSpot;
    }

    @Override
    public List<Spot> readAllByIdCreateur(int id_createur) {
        String vSQL = "SELECT * FROM spot WHERE id_createur="+id_createur;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        return vListSpot;
    }

    @Override
    public List<Spot> getListSpotByDepartement(int id_dep) {
        String vSQL = "SELECT * FROM spot WHERE id_departement="+id_dep;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        return vListSpot;
    }

    @Override
    public List<Spot> getListSpotByOfficiel() {
        String vSQL = "SELECT * FROM spot WHERE officiel="+true;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        return vListSpot;
    }

    @Override
    public List<Spot> getListSpotByQuery(String param1, String param2, String param3, boolean param4, boolean param5) {
        String vSQL = "SELECT * FROM spot WHERE ",
                vAnd = " AND ",
                vDepartement = "departement="+param1,
                vDifficulte = "difficulte="+param2,
                //TODO PROBLEME comment avoir le nombre de secteur ?
                vNbreSecteur = "secteur="+param3,
                vEquipement = "equipement="+param4,
                vOfficiel = "officiel="+param5;

        ArrayList<String> requeteList = new ArrayList<>();
        requeteList.add(vSQL);

        if(param1 != null){
            vSQL += vDepartement;
        }
        if(param2 != null){
            if (requeteList.size() < 2) {
                requeteList.add(vAnd);
            }
            requeteList.add(vDifficulte);
        }
        if(param3 != null){
            if (requeteList.size() < 2) {
                requeteList.add(vAnd);
            }
            requeteList.add(vNbreSecteur);
        }
        if(param4){
            if (requeteList.size() < 2) {
                requeteList.add(vAnd);
            }
            requeteList.add(vEquipement);
        }
        if(param5){
            if (requeteList.size() < 2) {
                requeteList.add(vAnd);
            }
            requeteList.add(vOfficiel);
        }

        System.out.println(vSQL);

        //JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        //List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        //return vListSpot;
        return null;
    }

    @Override
    public boolean update(Spot obj) {

        String vSQL = "UPDATE spot SET nom=:nom, id_createur=:id_createur, officiel=:officiel, id_departement=:departement, adresse=:adresse, description=:descrption WHERE id=:id";

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
        //suppression des secteurs liées à l'id du spot
        daoSecteurImpl.deleteAll(obj.getId());

        //suppression des images liées à l'id du spot
        daoImageImpl.deleteAll(obj.getId());

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
