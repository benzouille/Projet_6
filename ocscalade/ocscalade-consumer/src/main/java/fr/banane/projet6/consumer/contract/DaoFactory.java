package fr.banane.projet6.consumer.contract;

import fr.banane.projet6.consumer.contract.dao.*;

public interface DaoFactory {

    //------ COMMENTAIRE ------
    DaoCommentaire getDaoCommentaire();
    void setDaoCommentaire(DaoCommentaire pDaoCommentaire);

    //------ LONGUEUR ------
    DaoLongueur getDaoLongueur();
    void setDaoLongueur(DaoLongueur pDaoLongueur);

    //------ SECTEUR ------
    DaoSecteur getDaoSecteur();
    void setDaoSecteur(DaoSecteur pDaoSecteur);

    //------ SPOT ------
    DaoSpot getDaoSpot();
    void setDaoSpot(DaoSpot pDaoSpot);

    //------ TOPO ------
    DaoTopo getDaoTopo();
    void setDaoTopo(DaoTopo pDaoTopo);

    //------ USER ------
    DaoUser getDaoUser();
    void setDaoUser(DaoUser pDaoUser);

    //------ VOIE ------
    DaoVoie getDaoVoie();
    void setDaoVoie(DaoVoie pDaoVoie);

}
