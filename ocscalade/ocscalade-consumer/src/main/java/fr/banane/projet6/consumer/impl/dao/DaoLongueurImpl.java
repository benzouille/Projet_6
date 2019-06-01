package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoLongueur;
import fr.banane.projet6.consumer.impl.rowmapper.LongueurRM;
import fr.banane.projet6.model.bean.Longueur;

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
        String vSQL = "INSERT INTO longueur"
        return false;
    }

    @Override
    public Longueur read(int id) {
        return null;
    }

    @Override
    public Longueur read(String code) {
        return null;
    }

    @Override
    public List<Longueur> readAll() {
        return null;
    }

    @Override
    public List<Longueur> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Longueur obj) {
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
