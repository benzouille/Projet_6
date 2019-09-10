package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.NotFoundException;
import fr.banane.projet6.model.exception.TechnicalException;

import java.util.List;

/**
 * Classe permettant de manipuler un Objet Utilisateur depuis le module webapp vers le module business
 *
 * @author Banane
 *
 */
public class UtilisateurResource extends AbstractResource {

    /**
     * Envoie un objet Utilisateur au module business
     * @param vUtilisateur objet Utilisateur
     */
    public void newUtilisateur(Utilisateur vUtilisateur){
        getManagerFactory().getUtilisateurManager().newUtilisateur(vUtilisateur);
    }

    /**
     * Retourne une Liste d'objet Utilisateur
     * @return List Utilisateur
     */
    public List<Utilisateur> getListUtilisateur() {
        return getManagerFactory().getUtilisateurManager().getListUtilisateur();
    }

    /**
     * Retourne un objet Utilisateur selon son id
     * @param pId int
     * @return objet Utilisateur
     * @throws TechnicalException ne trouve pas la ressource demandée
     */
    public Utilisateur getUtilisateur(Integer pId) throws TechnicalException{
        return getManagerFactory().getUtilisateurManager().getUtilisateur(pId);
    }

    /**
     * Retourne un objet Utilisateur selon son pseudo
     * @param pseudo String pseudo
     * @return objet Utilisateur
     */
    public Utilisateur getUtilisateurByPseudo(String pseudo) throws TechnicalException {
        return getManagerFactory().getUtilisateurManager().getUtilisateur(pseudo);
    }

    /**
     * Met à jour un objet Utilisateur dans la bdd
     * @param vUtilisateur objet Utilisateur
     */
    public void updateUtilisateur(Utilisateur vUtilisateur){
        getManagerFactory().getUtilisateurManager().updateUtilisateur(vUtilisateur);
    }

    /**
     * Supprime un objet Utilisateur de la bdd
     * @param vUtilisateur objet Utilisateur
     */
    public void deleteUtilisateur(Utilisateur vUtilisateur){
        getManagerFactory().getUtilisateurManager().deleteUtilisateur(vUtilisateur);
    }

    /**
     * Verifie l'existence de l'Utilisateur selon son pseudo
     * @param vUtilisateur objet
     * @return boolean
     */
    public boolean utilisateurExist(Utilisateur vUtilisateur) throws TechnicalException {
        boolean exist = false;
        Utilisateur compare;
        compare = getUtilisateurByPseudo(vUtilisateur.getPseudo());
        try {
            if (compare != null){
            }
            else {
                exist = true;
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return exist;
        }
    }

