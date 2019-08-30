package fr.banane.projet6.model.bean;

import java.util.ArrayList;

/**
 * Objet metier représentant un Spot
 */
public class Spot {

    // ==================== Attributs ====================

    private int id;
    private Utilisateur createur;
    private ArrayList<Secteur> secteurs;
    private int nbreSecteurs;
    private ArrayList<Image> images;
    private boolean officiel;
    private String nom;
    private Departement departement;
    private String adresse;
    private String description;
    private ArrayList<Commentaire> commentaires;

    // ==================== Contructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Spot(){

    }

    /**
     * Constructeur
     * @param id -
     * @param createur -
     * @param secteurs -
     * @param images -
     * @param officiel -
     * @param nom -
     * @param departement -
     * @param adresse -
     * @param description -
     */
    public Spot(int id, Utilisateur createur, ArrayList<Secteur> secteurs, ArrayList<Image> images, boolean officiel,String nom, Departement departement, String adresse, String description, ArrayList<Commentaire> commentaires) {
        this.id = id;
        this.createur = createur;
        this.secteurs = secteurs;
        nbreSecteurs = secteurs.size();
        this.images=images;
        this.officiel = officiel;
        this.nom = nom;
        this.departement = departement;
        this.adresse = adresse;
        this.description = description;
        this.commentaires = commentaires;
    }
    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getCreateur() {
        return createur;
    }

    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    public ArrayList<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(ArrayList<Secteur> secteurs) {
        this.secteurs = secteurs;
        this.nbreSecteurs = this.secteurs.size();
    }

    public int getNbreSecteurs() {
        return nbreSecteurs;
    }

    public void setNbreSecteurs(int nbreSecteurs) {
        this.nbreSecteurs = nbreSecteurs;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public boolean isOfficiel() {
        return officiel;
    }

    public void setOfficiel(boolean officiel) {
        this.officiel = officiel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(ArrayList<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Spot{" +
                "id=" + id +
                ", createur=" + createur +
                ", secteurs=" + secteurs +
                ", images=" + images +
                ", officiel=" + officiel +
                ", nom='" + nom + '\'' +
                ", departement=" + departement +
                ", adresse='" + adresse + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
