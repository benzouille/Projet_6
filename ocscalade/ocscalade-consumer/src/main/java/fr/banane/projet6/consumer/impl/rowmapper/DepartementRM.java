package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.model.bean.Departement;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Departement"
 *
 * @author Banane
 */
@Named
public class DepartementRM implements RowMapper<Departement> {
    
    
    @Override
    public Departement mapRow(ResultSet rs, int rowNum) throws SQLException {
        Departement vDepartement = new Departement();
        vDepartement.setId(rs.getInt("id"));
        vDepartement.setNum(rs.getString("num"));
        vDepartement.setNom(rs.getString("nom"));

        return vDepartement;
    }
}
