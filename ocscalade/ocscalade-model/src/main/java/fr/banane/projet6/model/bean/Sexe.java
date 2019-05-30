package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un Sexe
 *
 * @author Banane
 */
public class Sexe {

    // ==================== Attributs ====================
    private int id;
    private String sexe;
    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Sexe(){
    }

    public Sexe(int id, String sexe) {
        this.id = id;
        this.sexe = sexe;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Sexe{" +
                "id=" + id +
                ", sexe='" + sexe + '\'' +
                '}';
    }
}
