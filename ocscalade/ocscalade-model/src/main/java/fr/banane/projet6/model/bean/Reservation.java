package fr.banane.projet6.model.bean;

import java.sql.Timestamp;


/**
 * Objet metier représentant une Reservation
 *
 * @author Banane
 */
public class Reservation {

    // ==================== Attributs ====================
    private int id;
    private Topo topo;
    private Utilisateur locataire;
    private Timestamp date_debut;
    private Timestamp date_fin;
    private String message;
    private boolean accepte;
    private boolean traite;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Reservation(){
    }

    /**
     * Constructeur
     * @param id -
     * @param topo -
     * @param locataire -
     * @param date_debut -
     * @param date_fin -
     * @param message -
     * @param accepte -
     * @param traite -
     */
    public Reservation(int id, Topo topo, Utilisateur locataire, Timestamp date_debut, Timestamp date_fin, String message, boolean accepte, boolean traite) {
        this.id = id;
        this.topo = topo;
        this.locataire = locataire;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.message = message;
        this.accepte = accepte;
        this.traite = traite;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Utilisateur getLocataire() {
        return locataire;
    }

    public void setLocataire(Utilisateur locataire) {
        this.locataire = locataire;
    }

    public Timestamp getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public Timestamp getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Timestamp date_fin) {
        this.date_fin = date_fin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAccepte() {
        return accepte;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }

    public boolean isTraite() {
        return traite;
    }

    public void setTraite(boolean traite) {
        this.traite = traite;
    }

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", topo=" + topo.getNom() +
                ", locataire=" + locataire.getPseudo() +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", message=" + message +
                ", accepte=" + accepte +
                ", traite=" + traite +
                '}';
    }
}
