package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoSpot;
import fr.banane.projet6.model.bean.Spot;

import javax.inject.Named;
import java.util.List;

/**
 * Classe d'implementation de {@link DaoSpot}
 *
 * @author Banane
 */
@Named
public class DaoSpotImpl extends AbstractDao implements DaoSpot {
    @Override
    public boolean create(Spot obj) {
        return false;
    }

    @Override
    public Spot read(int id) {
        return null;
    }

    @Override
    public Spot read(String code) {
        return null;
    }

    @Override
    public List<Spot> readAll() {
        return null;
    }

    @Override
    public List<Spot> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Spot obj) {
        return false;
    }

    @Override
    public boolean delete(Spot obj) {
        return false;
    }

    @Override
    public int getCountSpot() {
        return 0;
    }
}
