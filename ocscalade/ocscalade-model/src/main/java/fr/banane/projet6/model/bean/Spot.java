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
    private ArrayList<Image> images;
    private boolean officiel;
    private String nom;
    private int departement;
    private String adresse;
    private String description;

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
    public Spot(int id, Utilisateur createur, ArrayList<Secteur> secteurs, ArrayList<Image> images, boolean officiel,String nom, int departement, String adresse, String description) {
        this.id = id;
        this.createur = createur;
        this.secteurs = secteurs;
        this.images=images;
        this.officiel = officiel;
        this.nom = nom;
        this.departement = departement;
        this.adresse = adresse;
        this.description = description;
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

    public int getDepartement() {
        return departement;
    }

    public void setDepartement(int departement) {
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
