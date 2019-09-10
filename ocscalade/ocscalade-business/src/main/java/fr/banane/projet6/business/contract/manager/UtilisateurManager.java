package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.model.exception.TechnicalException;

import java.util.List;

/**
 * Interface proposant des méthodes de création, de récupération, de mise à jour, de supression d'un utilisateur ou d'une liste des utilisateurs.
 * Elle permet également de compter le nombre d' utilisateurs.
 *
 * @author Banane
 *
 */
public interface UtilisateurManager {

    /**
     * Crée un utilisateur.
     */
    void newUtilisateur(Utilisateur vUtilisateur);

    /**
     * Retourne la liste d'utilisateurs.
     *
     * @return Une liste d'utilisateurs.
     */
    List<Utilisateur> getListUtilisateur();

    /**
     * Retourne un objet Utilisateur en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Bug
     * @return L'objet Bug correspondant à l'identifiant.
     * @throws NotFoundException ne trouve pas la ressource demandée
     */
    public Utilisateur getUtilisateur(Integer pId) throws TechnicalException;

    /**
     * Retourne un objet Utilisateur en particulier selon son 'pseudo'.
     *
     * @param pseudo Pseudo de Utilisateur
     * @return L'objet Utilisateur correspondant au pseudo.
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    Utilisateur getUtilisateur(String pseudo) throws TechnicalException;

    /**
     * Met à jour un utilisateur.
     * @param vUtilisateur objet utilisateur
     */
    void updateUtilisateur(Utilisateur vUtilisateur);

    /**
     * Supprime un utilisateur
     * @param vUtilisateur objet Utilisateur
     */
    void deleteUtilisateur(Utilisateur vUtilisateur);

    /**
     * Retourne le nombre d'utilisateurs dans la base de données.
     *
     * @return Le nombre d'utilisateurs en base de données
     */
    Integer getNbUtilisateur();
}

