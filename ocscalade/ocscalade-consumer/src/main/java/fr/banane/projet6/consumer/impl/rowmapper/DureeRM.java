package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.model.bean.Duree;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Duree"
 * @author Banane
 */
@Named
public class DureeRM implements RowMapper<Duree> {
    @Override
    public Duree mapRow(ResultSet rs, int rowNum) throws SQLException {
        Duree vDuree = new Duree();
        vDuree.setId(rs.getInt("id"));
        vDuree.setDuree((rs.getString("duree")));
        return vDuree;
    }
}
