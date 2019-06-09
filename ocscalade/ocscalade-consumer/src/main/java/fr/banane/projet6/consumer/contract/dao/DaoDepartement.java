package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Departement;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Departement" / La table "Departement"
 *
 * @author Banane
 *
 */
public interface DaoDepartement {
    //-- CRUD : Les méthodes nécessaires

    /**
     * Méthode de recherche des informations
     * @param id -
     * @return T
     */
    Departement read(int id);
    Departement readNum(int num);
    List<Departement> readAll();

    /**
     * Retourne le nombre de departement
     * @return Le nombre de departement
     */
    int getCountDepartement();
}

