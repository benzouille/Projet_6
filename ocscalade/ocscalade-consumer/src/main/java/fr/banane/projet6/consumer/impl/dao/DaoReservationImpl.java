package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoReservation;
import fr.banane.projet6.consumer.impl.rowmapper.ReservationRM;
import fr.banane.projet6.model.bean.Reservation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Types;
import java.util.List;

@Named
public class DaoReservationImpl extends AbstractDao implements DaoReservation {

    @Inject
    ReservationRM reservationRM;

    @Override
    public boolean create(Reservation obj) {
        String vSQL = "INSERT INTO reservation (id_topo, id_utilisateur_locataire, message, date_debut, date_fin, accepte, traite) VALUES (:id_topo, :id_utilisateur_locataire, :message, :date_debut, :date_fin, :accepte, :traite)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id_topo", obj.getTopo().getId(), Types.INTEGER);
        vParams.addValue("id_utilisateur_locataire", obj.getLocataire().getId(), Types.INTEGER);
        vParams.addValue("message", obj.getMessage(), Types.VARCHAR);
        vParams.addValue("date_debut", obj.getDate_debut(), Types.TIMESTAMP);
        vParams.addValue("date_fin", obj.getDate_fin(), Types.TIMESTAMP);
        vParams.addValue("accepte", obj.isAccepte(), Types.BOOLEAN);
        vParams.addValue("traite", obj.isTraite(), Types.BOOLEAN);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public Reservation read(int id) {
        String vSQL = "SELECT * FROM reservation WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Reservation> vListReservations = vJdbcTemplate.query(vSQL, reservationRM);
        Reservation vReservation = vListReservations.get(0);
        return vReservation;
    }

    @Override
    public List<Reservation> readAll() {
        String vSQL = "SELECT * FROM reservation";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Reservation> vListReservations = vJdbcTemplate.query(vSQL, reservationRM);
        return vListReservations;
    }

    @Override
    public List<Reservation> readAllByTopo(int id_topo) {
        String vSQL = "SELECT * FROM reservation WHERE id_topo="+id_topo;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Reservation> vListReservations = vJdbcTemplate.query(vSQL, reservationRM);
        return vListReservations;
    }

    @Override
    public List<Reservation> readAllByProprietaireTopo(int id_proprietaire) {
        String vSQL = "SELECT * FROM reservation WHERE traite = false AND id_topo IN (SELECT topo.id FROM topo WHERE id_utilisateur ="+ id_proprietaire +")";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Reservation> vListReservations = vJdbcTemplate.query(vSQL, reservationRM);
        return vListReservations;
    }

    @Override
    public List<Reservation> readAllByLocataire(int id_locataire) {
        String vSQL = "SELECT * FROM reservation WHERE id_utilisateur_locataire="+id_locataire;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Reservation> vListReservations = vJdbcTemplate.query(vSQL, reservationRM);
        return vListReservations;
    }

    @Override
    public boolean update(Reservation obj) {
        String vSQL = "UPDATE reservation SET id_topo=:id_topo, id_utilisateur_locataire=:id_utilisateur_locataire, message=:message, date_debut=:date_debut, date_fin=:date_fin, accepte=:accepte, traite=:traite WHERE id =:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", obj.getId(), Types.INTEGER);
        vParams.addValue("id_topo", obj.getTopo().getId(), Types.INTEGER);
        vParams.addValue("id_utilisateur_locataire", obj.getLocataire().getId(), Types.INTEGER);
        vParams.addValue("message", obj.getMessage(), Types.VARCHAR);
        vParams.addValue("date_debut", obj.getDate_debut(), Types.TIMESTAMP);
        vParams.addValue("date_fin", obj.getDate_fin(), Types.TIMESTAMP);
        vParams.addValue("accepte", obj.isAccepte(), Types.BOOLEAN);
        vParams.addValue("traite", obj.isTraite(), Types.BOOLEAN);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return false;
    }

    @Override
    public boolean delete(Reservation obj) {
        String vSQL = "DELETE FROM reservation WHERE id = :id";

        BeanPropertySqlParameterSource vParam = new BeanPropertySqlParameterSource(obj);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParam);
        return false;
    }

    @Override
    public int getCountReservation() {
        return 0;
    }
}
