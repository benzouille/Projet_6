package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoLongueur;
import fr.banane.projet6.consumer.impl.rowmapper.LongueurRM;
import fr.banane.projet6.model.bean.Longueur;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoLongueur}
 *
 * @author Banane
 */
@Named
public class DaoLongueurImpl extends AbstractDao implements DaoLongueur {

    @Inject
    LongueurRM longueurRM;

    @Override
    public boolean create(Longueur obj) {
        String vSQL = "INSERT INTO longueur () VALUES ()"
        return false;
    }

    @Override
    public Longueur read(int id) {
        String vSQL = "SELECT * FROM longueur WHERE id="+id;
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Longueur> vListLongueur = vJdbcTemplate.query(vSQL, longueurRM);
        Longueur vLongueur = vListLongueur.get(0);

        return vLongueur;
    }

    @Override
    public Longueur read(String code) {
        return null;
    }

    @Override
    public List<Longueur> readAll() {
        String vSQL = "SELECT * FROM longueur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Longueur> vListLongueur = vJdbcTemplate.query(vSQL, longueurRM);

        return vListLongueur;
    }

    @Override
    public List<Longueur> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Longueur obj) {


        String vSQL = "UPDATE longueur SET WHERE id=" + obj.getId() + " () VALUES ()"
        return false;
    }

    @Override
    public boolean delete(Longueur obj) {
        return false;
    }

    @Override
    public int getCountLongueur() {
        return 0;
    }
}
