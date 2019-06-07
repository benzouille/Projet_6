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
    private Spot spot;

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
     * @param spot -
     */
    public Topo(int id, Utilisateur utilisateur,String nom, String description, String date_creation, Spot spot) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.nom =nom;
        this.description = description;
        this.date_creation = date_creation;
        this.spot = spot;
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

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spots) {
        this.spot = spot;
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
                ", spot=" + spot +
                '}';
    }
}
