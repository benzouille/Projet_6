package fr.banane.projet6.consumer.impl;

import fr.banane.projet6.consumer.contract.DaoFactory;
import fr.banane.projet6.consumer.contract.dao.*;
import fr.banane.projet6.consumer.impl.dao.DaoCommentaireImpl;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactory")
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    DaoCommentaire daoCommentaireImpl;

    @Inject
    DaoDepartement daoDepartementImpl;

    @Inject
    DaoDifficulte daoDifficulteImpl;

    @Inject
    DaoImage daoImageImpl;

    @Inject
    DaoPrivilege daoPrivilegeImpl;

    @Inject
    DaoReservation daoReservationImpl;

    @Inject
    DaoSecteur daoSecteurImpl;

    @Inject
    DaoSexe daoSexeImpl;

    @Inject
    DaoSpot daoSpotImpl;

    @Inject
    DaoTopo daoTopoImpl;

    @Inject
    DaoUtilisateur daoUtilisateurImpl;

    @Inject
    DaoVoie daoVoieImpl;

    @Override
    public DaoCommentaire getDaoCommentaire() {
        return daoCommentaireImpl;
    }

    @Override
    public void setDaoCommentaire(DaoCommentaire pDaoCommentaire) {
        this.daoCommentaireImpl = pDaoCommentaire;
    }

    @Override
    public DaoDepartement getDaoDepartement() {
        return daoDepartementImpl;
    }

    @Override
    public void setDaoDepartement(DaoDepartement pDaoDepartement) {
        this.daoDepartementImpl = pDaoDepartement;
    }

    @Override
    public DaoDifficulte getDaoDifficulte() {
        return daoDifficulteImpl;
    }

    @Override
    public void setDaoDifficulte(DaoDifficulte pDaoDifficulte) {
        this.daoDifficulteImpl = pDaoDifficulte;
    }

    @Override
    public DaoImage getDaoImage() {
        return daoImageImpl;
    }

    @Override
    public void setDaoImage(DaoImage pDaoImage) {
        this.daoImageImpl = pDaoImage;
    }

    @Override
    public DaoPrivilege getDaoPrivilege() {
        return daoPrivilegeImpl;
    }

    @Override
    public void setDaoPrivilege(DaoPrivilege pDaoPrivilege) {
        this.daoPrivilegeImpl = pDaoPrivilege;
    }

    @Override
    public DaoReservation getDaoReservation() {
        //return daoReservationImpl;
        return  null;
    }

    @Override
    public void setDaoReservation(DaoReservation pDaoReservation) {
        //this.daoReservationImpl = pDaoReservation;
    }

    @Override
    public DaoSecteur getDaoSecteur() {
        return daoSecteurImpl;
    }

    @Override
    public void setDaoSecteur(DaoSecteur pDaoSecteur) {
        this.daoSecteurImpl = pDaoSecteur;
    }

    @Override
    public DaoSexe getDaoSexe() {
        return daoSexeImpl;
    }

    @Override
    public void setDaoSexe(DaoSexe pDaoSexe) {
        this.daoSexeImpl = pDaoSexe;
    }

    @Override
    public DaoSpot getDaoSpot() {
        return daoSpotImpl;
    }

    @Override
    public void setDaoSpot(DaoSpot pDaoSpot) {
        this.daoSpotImpl = pDaoSpot;
    }

    @Override
    public DaoTopo getDaoTopo() {
        //return daoTopoImpl;
        return null;
    }

    @Override
    public void setDaoTopo(DaoTopo pDaoTopo) {
        //this.daoTopoImpl = pDaoTopo;
    }

    @Override
    public DaoUtilisateur getDaoUtilisateur() {
        return daoUtilisateurImpl;
    }

    @Override
    public void setDaoUtilisateur(DaoUtilisateur pDaoUtilisateur) {
        this.daoUtilisateurImpl = pDaoUtilisateur;
    }

    @Override
    public DaoVoie getDaoVoie() {
        return daoVoieImpl;
    }

    @Override
    public void setDaoVoie(DaoVoie pDaoVoie) {
        this.daoVoieImpl = pDaoVoie;
    }
}
