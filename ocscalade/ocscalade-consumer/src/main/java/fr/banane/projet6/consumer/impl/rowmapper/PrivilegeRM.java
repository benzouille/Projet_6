package fr.banane.projet6.consumer.impl.rowmapper;

import fr.banane.projet6.model.bean.Privilege;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper de la classe "Privilege"
 *
 * @author Banane
 */
@Named
public class PrivilegeRM implements RowMapper<Privilege> {
    @Override
    public Privilege mapRow(ResultSet rs, int rowNum) throws SQLException {
        Privilege vPrivilege = new Privilege();
        vPrivilege.setId(rs.getInt("id"));
        vPrivilege.setPrivilege(rs.getString("privilege"));

        return vPrivilege;
    }
}
