package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoTopo;
import fr.banane.projet6.consumer.contract.dao.DaoUtilisateur;
import fr.banane.projet6.model.bean.Reservation;
import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.TechnicalException;
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

    @Inject
    DaoUtilisateur daoUtilisateurImpl;
    @Inject
    DaoTopo daoTopoImpl;

    @Override
    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Le locataire
        Utilisateur vutilisateur = null;
        try {
            vutilisateur = daoUtilisateurImpl.read(rs.getInt("id_utilisateur_locataire"));
        } catch (TechnicalException e) {
            e.printStackTrace();
        }

        // Le topo
        Topo vtopo = daoTopoImpl.read(rs.getInt("id_topo"));

        Reservation vReservation = new Reservation(
                rs.getInt("id"),
                vtopo,
                vutilisateur,
                rs.getTimestamp("date_debut"),
                rs.getTimestamp("date_fin"),
                rs.getString("message"),
                rs.getBoolean("accepte"),
                rs.getBoolean("traite"));

        return vReservation;
    }
}
