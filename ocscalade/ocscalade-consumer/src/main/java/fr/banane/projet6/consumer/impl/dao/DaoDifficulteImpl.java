package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoDifficulte;
import fr.banane.projet6.consumer.impl.rowmapper.DifficulteRM;
import fr.banane.projet6.model.bean.Difficulte;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoDifficulte}
 *
 * @author Banane
 */
@Named
public class DaoDifficulteImpl extends AbstractDao implements DaoDifficulte {

    @Inject
    DifficulteRM difficulteRM;

    @Override
    public Difficulte read(int id) {
        String vSQL = "SELECT * FROM difficulte WHERE id="+id;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Difficulte> vListDifficulte = vJdbcTemplate.query(vSQL, difficulteRM);
        Difficulte vDifficulte = vListDifficulte.get(0);
        return vDifficulte;
    }

    @Override
    public Difficulte readByDifficulte(String difficulte) {
        String vSQL = "SELECT * FROM difficulte WHERE difficulte="+"'"+difficulte+"'";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Difficulte> vListDifficulte = vJdbcTemplate.query(vSQL, difficulteRM);
        Difficulte vDifficulte = vListDifficulte.get(0);
        return vDifficulte;
    }

    @Override
    public List<Difficulte> readAll() {
        String vSQL = "SELECT * FROM difficulte";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Difficulte> vListDifficulte = vJdbcTemplate.query(vSQL, difficulteRM);
        return vListDifficulte;
    }

    @Override
    public List<Difficulte> readAll(int id) {
        return null;
    }
}
