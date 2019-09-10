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
        String vSQL = "SELECT * FROM spot ORDER BY id";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL, spotRM);
        return vListSpot;
    }

    @Override
    public List<Spot> readAllForIndex() {
        String vSQL = "SELECT spot.* FROM spot ORDER BY id DESC FETCH FIRST 8 ROWS ONLY";
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
    public List<Spot> getListSpotByQuery(String departement, String difficulte, String nbreSecteur, boolean equipement, boolean officiel) {

        String vSELECT = "SELECT spot.* ",
                vFROMSpot = "FROM spot ",
                vFROMVoie = "FROM spot, secteur, voie ",
                vWHERE = "WHERE ",
                vSpotToVoie = "spot.id = secteur.id_spot AND secteur.id = voie.id_secteur",
                vDepartement = "id_departement="+departement,
                vAnd = " AND ",
                vDifficulte = " AND voie.id_difficulte = "+difficulte,
                vEquipement = " AND voie.equipement = "+equipement,
                vOfficiel = "officiel="+officiel;

        ArrayList<String> requeteList = new ArrayList<>();
        requeteList.add(vSELECT);

        if(difficulte == null && !equipement){
            requeteList.add(vFROMSpot);
            if(departement != null || officiel){
                requeteList.add(vWHERE);
            }
        }
        else{
            requeteList.add(vFROMVoie);
            requeteList.add(vWHERE);
            requeteList.add(vSpotToVoie);
            if(difficulte != null){
                requeteList.add(vDifficulte);
            }
            if (equipement){
                requeteList.add(vEquipement);
            }
        }

        if(departement != null ){
            if(requeteList.size() != 3) {
                requeteList.add(vAnd);
            }
            requeteList.add(vDepartement);
        }

        if(officiel){
            if (requeteList.size() != 3) {
                requeteList.add(vAnd);
            }
            requeteList.add(vOfficiel);
        }

        StringBuilder vSQL = new StringBuilder();
        for (String string : requeteList){
            vSQL.append(string);
        }

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Spot> vListSpot = vJdbcTemplate.query(vSQL.toString(), spotRM);

        if(nbreSecteur != null){
            List<Spot> vListSpotModif = new ArrayList<>();
            for (Spot spot : vListSpot) {
                if (spot.getSecteurs().size() == Integer.parseInt(nbreSecteur)) {
                    vListSpotModif.add(spot);
                }
            }
            vListSpot = vListSpotModif;
        }
        return vListSpot;
    }

    @Override
    public boolean update(Spot obj) {

        String vSQL = "UPDATE spot SET nom=:nom, id_createur=:id_createur, officiel=:officiel, id_departement=:departement, adresse=:adresse, description=:description WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
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
    public void delete(Spot obj) {
        //suppression des secteurs liées à l'id du spot
        daoSecteurImpl.deleteAll(obj.getId());

        //suppression des images liées à l'id du spot
        daoImageImpl.deleteAll(obj.getId());

        String vSQL = "DELETE FROM spot WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);
    }

    @Override
    public int getCountSpot() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        return vJdbcTemplate.queryForObject( "SELECT COUNT(*) FROM spot", Integer.class);
    }
}
