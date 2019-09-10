package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoSexe;
import fr.banane.projet6.consumer.impl.rowmapper.SexeRM;
import fr.banane.projet6.model.bean.Sexe;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoSexe}
 *
 * @author Banane
 */
@Named
public class DaoSexeImpl extends AbstractDao implements DaoSexe {

    @Inject
    SexeRM sexeRM;

    @Override
    public Sexe read(int id) {
        String vSQL = "SELECT * FROM sexe WHERE id="+id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Sexe> vListSexe = vJdbcTemplate.query(vSQL, sexeRM);
        Sexe vSexe = vListSexe.get(0);

        return vSexe;
    }

    @Override
    public Sexe read(String code) {
        String vSQL = "SELECT * FROM sexe WHERE sexe='"+code+"'";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Sexe> vListSexe = vJdbcTemplate.query(vSQL, sexeRM);
        Sexe vSexe = vListSexe.get(0);

        return vSexe;
    }

    @Override
    public List<Sexe> readAll() {
        String vSQL = "SELECT * FROM sexe";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Sexe> vListSexe = vJdbcTemplate.query(vSQL, sexeRM);

        return vListSexe;
    }

    @Override
    public List<Sexe> readAll(int id) {
        return null;
    }
}
