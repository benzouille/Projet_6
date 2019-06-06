package fr.banane.projet6.model.bean;

import java.util.ArrayList;

/**
 * Objet metier représentant un Topo
 *
 * @author Banane
 */
public class Topo {
    // ==================== Attributs ====================
    private int id;
    private Utilisateur utilisateur;
    private String nom;
    private String description;
    private String date_creation;
    private ArrayList<Spot> spots;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Topo(){
    }

    /**
     * Constructeur
     * @param id -
     * @param utilisateur -
     * @param nom -
     * @param description -
     * @param date_creation -
     * @param spots -
     */
    public Topo(int id, Utilisateur utilisateur,String nom, String description, String date_creation, ArrayList<Spot> spots) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.nom =nom;
        this.description = description;
        this.date_creation = date_creation;
        this.spots = spots;
    }

    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public ArrayList<Spot> getSpots() {
        return spots;
    }

    public void setSpots(ArrayList<Spot> spots) {
        this.spots = spots;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", Utilisateur=" + utilisateur +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date_creation='" + date_creation + '\'' +
                ", spots=" + spots +
                '}';
    }
}
