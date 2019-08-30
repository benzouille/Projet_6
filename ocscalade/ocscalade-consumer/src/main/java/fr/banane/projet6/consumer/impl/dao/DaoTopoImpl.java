package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoSpot;
import fr.banane.projet6.consumer.contract.dao.DaoTopo;
import fr.banane.projet6.consumer.impl.rowmapper.TopoRM;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Named
public class DaoTopoImpl extends AbstractDao implements DaoTopo {

    @Inject
    TopoRM topoRM;
    @Inject
    DaoSpot daoSpotImpl;

    @Override
    public boolean create(Topo obj) {
        String vSQL = "INSERT INTO topo (nom, id_utilisateur, id_spot, description, reservable, date_creation) VALUES (:nom, :id_utilisateur, :id_spot, :description, :reservable, :date_creation)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_utilisateur", obj.getUtilisateur().getId(), Types.INTEGER);
        vParams.addValue("id_spot", obj.getSpot().getId(), Types.INTEGER);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);
        vParams.addValue("reservable", obj.getReservable(), Types.BOOLEAN);
        vParams.addValue("date_creation", obj.getDate_creation(), Types.TIMESTAMP);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public Topo read(int id) {
        String vSQL = "SELECT * FROM topo WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        Topo vTopo = vListTopos.get(0);
        return vTopo;
    }

    @Override
    public Topo read(String name) {
        String vSQL = "SELECT * FROM topo WHERE nom="+"'"+name+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        Topo vTopo = vListTopos.get(0);
        return vTopo;
    }

    @Override
    public List<Topo> readAll() {
        String vSQL = "SELECT * FROM topo";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        return vListTopos;
    }

    @Override
    public List<Topo> readAllByCreateur(int id_utilisateur) {
        String vSQL = "SELECT * FROM topo WHERE id_utilisateur="+id_utilisateur;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        return vListTopos;
    }

    @Override
    public List<Topo> readAllByDepartementSpot(int id_dep) {
        //TODO A verifier le fonctionnement.
        //recuperer les spots du dep
        List<Spot> vListSpot = daoSpotImpl.getListSpotByDepartement(id_dep);

        //verifier les topos aillant les spots de la liste en spot
        ArrayList<Topo> vListTopos = new ArrayList<Topo>();
        for(Spot spot : vListSpot){
            String vSQL = "SELECT * FROM topo WHERE id_spot="+ spot.getId();
            JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
            List<Topo> vList = vJdbcTemplate.query(vSQL, topoRM);
            Topo vTopo = vList.get(0);
            vListTopos.add(vTopo);
        }

        return vListTopos;
    }

    @Override
    public List<Topo> readAllByReservable() {
        String vSQL = "SELECT * FROM topo WHERE reservable= TRUE";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopos = vJdbcTemplate.query(vSQL, topoRM);
        return vListTopos;
    }

    @Override
    public List<Topo> getListTopoByQuery(String departement, String spot, String createur, Timestamp date, boolean disponible) {
        String vInitSQL = "SELECT * FROM topo WHERE ",
                vDepartement = "topo.id_spot IN (SELECT spot.id FROM spot WHERE id_departement="+departement+")",
                vAnd = " AND ",
                vSpot = "id_spot="+spot,
                vCreateur = "id_utilisateur = "+createur,
                vDate = "date_creation > '"+date+"'",
                vDisponible = "reservable = "+disponible;

        ArrayList<String> requeteList = new ArrayList<>();
        requeteList.add(vInitSQL);

        if(departement != null){
            requeteList.add(vDepartement);
        }
        if(spot != null){
            if (requeteList.size() > 1) {
                requeteList.add(vAnd);
            }
            requeteList.add(vSpot);
            }
        if(createur != null){
            if (requeteList.size() > 1) {
                requeteList.add(vAnd);
            }
            requeteList.add(vCreateur);
        }
        if(date != null){
            if (requeteList.size() > 1) {
                requeteList.add(vAnd);
            }
            requeteList.add(vDate);
        }
        if (disponible){
            if (requeteList.size() > 1) {
                requeteList.add(vAnd);
            }
            requeteList.add(vDisponible);
        }

        StringBuilder vSQL = new StringBuilder();
        for (String string : requeteList){
            vSQL.append(string);
        }

        System.out.println(vSQL);

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vListTopo = vJdbcTemplate.query(vSQL.toString(), topoRM);
        return vListTopo;
    }


    @Override
    public boolean update(Topo obj) {
        String vSQL = "UPDATE topo SET nom=:nom, id_utilisateur=:id_utilisateur, id_spot=:id_spot, description=:description, reservable=:reservable, date_creation=:date_creation WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
        vParams.addValue("nom", obj.getNom(), Types.VARCHAR);
        vParams.addValue("id_utilisateur", obj.getUtilisateur().getId(), Types.INTEGER);
        vParams.addValue("id_spot", obj.getSpot().getId(), Types.INTEGER);
        vParams.addValue("description", obj.getDescription(), Types.VARCHAR);
        vParams.addValue("reservable", obj.getReservable(), Types.BOOLEAN);
        vParams.addValue("date_creation", obj.getDate_creation(), Types.TIMESTAMP);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Topo obj) {
        String vSQL = "DELETE FROM topo WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);

        return false;
    }

    @Override
    public boolean deleteAll(int id_utilisateur) {
        return false;
    }

    @Override
    public int getCountTopo() {
        return 0;
    }
}
