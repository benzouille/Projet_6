package fr.banane.projet6.consumer.impl.dao;

import fr.banane.projet6.consumer.contract.dao.DaoReservation;
import fr.banane.projet6.model.bean.Reservation;

import javax.inject.Named;
import java.util.List;

@Named
public class DaoReservationImpl extends AbstractDao implements DaoReservation {
    @Override
    public boolean create(Reservation obj) {
        return false;
    }

    @Override
    public Reservation read(int id) {
        return null;
    }

    @Override
    public Reservation read(String code) {
        return null;
    }

    @Override
    public List<Reservation> readAll() {
        return null;
    }

    @Override
    public List<Reservation> readAll(int id) {
        return null;
    }

    @Override
    public boolean update(Reservation obj) {
        return false;
    }

    @Override
    public boolean delete(Reservation obj) {
        return false;
    }

    @Override
    public int getCountReservation() {
        return 0;
    }
}
