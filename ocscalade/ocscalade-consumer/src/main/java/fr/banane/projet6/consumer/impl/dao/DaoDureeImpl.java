package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoDuree;
import fr.banane.projet6.consumer.impl.rowmapper.DureeRM;
import fr.banane.projet6.model.bean.Duree;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoDuree}
 *
 * @author Banane
 */
@Named
public class DaoDureeImpl extends AbstractDao implements DaoDuree {

    @Inject
    DureeRM dureeRM;

    @Override
    public boolean create(Duree obj) {
        return false;
    }

    @Override
    public Duree read(int id) {
        String vSQL = "SELECT * FROM duree WHERE id="+id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Duree> vListDifficulte = vJdbcTemplate.query(vSQL, dureeRM);
        Duree vDuree = vListDifficulte.get(0);

        return vDuree;
    }

    @Override
    public Duree read(String code) {
        return null;
    }

    @Override
    public List<Duree> readAll() {
        String vSQL = "SELECT * FROM difficulte";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Duree> vListDuree = vJdbcTemplate.query(vSQL, dureeRM);
        return null;
    }

    @Override
    public List<Duree> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Duree obj) {
        return false;
    }

    @Override
    public boolean delete(Duree obj) {
        return false;
    }

    @Override
    public int getCountDuree() {
        return 0;
    }
}
