package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoPrivilege;
import fr.banane.projet6.consumer.impl.rowmapper.PrivilegeRM;
import fr.banane.projet6.model.bean.Privilege;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoPrivilege}
 *
 * @author Banane
 */
@Named
public class DaoPrivilegeImpl extends AbstractDao implements DaoPrivilege {

    @Inject
    PrivilegeRM privilegeRM;

    @Override
    public Privilege read(int id) {
        String vSQL = "SELECT * FROM privilege WHERE id="+id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Privilege> vListPrivilege = vJdbcTemplate.query(vSQL, privilegeRM);
        Privilege vPrivilege = vListPrivilege.get(0);

        return vPrivilege;
    }

    @Override
    public Privilege read(String code) {
        return null;
    }

    @Override
    public List<Privilege> readAll() {
        String vSQL = "SELECT * FROM privilege";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Privilege> vListPrivilege = vJdbcTemplate.query(vSQL, privilegeRM);

        return vListPrivilege;
    }

    @Override
    public List<Privilege> readAll(int id) {
        return null;
    }
}
