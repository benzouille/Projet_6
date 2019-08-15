package fr.banane.projet6.model.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Objet metier représentant un Commentaire
 *
 * @author banane
 */
public class Commentaire {

    // ==================== Attributs ====================
    private int id;
    private Utilisateur utilisateur;
    private  int id_spot;
    private String commentaire;
    private Timestamp date;

    // ==================== Constructeurs ====================

    /**
     * Constructeur par défaut
     */
    public Commentaire(){
        date = new Timestamp(System.currentTimeMillis());
    }

    /**
     * Constructeur
     * @param id
     * @param utilisateur
     * @param id_spot
     * @param commentaire
     */
    public Commentaire(int id, Utilisateur utilisateur, int id_spot, String commentaire, Timestamp date){
        this.id = id;
        this.utilisateur = utilisateur;
        this.id_spot = id_spot;
        this.commentaire = commentaire;
        this.date = date;
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

    public int getIdSpot() {
        return id_spot;
    }

    public void setIdSpot(int id_spot) {
        this.id_spot = id_spot;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    // ==================== Methodes ====================


    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", utilisateur=" + utilisateur +
                ", id_spot=" + id_spot +
                ", commentaire='" + commentaire + '\'' +
                ", date=" + date +
                '}';
    }
}
