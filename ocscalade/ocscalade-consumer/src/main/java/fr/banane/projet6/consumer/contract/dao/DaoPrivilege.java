package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Privilege;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Privilege" / La table "privilege"
 *
 * @author Banane
 *
 */
public interface DaoPrivilege {
    /**
     * Méthode de recherche des informations
     * @param id int privilege
     * @return T
     */
    Privilege read(int id);
    Privilege read(String code);
    List<Privilege> readAll();
    List<Privilege> readAll(int id);
}
