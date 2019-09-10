package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Sexe;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Sexe" / La table "sexe"
 *
 * @author Banane
 */
public interface DaoSexe {
    /**
     * Méthode de recherche des informations
     * @param id -
     * @return T
     */
    Sexe read(int id);
    Sexe read(String code);
    List<Sexe> readAll();
    List<Sexe> readAll(int id);
}
