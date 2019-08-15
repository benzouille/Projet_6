package fr.banane.projet6.model.bean;

import java.sql.Timestamp;

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
    private Timestamp date_creation;
    private Spot spot;
    private Boolean reservable;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Topo(){
        reservable = false;
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
    public Topo(int id, Utilisateur utilisateur,String nom, String description, Timestamp date_creation, Spot spot, Boolean reservable) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.nom =nom;
        this.description = description;
        this.date_creation = date_creation;
        this.spot = spot;
        this.reservable = reservable;
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

    public Timestamp getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Timestamp date_creation) {
        this.date_creation = date_creation;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Boolean getReservable() {
        return reservable;
    }

    public void setReservable(Boolean reservable) {
        this.reservable = reservable;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", date_creation=" + date_creation +
                ", spot=" + spot +
                ", reservable=" + reservable +
                '}';
    }
}
