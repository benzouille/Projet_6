package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant une Difficulte
 *
 * @author Banane
 */
public class Difficulte {

    // ==================== Attributs ====================
    private int id;
    private String difficulte;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Difficulte(){
    }

    /**
     * Constructeur
     * @param id -
     * @param difficulte -
     */
    public Difficulte(int id, String difficulte) {
        this.id = id;
        this.difficulte = difficulte;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }


    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Difficulte{" +
                "id=" + id +
                ", difficulte='" + difficulte + '\'' +
                '}';
    }
}
