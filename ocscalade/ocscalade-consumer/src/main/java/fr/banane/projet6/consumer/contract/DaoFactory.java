package fr.banane.projet6.consumer.contract;

import fr.banane.projet6.consumer.contract.dao.*;

/**
 * Interface permetant de faire le lien entre le module business et consumer .
 */
public interface DaoFactory {

    //------ COMMENTAIRE ------
    DaoCommentaire getDaoCommentaire();
    void setDaoCommentaire(DaoCommentaire pDaoCommentaire);

    //------ DEPARTEMENT ------
    DaoDepartement getDaoDepartement();
    void setDaoDepartement(DaoDepartement pDaoDepartement);

    //------ DIFFICULTE ------
    DaoDifficulte getDaoDifficulte();
    void setDaoDifficulte(DaoDifficulte pDaoDifficulte);

    //------ IMAGE ------
    DaoImage getDaoImage();
    void setDaoImage(DaoImage pDaoImage);

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
