package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un Commentaire
 *
 * @author banane
 */
public class Commentaire {

    // ==================== Attributs ====================
    private int id;
    private int id_user;
    private  int id_spot;
    private String commentaire;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Commentaire(){
    }

    /**
     * Constructeur
     * @param id
     * @param id_user
     * @param id_spot
     * @param commentaire
     */
    public Commentaire(int id, int id_user, int id_spot, String commentaire){
        this.id = id;
        this.id_user = id_user;
        this.id_spot = id_spot;
        this.commentaire = commentaire;
    }

    // ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_spot() {
        return id_spot;
    }

    public void setId_spot(int id_spot) {
        this.id_spot = id_spot;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    // ==================== Methodes ====================


    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_spot=" + id_spot +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
