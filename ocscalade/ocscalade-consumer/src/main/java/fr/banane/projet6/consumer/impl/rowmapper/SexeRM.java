package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.model.bean.Sexe;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Sexe"
 *
 * @author Banane
 */
@Named
public class SexeRM implements RowMapper<Sexe> {
    @Override
    public Sexe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sexe vSexe = new Sexe();
        vSexe.setId(rs.getInt("id"));
        vSexe.setSexe(rs.getString("sexe"));
        return vSexe;
    }
}
