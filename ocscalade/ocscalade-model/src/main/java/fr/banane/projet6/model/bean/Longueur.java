package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant une Longueur
 *
 * @author Banane
 */
public class Longueur {

    // ==================== Attributs ====================
    private int id;
    private int id_voie;
    private boolean equipement;
    private int nb_point;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Longueur(){
    }

    /**
     * Constructeur
     * @param id
     * @param id_voie
     * @param equipement
     * @param nb_point
     */
    public Longueur (int id, int id_voie, boolean equipement, int nb_point){
        this.id = id;
        this.id_voie = id_voie;
        this.equipement = equipement;
        this.nb_point = nb_point;
    }

    // ==================== Getters/Setters ====================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_voie() {
        return id_voie;
    }

    public void setId_voie(int id_voie) {
        this.id_voie = id_voie;
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

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Longueur{" +
                "id=" + id +
                ", id_voie=" + id_voie +
                ", equipement=" + equipement +
                ", nb_point=" + nb_point +
                '}';
    }
}
