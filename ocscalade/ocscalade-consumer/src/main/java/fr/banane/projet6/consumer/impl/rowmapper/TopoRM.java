package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.consumer.contract.dao.DaoSpot;
import fr.banane.projet6.consumer.contract.dao.DaoUtilisateur;
import fr.banane.projet6.model.bean.Spot;
import fr.banane.projet6.model.bean.Topo;
import fr.banane.projet6.model.bean.Utilisateur;
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
public class TopoRM implements RowMapper<Topo> {
    
    @Inject
    DaoUtilisateur daoUtilisateurImpl;
    @Inject
    DaoSpot daoSpotImpl;
    
    @Override
    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {

        //Le créateur
        Utilisateur utilisateur =daoUtilisateurImpl.read(rs.getInt("id_utilisateur"));
        
        // Le spot
        Spot spot = daoSpotImpl.read(rs.getInt("id_spot"));

        Topo vTopo = new Topo();
        vTopo.setId(rs.getInt("id"));
        vTopo.setUtilisateur(utilisateur);
        vTopo.setSpot(spot);
        vTopo.setDate_creation(rs.getString("date_creation"));

        return vTopo;
    }
}
