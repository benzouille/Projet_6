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
    public DureeManager getDureeManager() {
        return null;
    }

    @Override
    public void setDureeManager(DureeManager pVersionManager) {

    }

    @Override
    public ImageManager getImageManager() {
        return null;
    }

    @Override
    public void setImageManager(ImageManager pVersionManager) {

    }

    @Override
    public LongueurManager getLongueurManager() {
        return null;
    }

    @Override
    public void setLongueurManager(LongueurManager pVersionManager) {

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
        return null;
    }

    @Override
    public void setSecteurManager(SecteurManager pVersionManager) {

    }

    @Override
    public SexeManager getSexeManager() {
        return null;
    }

    @Override
    public void setSexeManager(SexeManager pVersionManager) {

    }

    @Override
    public SpotManager getSpotManager() {
        return null;
    }

    @Override
    public void setSpotManager(SpotManager pVersionManager) {

    }

    @Override
    public TopoManager getTopoManager() {
        return null;
    }

    @Override
    public void setTopoManager(TopoManager pVersionManager) {

    }

    @Override
    public UtilisateurManager getUserManager() {
        return null;
    }

    @Override
    public void setUserManager(UtilisateurManager pVersionManager) {

    }

    @Override
    public VoieManager getVoieManager() {
        return null;
    }

    @Override
    public void setVoieManager(VoieManager pVersionManager) {

    }
}
