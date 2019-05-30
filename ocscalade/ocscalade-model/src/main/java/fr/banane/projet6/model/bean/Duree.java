package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant une Duree
 *
 * @author Banane
 */
public class Duree {

    // ==================== Attributs ====================
    private int id;
    private String duree;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Duree(){
    }

    /**
     * Constructeur
     * @param id -
     * @param duree -
     */
    public Duree(int id, String duree) {
        this.id = id;
        this.duree = duree;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Duree{" +
                "id=" + id +
                ", duree='" + duree + '\'' +
                '}';
    }
}
