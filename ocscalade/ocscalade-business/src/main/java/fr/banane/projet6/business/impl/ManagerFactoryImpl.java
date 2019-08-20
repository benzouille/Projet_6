package fr.banane.projet6.business.impl;

import fr.banane.projet6.business.contract.ManagerFactory;
import fr.banane.projet6.business.contract.manager.*;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Classe qui retourne des Managers pour toutes les tables de la base de données.
 *
 * @author Banane
 *
 */
@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

    //--Objet à injecter
    @Inject
    private CommentaireManager commentaireManager;
    @Inject
    private DepartementManager departementManager;
    @Inject
    private DifficulteManager difficulteManager;
    @Inject
    private UtilisateurManager utilisateurManager;
    @Inject
    private SexeManager sexeManager;
    @Inject
    private SpotManager spotManager;
    @Inject
    private SecteurManager secteurManager;
    @Inject
    private VoieManager voieManager;
    @Inject
    private TopoManager topoManager;
    @Inject
    private ReservationManager reservationManager;

    //--GETTER-SETTER
    @Override
    public CommentaireManager getCommentaireManager() {
        return commentaireManager;
    }

    @Override
    public void setCommentaireManager(CommentaireManager pManager) {
        this.commentaireManager = pManager;
    }

    @Override
    public DepartementManager getDepartementManager() {
        return departementManager;
    }

    @Override
    public void setDepartementManager(DepartementManager pManager) {
        this.departementManager = pManager;
    }

    @Override
    public DifficulteManager getDifficulteManager() {
        return difficulteManager;
    }

    @Override
    public void setDifficulteManager(DifficulteManager pManager) {
        this.difficulteManager = pManager;
    }

    @Override
    public ImageManager getImageManager() {
        return null;
    }

    @Override
    public void setImageManager(ImageManager pManager) {
        //TODO a remplir
    }

    @Override
    public PrivilegeManager getPrivilegeManager() {
        return null;
    }

    @Override
    public void setPrivilegeManager(PrivilegeManager pManager) {

    }

    @Override
    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    @Override
    public void setReservationManager(ReservationManager pManager) {
        this.reservationManager = pManager;
    }

    @Override
    public SecteurManager getSecteurManager() {
        return secteurManager;
    }

    @Override
    public void setSecteurManager(SecteurManager pManager) {
        this.secteurManager = pManager;
    }

    @Override
    public SexeManager getSexeManager() {
        return sexeManager;
    }

    @Override
    public void setSexeManager(SexeManager pManager) {
        this.sexeManager = pManager;
    }

    @Override
    public SpotManager getSpotManager() {
        return spotManager;
    }

    @Override
    public void setSpotManager(SpotManager pManager) {
        this.spotManager = pManager;
    }

    @Override
    public TopoManager getTopoManager() {
        return topoManager;
    }

    @Override
    public void setTopoManager(TopoManager pManager) {
        this.topoManager = pManager;
    }

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return utilisateurManager;
    }

    @Override
    public void setUtilisateurManager(UtilisateurManager pManager) {
        this.utilisateurManager = pManager;
    }

    @Override
    public VoieManager getVoieManager() {
        return voieManager;
    }

    @Override
    public void setVoieManager(VoieManager pManager) {
        this.voieManager = pManager;
    }
}
