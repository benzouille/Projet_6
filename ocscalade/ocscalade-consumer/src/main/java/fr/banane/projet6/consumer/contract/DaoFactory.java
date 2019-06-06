package fr.banane.projet6.consumer.contract;

import fr.banane.projet6.consumer.contract.dao.*;

public interface DaoFactory {

    //------ COMMENTAIRE ------
    DaoCommentaire getDaoCommentaire();
    void setDaoCommentaire(DaoCommentaire pDaoCommentaire);

    //------ DIFFICULTE ------
    DaoDifficulte getDaoDifficulte();
    void setDaoDifficulte(DaoDifficulte pDaoDifficulte);

    //------ DUREE ------
    DaoDuree getDaoDuree();
    void setDaoDuree(DaoDuree pDaoDuree);

    //------ IMAGE ------
    DaoImage getDaoImage();
    void setDaoImage(DaoImage pDaoImage);

    //------ LONGUEUR ------
    DaoLongueur getDaoLongueur();
    void setDaoLongueur(DaoLongueur pDaoLongueur);

    //------ PRIVILEGE ------
    DaoPrivilege getDaoPrivilege();
    void setDaoPrivilege(DaoPrivilege pDaoPrivilege);

    //------ RESERVATION ------
    DaoReservation getDaoReservation();
    void setDaoReservation(DaoReservation pDaoReservation);

    //------ SECTEUR ------
    DaoSecteur getDaoSecteur();
    void setDaoSecteur(DaoSecteur pDaoSecteur);

    //------ SEXE ------
    DaoSexe getDaoSexe();
    void setDaoSexe(DaoSexe pDaoSexe);

    //------ SPOT ------
    DaoSpot getDaoSpot();
    void setDaoSpot(DaoSpot pDaoSpot);

    //------ TOPO ------
    DaoTopo getDaoTopo();
    void setDaoTopo(DaoTopo pDaoTopo);

    //------ UTILISATEUR------
    DaoUtilisateur getDaoUtilisateur();
    void setDaoUtilisateur(DaoUtilisateur pDaoUtilisateur);

    //------ VOIE ------
    DaoVoie getDaoVoie();
    void setDaoVoie(DaoVoie pDaoVoie);

}
