package fr.banane.projet6.model.bean;

/**
 * Objet metier représentant un Commentaire
 *
 * @author banane
 */
public class Commentaire {

    // ==================== Attributs ====================
    private int id;
    private Utilisateur utilisateur;
    private  Spot spot;
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
     * @param utilisateur
     * @param spot
     * @param commentaire
     */
    public Commentaire(int id, Utilisateur utilisateur, Spot spot, String commentaire){
        this.id = id;
        this.utilisateur = utilisateur;
        this.spot = spot;
        this.commentaire = commentaire;
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

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
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
                ", user=" + utilisateur +
                ", spot=" + spot +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
