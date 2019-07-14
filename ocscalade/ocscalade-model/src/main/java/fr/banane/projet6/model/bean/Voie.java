package fr.banane.projet6.model.bean;

import java.util.ArrayList;

/**
 * Objet metier représentant un Topo
 *
 * @author Banane
 */
public class Voie {
    // ==================== Attributs ====================
    private int id;
    private int id_secteur;
    private Difficulte difficulte;
    private boolean equipement;
    private int nb_point;
    private int nb_longueur;
    private String nom;
    private String description;
    private ArrayList<String> images;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Voie(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_secteur -
     * @param difficulte -
     * @param equipement -
     * @param nb_point -
     * @param nb_longueur -
     * @param nom -
     * @param description -
     * @param images
     */
    public Voie(int id, int id_secteur, Difficulte difficulte, boolean equipement, int nb_point, int nb_longueur, String nom, String description, ArrayList<String>images) {
        this.id = id;
        this.id_secteur = id_secteur;
        this.difficulte = difficulte;
        this.equipement = equipement;
        this.nb_point = nb_point;
        this.nb_longueur = nb_longueur;
        this.nom = nom;
        this.description = description;
        this.images = images;
    }
    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_secteur() {
        return id_secteur;
    }

    public void setId_secteur(int id_secteur) {
        this.id_secteur = id_secteur;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    public boolean isEquipement() {
        return equipement;
    }

    public void setEquipement(boolean equipement) {
        this.equipement = equipement;
    }

    public int getNb_point() {
        return nb_point;
    }

    public void setNb_point(int nb_point) {
        this.nb_point = nb_point;
    }

    public int getNb_longueur() {
        return nb_longueur;
    }

    public void setNb_longueur(int nb_longueur) {
        this.nb_longueur = nb_longueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Voie{" +
                "id=" + id +
                ", id_secteur=" + id_secteur +
                ", difficulte=" + difficulte +
                ", equipement=" + equipement +
                ", nb_point=" + nb_point +
                ", nb_longueur=" + nb_longueur +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                '}';
    }
}