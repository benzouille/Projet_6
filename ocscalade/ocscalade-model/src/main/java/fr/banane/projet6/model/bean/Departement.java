package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un Departement
 *
 * @author Banane
 */
public class Departement {

    // ==================== Attributs ====================
    private int id;
    private int num;
    private String nom;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Departement(){
    }

    /**
     * Constructeur
     * @param id -
     * @param num -
     * @param nom -
     */
    public Departement(int id, int num, String nom) {
        this.id = id;
        this.num = num;
        this.nom = nom;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", num=" + num +
                ", nom='" + nom + '\'' +
                '}';
    }
}