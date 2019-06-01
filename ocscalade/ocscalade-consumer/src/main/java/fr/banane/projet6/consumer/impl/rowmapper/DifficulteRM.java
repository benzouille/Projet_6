package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.model.bean.Difficulte;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Difficulte"
 *
 * @author Banane
 */
@Named
public class DifficulteRM implements RowMapper<Difficulte> {
    @Override
    public Difficulte mapRow(ResultSet rs, int rowNum) throws SQLException {
        Difficulte vDifficulte = new Difficulte();
        vDifficulte.setId(rs.getInt("id"));
        vDifficulte.setDifficulte(rs.getString("difficulte"));
        return vDifficulte;
    }
}
