package fr.banane.projet6.consumer.contract.dao;

import fr.banane.projet6.model.bean.Difficulte;

import java.util.List;

public interface DaoDifficulte {
    /**
     * Méthode de recherche des informations
     * @param id -
     * @return T
     */
    Difficulte read(int id);
    Difficulte read(String code);
    List<Difficulte> readAll();
    List<Difficulte> readAll(int id);
}
