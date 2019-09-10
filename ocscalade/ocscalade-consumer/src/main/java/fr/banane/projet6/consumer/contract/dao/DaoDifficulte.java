package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Difficulte;

import java.util.List;

/**
 * Les méthodes CRUD nécessaires pour manipuler le bean "Difficulte" / La table "Difficulte"
 *
 * @author Banane
 *
 */
public interface DaoDifficulte {
    /**
     * Méthode de recherche des informations
     * @param id -
     * @return T
     */
    Difficulte read(int id);
    Difficulte readByDifficulte(String difficulte);
    List<Difficulte> readAll();
    List<Difficulte> readAll(int id);
}
