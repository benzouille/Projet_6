package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.model.bean.Longueur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Longueur"
 *
 * @author Banane
 */
@Named
public class LongueurRM implements RowMapper<Longueur> {
    @Override
    public Longueur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Longueur vLongueur = new Longueur();
        vLongueur.setId(rs.getInt("id"));
        vLongueur.setId_voie(rs.getInt("id_voie"));
        vLongueur.setEquipement(rs.getBoolean("equipement"));
        if(vLongueur.isEquipement()){
            vLongueur.setNb_point(rs.getInt("nb_point"));
        }
        return vLongueur;
    }
}
