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
    private ArrayList<Longueur> longueurs;
    private Difficulte difficulte;
    private String nom;
    private String description;

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
     * @param longueurs -
     * @param difficulte -
     * @param nom -
     * @param description -
     */
    public Voie(int id, int id_secteur, ArrayList<Longueur> longueurs, Difficulte difficulte, String nom, String description) {
        this.id = id;
        this.id_secteur = id_secteur;
        this.longueurs = longueurs;
        this.difficulte = difficulte;
        this.nom = nom;
        this.description = description;
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

    public ArrayList<Longueur> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs(ArrayList<Longueur> longueurs) {
        this.longueurs = longueurs;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
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

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Voie{" +
                "id=" + id +
                ", id_secteur=" + id_secteur +
                ", difficulte=" + difficulte +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}