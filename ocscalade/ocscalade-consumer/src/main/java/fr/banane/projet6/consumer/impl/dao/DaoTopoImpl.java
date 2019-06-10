package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoTopo;
import fr.banane.projet6.model.bean.Topo;

import javax.inject.Named;
import java.util.List;

@Named
public class DaoTopoImpl extends AbstractDao implements DaoTopo {
    @Override
    public boolean create(Topo obj) {
        return false;
    }

    @Override
    public Topo read(int id) {
        return null;
    }

    @Override
    public Topo read(String code) {
        return null;
    }

    @Override
    public List<Topo> readAll() {
        return null;
    }

    @Override
    public List<Topo> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Topo obj) {
        return false;
    }

    @Override
    public boolean delete(Topo obj) {
        return false;
    }

    @Override
    public boolean deleteAll(int id_utilisateur) {
        return false;
    }

    @Override
    public int getCountTopo() {
        return 0;
    }
}
