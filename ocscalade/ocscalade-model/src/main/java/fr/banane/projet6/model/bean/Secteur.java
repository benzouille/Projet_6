package fr.banane.projet6.model.bean;

import java.util.ArrayList;

/**
 * Objet metier représentant un Secteur
 *
 * @author Banane
 */
public class Secteur {

    // ==================== Attributs ====================
    private int id;
    private int id_spot;
    private ArrayList<Voie> voies;
    private String nom;
    private String description;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Secteur(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_spot -
     * @param voies -
     * @param nom -
     * @param description -
     */
    public Secteur(int id, int id_spot, ArrayList<Voie> voies, String nom, String description) {
        this.id = id;
        this.id_spot = id_spot;
        this.voies = voies;
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

    public int getId_spot() {
        return id_spot;
    }

    public void setId_spot(int id_spot) {
        this.id_spot = id_spot;
    }

    public ArrayList<Voie> getVoies() {
        return voies;
    }

    public void setVoies(ArrayList<Voie> voies) {
        this.voies = voies;
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
        return "Secteur{" +
                "id=" + id +
                ", id_spot=" + id_spot +
                ", voies=" + voies +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
