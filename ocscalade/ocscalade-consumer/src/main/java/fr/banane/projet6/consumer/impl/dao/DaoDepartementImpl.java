package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoDepartement;
import fr.banane.projet6.consumer.impl.rowmapper.DepartementRM;
import fr.banane.projet6.model.bean.Departement;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoDepartement}
 *
 * @author Banane
 */
@Named
public class DaoDepartementImpl extends AbstractDao implements DaoDepartement {

    @Inject
    DepartementRM departementRM;

    @Override
    public Departement read(int id) {
        String vSQL = "SELECT * FROM departement WHERE id="+id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Departement> vListDepartement = vJdbcTemplate.query(vSQL, departementRM);
        Departement vDepartement = vListDepartement.get(0);

        return vDepartement;
    }

    @Override
    public Departement readNum(int num) {
        String vSQL = "SELECT * FROM departement WHERE num="+num;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Departement> vListDepartement = vJdbcTemplate.query(vSQL, departementRM);
        Departement vDepartement = vListDepartement.get(0);

        return vDepartement;
    }

    @Override
    public List<Departement> readAll() {
        String vSQL = "SELECT * FROM departement";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Departement> vListDepartement = vJdbcTemplate.query(vSQL, departementRM);

        return vListDepartement;
    }


    @Override
    public int getCountDepartement() {
        return 0;
    }
}
