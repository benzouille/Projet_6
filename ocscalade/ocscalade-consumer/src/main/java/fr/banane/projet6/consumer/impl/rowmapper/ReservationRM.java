package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoTopo;
import fr.banane.projet6.consumer.contract.dao.DaoUtilisateur;
import fr.banane.projet6.model.bean.Reservation;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Commentaire"
 *
 * @author Banane
 */
@Named
public class ReservationRM implements RowMapper<Reservation> {
    //TODO a terminer apres le Topo
    @Inject
    DaoUtilisateur daoUtilisateurImpl;
    @Inject
    DaoTopo daoTopoImpl;

    @Override
    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {

        return null;
    }
}
