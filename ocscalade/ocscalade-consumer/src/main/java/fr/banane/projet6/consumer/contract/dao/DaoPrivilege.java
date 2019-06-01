package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Privilege;

import java.util.List;

public interface DaoPrivilege {
    /**
     * Méthode de recherche des informations
     * @param id -
     * @return T
     */
    Privilege read(int id);
    Privilege read(String code);
    List<Privilege> readAll();
    List<Privilege> readAll(int id);
}
