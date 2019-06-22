package fr.banane.projet6.business.contract.manager;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.DuplicateException;
import fr.banane.projet6.model.exception.NotFoundException;

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
    public void newUtilisateur(Utilisateur vUtilisateur);
    //TODO ajouter les exceptions NotFoundException et DuplicateException

    /**
     * Retourne la liste d'utilisateurs.
     *
     * @return Une liste d'utilisateurs.
     */
    public List<Utilisateur> getListUtilisateur();

    /**
     * Retourne un objet Utilisateur en particulier selon son 'id'.
     *
     * @param pId L'identifiant du Bug
     * @return L'objet Bug correspondant à l'identifiant.
     * @throws NotFoundException
     */
    public Utilisateur getUtilisateur(Integer pId);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Retourne un objet Utilisateur en particulier selon son 'pseudo'.
     *
     * @param pseudo Pseudo de Utilisateur
     * @return L'objet Utilisateur correspondant au pseudo.
     * @throws NotFoundException
     */
    public Utilisateur getUtilisateur(String pseudo) throws NotFoundException;

    /**
     * Met à jour un utilisateur.
     * @param vUtilisateur
     */
    public void updateUtilisateur(Utilisateur vUtilisateur);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Supprime un utilisateur
     * @param vUtilisateur
     */
    public void deleteUtilisateur(Utilisateur vUtilisateur);
    //TODO ajouter le throws pour l'exceptions NotFoundException

    /**
     * Retourne le nombre d'utilisateurs dans la base de données.
     *
     * @return Le nombre d'utilisateurs en base de données
     */
    public Integer getNbUtilisateur();

}

