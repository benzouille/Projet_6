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

    //Objet à injecter
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

    @Override
    public CommentaireManager getCommentaireManager() {
        return commentaireManager;
    }

    @Override
    public void setCommentaireManager(CommentaireManager pVersionManager) {
        this.commentaireManager = pVersionManager;
    }

    @Override
    public DepartementManager getDepartementManager() {
        return departementManager;
    }

    @Override
    public void setDepartementManager(DepartementManager pVersionManager) {
        this.departementManager = pVersionManager;
    }

    @Override
    public DifficulteManager getDifficulteManager() {
        return difficulteManager;
    }

    @Override
    public void setDifficulteManager(DifficulteManager pVersionManager) {
        this.difficulteManager = pVersionManager;
    }

    @Override
    public ImageManager getImageManager() {
        return null;
    }

    @Override
    public void setImageManager(ImageManager pVersionManager) {

    }

    @Override
    public PrivilegeManager getPrivilegeManager() {
        return null;
    }

    @Override
    public void setPrivilegeManager(PrivilegeManager pVersionManager) {

    }

    @Override
    public ReservationManager getReservationManager() {
        return null;
    }

    @Override
    public void setReservationManager(ReservationManager pVersionManager) {

    }

    @Override
    public SecteurManager getSecteurManager() {
        return secteurManager;
    }

    @Override
    public void setSecteurManager(SecteurManager pVersionManager) {
        this.secteurManager = pVersionManager;
    }

    @Override
    public SexeManager getSexeManager() {
        return sexeManager;
    }

    @Override
    public void setSexeManager(SexeManager pVersionManager) {
        this.sexeManager = pVersionManager;
    }

    @Override
    public SpotManager getSpotManager() {
        return spotManager;
    }

    @Override
    public void setSpotManager(SpotManager pVersionManager) {
        this.spotManager = pVersionManager;
    }

    @Override
    public TopoManager getTopoManager() {
        return null;
    }

    @Override
    public void setTopoManager(TopoManager pVersionManager) {

    }

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return utilisateurManager;
    }

    @Override
    public void setUtilisateurManager(UtilisateurManager pVersionManager) {
        this.utilisateurManager = pVersionManager;
    }

    @Override
    public VoieManager getVoieManager() {
        return voieManager;
    }

    @Override
    public void setVoieManager(VoieManager pVersionManager) {
        this.voieManager = pVersionManager;
    }
}
