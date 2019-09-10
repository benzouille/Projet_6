package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant une Image
 *
 * @author Banane
 */
public class Image {
    // ==================== Attributs ====================
    private int id;
    private int id_spot;
    private String titre;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Image(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_spot -
     * @param titre -
     */
    public Image (int id, int id_spot, String titre){
        this.id = id;
        this.id_spot = id_spot;
        this.titre = titre;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", id_spot=" + id_spot +
                ", titre='" + titre + '\'' +
                '}';
    }
}
