package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoCommentaire;
import fr.banane.projet6.model.bean.Commentaire;

import java.util.List;

public class DaoCommentaireImpl extends AbstractDao implements DaoCommentaire {
    @Override
    public boolean create(Commentaire obj) {
        return false;
    }

    @Override
    public Commentaire read(int id) {
        return null;
    }

    @Override
    public Commentaire read(String code) {
        return null;
    }

    @Override
    public List<Commentaire> readAll() {
        return null;
    }

    @Override
    public List<Commentaire> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Commentaire obj) {
        return false;
    }

    @Override
    public boolean delete(Commentaire obj) {
        return false;
    }

    @Override
    public int getCountCommentaire() {
        return 0;
    }
}
