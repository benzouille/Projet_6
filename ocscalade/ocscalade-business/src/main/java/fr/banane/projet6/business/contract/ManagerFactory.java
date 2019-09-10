package fr.banane.projet6.business.contract;

import fr.banane.projet6.business.contract.manager.*;

/**
 * Factory servant à la mise en relation entre la couche webapp et business
 */
public interface ManagerFactory {

    //-- Commentaire
    CommentaireManager getCommentaireManager();
    void setCommentaireManager(CommentaireManager pVersionManager);

    //-- Departement
    DepartementManager getDepartementManager();
    void setDepartementManager(DepartementManager pVersionManager);

    //-- Difficulte
    DifficulteManager getDifficulteManager();
    void setDifficulteManager(DifficulteManager pVersionManager);

    //-- Image
    ImageManager getImageManager();
    void setImageManager(ImageManager pVersionManager);

    //-- Reservation
    ReservationManager getReservationManager();
    void setReservationManager(ReservationManager pVersionManager);

    //-- Secteur
    SecteurManager getSecteurManager();
    void setSecteurManager(SecteurManager pVersionManager);

    //-- Sexe
    SexeManager getSexeManager();
    void setSexeManager(SexeManager pVersionManager);

    //-- Spot
    SpotManager getSpotManager();
    void setSpotManager(SpotManager pVersionManager);

    //-- Topo
    TopoManager getTopoManager();
    void setTopoManager(TopoManager pVersionManager);

    //-- User
    UtilisateurManager getUtilisateurManager();
    void setUtilisateurManager(UtilisateurManager pVersionManager);

    //-- Voie
    VoieManager getVoieManager();
    void setVoieManager(VoieManager pVersionManager);
}