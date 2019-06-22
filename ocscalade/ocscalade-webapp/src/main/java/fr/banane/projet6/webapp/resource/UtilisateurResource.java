package fr.banane.projet6.webapp.resource;

import fr.banane.projet6.model.bean.Utilisateur;
import fr.banane.projet6.model.exception.NotFoundException;

import java.util.List;

public class UtilisateurResource extends AbstractResource {

    public void newUtilisateur(Utilisateur vUtilisateur){
        getManagerFactory().getUtilisateurManager().newUtilisateur(vUtilisateur);
    }

    public List<Utilisateur> getListUtilisateur() {
        return getManagerFactory().getUtilisateurManager().getListUtilisateur();
    }

    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        return getManagerFactory().getUtilisateurManager().getUtilisateur(pId);
    }

    public Utilisateur getUtilisateurByPseudo(String pseudo) {
        Utilisateur vUtilisateur = null;
        try {
            vUtilisateur = getManagerFactory().getUtilisateurManager().getUtilisateur(pseudo);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return vUtilisateur;
    }

    public void updateUtilisateur(Utilisateur vUtilisateur){
        getManagerFactory().getUtilisateurManager().updateUtilisateur(vUtilisateur);
    }

    public void deleteUtilisateur(Utilisateur vUtilisateur){
        getManagerFactory().getUtilisateurManager().deleteUtilisateur(vUtilisateur);
    }

    public boolean utilisateurExist(Utilisateur vUtilisateur) {
        boolean exist = false;
        Utilisateur compare;
        compare = getUtilisateurByPseudo(vUtilisateur.getPseudo());
        try {
            if (compare != null){
                System.out.println("exist false");
            }
            else {
                System.out.println("exist true");
                exist = true;
            }
        }catch (NullPointerException e){
            System.out.println("bam ça pète");
        }


        return exist;
        }
    }

