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
    private int id_topo;
    private int id_user_locataire;
    private Timestamp date_debut;
    private Timestamp date_fin;

    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut
     */
    public Reservation(){
    }

    /**
     * Constructeur
     * @param id -
     * @param id_topo -
     * @param id_user_locataire -
     * @param date_debut -
     * @param date_fin -
     */
    public Reservation(int id, int id_topo, int id_user_locataire, Timestamp date_debut, Timestamp date_fin) {
        this.id = id;
        this.id_topo = id_topo;
        this.id_user_locataire = id_user_locataire;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

// ==================== Getters/Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_topo() {
        return id_topo;
    }

    public void setId_topo(int id_topo) {
        this.id_topo = id_topo;
    }

    public int getId_user_locataire() {
        return id_user_locataire;
    }

    public void setId_user_locataire(int id_user_locataire) {
        this.id_user_locataire = id_user_locataire;
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

    // ==================== Methodes ====================

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", id_topo=" + id_topo +
                ", id_user_locataire=" + id_user_locataire +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }
}
